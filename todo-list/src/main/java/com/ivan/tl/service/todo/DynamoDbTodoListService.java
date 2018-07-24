package com.ivan.tl.service.todo;

import com.ivan.tl.model.TodoItem;
import com.ivan.tl.model.TodoItemId;
import com.ivan.tl.service.todo.repository.TodoItemRepository;
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

    @Override
    public List<TodoItem> getAllItems() {
        return StreamSupport.stream(this.todoItemRepository.findAll().spliterator(), false)
                    .map(entity -> new TodoItem(entity.getId(), entity.getName(), entity.getDescription()))
                    .collect(Collectors.toList());
    }

    @Override
    public TodoItemId createItem(TodoItem todoItem) {
        return null;
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
