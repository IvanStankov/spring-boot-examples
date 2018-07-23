package com.ivan.tl.controller;

import com.ivan.tl.model.TodoItem;
import com.ivan.tl.model.TodoItemId;
import com.ivan.tl.model.TodoItems;
import com.ivan.tl.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo-list")
public class TodoListController {

    @Autowired
    private TodoListService todoListService;

    @GetMapping
    public TodoItems getAllItems() {
        return new TodoItems(this.todoListService.getAllItems());
    }

    @GetMapping("/{itemId}")
    public TodoItem getItem(@PathVariable final Long itemId) {
        return this.todoListService.getItem(new TodoItemId(itemId));
    }

    @PostMapping
    public TodoItemId createItem(@RequestBody final TodoItem todoItem) {
        return this.todoListService.createItem(todoItem);
    }

    @PutMapping("/{itemId}")
    public void updateItem(@PathVariable final Long itemId, @RequestBody final TodoItem todoItem) {
        todoItem.setId(itemId);
        this.todoListService.updateItem(todoItem);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable final Long itemId) {
        this.todoListService.removeItem(new TodoItemId(itemId));
    }

}
