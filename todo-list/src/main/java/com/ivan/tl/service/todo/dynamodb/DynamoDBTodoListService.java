package com.ivan.tl.service.todo.dynamodb;

import com.ivan.tl.meta.DynamoDBProfile;
import com.ivan.tl.model.TodoItem;
import com.ivan.tl.model.TodoItemId;
import com.ivan.tl.service.todo.TodoListService;
import com.ivan.tl.service.todo.dynamodb.entity.TodoItemEntity;
import com.ivan.tl.service.todo.dynamodb.repository.EntityIdGeneratorRepository;
import com.ivan.tl.service.todo.dynamodb.repository.TodoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@DynamoDBProfile
public class DynamoDBTodoListService implements TodoListService {
    private static final Logger logger = LoggerFactory.getLogger(DynamoDBTodoListService.class);

    private final TodoItemRepository todoItemRepository;
    private final EntityIdGeneratorRepository entityIdGeneratorRepository;

    public DynamoDBTodoListService(TodoItemRepository todoItemRepository, EntityIdGeneratorRepository entityIdGeneratorRepository) {
        this.todoItemRepository = todoItemRepository;
        this.entityIdGeneratorRepository = entityIdGeneratorRepository;
    }

    @Override
    public List<TodoItem> getAllItems() {
        return StreamSupport.stream(this.todoItemRepository.findAll().spliterator(), false)
                    .map(entity -> new TodoItem(entity.getId(), entity.getName(), entity.getDescription(), entity.isDone()))
                    .collect(Collectors.toList());
    }

    @Override
    public TodoItemId createItem(final TodoItem todoItem) {
        Assert.notNull(todoItem, "Todo item must not be null");

        final Long newId = this.entityIdGeneratorRepository.incrementCounter(TodoItemEntity.TABLE_NAME);

        final TodoItemEntity todoItemEntity = new TodoItemEntity();
        todoItemEntity.setId(newId);
        todoItemEntity.setName(todoItem.getName());
        todoItemEntity.setDescription(todoItem.getDescription());

        this.todoItemRepository.save(todoItemEntity);
        logger.info("Created todo item - {}", todoItemEntity);

        return new TodoItemId(newId);
    }

    @Override
    public void updateItem(final TodoItem todoItem) {
        Assert.notNull(todoItem, "Todo item must not be null");
        Assert.notNull(todoItem.getId(), "Todo item id must not be null");

        final TodoItemEntity savedItem = this.todoItemRepository.findById(todoItem.getId())
                .orElseThrow(IllegalStateException::new);
        savedItem.setName(todoItem.getName());
        savedItem.setDescription(todoItem.getDescription());
        savedItem.setDone(todoItem.isDone());

        this.todoItemRepository.save(savedItem);

        logger.info("Todo item has been updated - {}", savedItem);
    }

    @Override
    public TodoItem getItem(final TodoItemId itemId) {
        Assert.isTrue(TodoItemId.isNotEmpty(itemId), "Todo item id must not be null");

        final TodoItemEntity todoItemEntity = this.todoItemRepository.findById(itemId.getId())
                .orElseThrow(IllegalStateException::new);

        return new TodoItem(todoItemEntity.getId(), todoItemEntity.getName(), todoItemEntity.getDescription(), todoItemEntity.isDone());
    }

    @Override
    public void removeItem(final TodoItemId itemId) {
        Assert.isTrue(TodoItemId.isNotEmpty(itemId), "Todo item id must not be null");

        todoItemRepository.deleteById(itemId.getId());
        logger.info("Todo item has been deleted - {}", itemId);
    }

    @Override
    public void toggleStatus(final TodoItemId itemId) {
        Assert.isTrue(TodoItemId.isNotEmpty(itemId), "Todo item id must not be null");

        final TodoItemEntity todoItemEntity = todoItemRepository.findById(itemId.getId())
                .orElseThrow(IllegalArgumentException::new);

        todoItemEntity.setDone(!todoItemEntity.isDone());
        this.todoItemRepository.save(todoItemEntity);

        logger.info("Todo item({}) status has been changed to {}", itemId, todoItemEntity.isDone());
    }
}
