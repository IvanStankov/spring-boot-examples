package com.ivan.tl.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoStatusController {



    @PutMapping("/api/todo-list/{itemId}/status")
    public void updateStatus(@PathVariable final Long itemId) {

    }

}
