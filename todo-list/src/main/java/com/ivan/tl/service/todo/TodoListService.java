package com.ivan.tl.service.todo;

import com.ivan.tl.model.TodoItem;
import com.ivan.tl.model.TodoItemId;

import java.util.List;

public interface TodoListService {

    List<TodoItem> getAllItems();

    TodoItemId createItem(TodoItem todoItem);

    void updateItem(TodoItem todoItem);

    TodoItem getItem(TodoItemId itemId);

    void removeItem(TodoItemId itemId);

    void toggleStatus(TodoItemId itemId);

}
