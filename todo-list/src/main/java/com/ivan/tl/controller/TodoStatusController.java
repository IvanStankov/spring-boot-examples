package com.ivan.tl.controller;

import com.ivan.tl.model.TodoItemId;
import com.ivan.tl.model.TodoItemStatus;
import com.ivan.tl.service.todo.TodoListService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class TodoStatusController {

    @Inject
    private TodoListService todoListService;

    @PutMapping("/api/todo-list/{itemId}/status")
    public void updateStatus(@PathVariable final Long itemId, @RequestBody final TodoItemStatus status) {
        todoListService.updateStatus(new TodoItemId(itemId), status);
    }

}
