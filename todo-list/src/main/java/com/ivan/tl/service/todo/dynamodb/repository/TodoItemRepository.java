package com.ivan.tl.service.todo.dynamodb.repository;

import com.ivan.tl.service.todo.dynamodb.entity.TodoItemEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Profile("DynamoDB")
@EnableScan
@Repository
public interface TodoItemRepository extends CrudRepository<TodoItemEntity, Long> {
}
