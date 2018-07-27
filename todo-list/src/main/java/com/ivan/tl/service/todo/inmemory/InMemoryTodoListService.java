package com.ivan.tl.service.todo.inmemory;

import com.ivan.tl.model.TodoItem;
import com.ivan.tl.model.TodoItemId;
import com.ivan.tl.model.TodoItemStatus;
import com.ivan.tl.service.todo.TodoListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Profile("default")
public class InMemoryTodoListService implements TodoListService {
    private static final Logger logger = LoggerFactory.getLogger(InMemoryTodoListService.class);

    private final Map<TodoItemId, TodoItem> items = new HashMap<>();

    @PostConstruct
    public void postConstruct() {
        this.items.put(new TodoItemId(1L), new TodoItem(1L, "Create something", "Create something useful"));
        this.items.put(new TodoItemId(2L), new TodoItem(2L, "Break something", "Break something useless"));
        this.items.put(new TodoItemId(3L), new TodoItem(3L, "Buy something", "Buy something tasty"));
    }

    @Override
    public List<TodoItem> getAllItems() {
        return this.items.values()
                .stream()
                .sorted(Comparator.comparing(TodoItem::getId))
                .collect(Collectors.toList());
    }

    @Override
    public TodoItemId createItem(final TodoItem todoItem) {
        final TodoItemId todoItemId = this.generateItemId();
        todoItem.setId(todoItemId.getId());

        this.items.put(todoItemId, todoItem);

        logger.info("Create new todo item: {}", todoItem);
        return todoItemId;
    }

    @Override
    public void updateItem(final TodoItem todoItem) {
        Assert.notNull(todoItem.getId(), "Item for update must have an id");

        final TodoItem existingItem = this.items.get(new TodoItemId(todoItem.getId()));

        if (existingItem == null) {
            throw new IllegalArgumentException("No todo item found by id " + todoItem.getId());
        }

        logger.info("Request for update existing item with new values: {}", todoItem);

        existingItem.setName(todoItem.getName());
        existingItem.setDescription(todoItem.getDescription());

        logger.info("Existing item has been updated: {}", existingItem);
    }

    @Override
    public TodoItem getItem(TodoItemId itemId) {
        final TodoItem existingItem = this.items.get(itemId);

        if (existingItem == null) {
            throw new IllegalArgumentException("No todo item found by id " + itemId);
        }

        return existingItem;
    }

    @Override
    public void removeItem(TodoItemId itemId) {
        final TodoItem todoItem = this.items.get(itemId);

        if (todoItem == null) {
            throw new IllegalArgumentException("No todo item found by id " + itemId);
        }

        this.items.remove(itemId);

        logger.info("Deleted item {}", itemId);
    }

    @Override
    public void updateStatus(TodoItemId itemId, TodoItemStatus status) {
        final TodoItem todoItem = this.items.get(itemId);

        if (todoItem == null) {
            throw new IllegalArgumentException("No todo item found by id " + itemId);
        }

        todoItem.setDone(status.isDone());

        logger.info("Changed status of item {} to {}", itemId, todoItem.isDone());
    }

    private TodoItemId generateItemId() {
        return new TodoItemId(this.items.keySet()
                .stream()
                .mapToLong(TodoItemId::getId)
                .max()
                .orElse(0L) + 1);
    }
}
