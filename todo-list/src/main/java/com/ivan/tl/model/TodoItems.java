package com.ivan.tl.model;

import java.util.List;

public class TodoItems {

    private List<TodoItem> todoItems;

    public TodoItems(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    public List<TodoItem> getTodoItems() {
        return todoItems;
    }
}
