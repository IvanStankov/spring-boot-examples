package com.ivan.tl.service.todo.dynamodb;

import com.ivan.tl.model.TodoItem;
import com.ivan.tl.model.TodoItemId;
import com.ivan.tl.service.todo.TodoListService;
import com.ivan.tl.service.todo.dynamodb.entity.TodoItemEntity;
import com.ivan.tl.service.todo.dynamodb.repository.EntityIdGeneratorRepository;
import com.ivan.tl.service.todo.dynamodb.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("DynamoDB")
public class DynamoDbTodoListService implements TodoListService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    @Autowired
    private EntityIdGeneratorRepository entityIdGeneratorRepository;

    @Override
    public List<TodoItem> getAllItems() {
        return StreamSupport.stream(this.todoItemRepository.findAll().spliterator(), false)
                    .map(entity -> new TodoItem(entity.getId(), entity.getName(), entity.getDescription()))
                    .collect(Collectors.toList());
    }

    @Override
    public TodoItemId createItem(TodoItem todoItem) {
        final Long newId = this.entityIdGeneratorRepository.incrementCounter(TodoItemEntity.TABLE_NAME);

        final TodoItemEntity todoItemEntity = new TodoItemEntity();
        todoItemEntity.setId(newId);
        todoItemEntity.setName(todoItem.getName());
        todoItemEntity.setDescription(todoItem.getDescription());

        this.todoItemRepository.save(todoItemEntity);

        return new TodoItemId(newId);
    }

    @Override
    public void updateItem(TodoItem todoItem) {

    }

    @Override
    public TodoItem getItem(TodoItemId itemId) {
        return null;
    }

    @Override
    public void removeItem(TodoItemId itemId) {

    }
}
