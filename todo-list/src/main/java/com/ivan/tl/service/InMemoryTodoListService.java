package com.ivan.tl.service;

import com.ivan.tl.model.TodoItem;
import com.ivan.tl.model.TodoItemId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
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

        logger.debug("Create new todo item: {}", todoItem);
        return todoItemId;
    }

    @Override
    public void updateItem(final TodoItem todoItem) {
        Assert.notNull(todoItem.getId(), "Item for update must have an id");

        final TodoItem existingItem = this.items.get(new TodoItemId(todoItem.getId()));

        if (existingItem == null) {
            throw new IllegalArgumentException("No todo item found by id " + todoItem.getId());
        }

        logger.debug("Request for update existing item with new values: {}", todoItem);

        existingItem.setName(todoItem.getName());
        existingItem.setDescription(todoItem.getDescription());

        logger.debug("Existing item has been updated: {}", existingItem);
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

    }

    private TodoItemId generateItemId() {
        return new TodoItemId(this.items.keySet()
                .stream()
                .mapToLong(TodoItemId::getId)
                .max()
                .orElse(0L) + 1);
    }
}