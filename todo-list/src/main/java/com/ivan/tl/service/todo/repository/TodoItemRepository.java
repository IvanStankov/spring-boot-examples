package com.ivan.tl.service.todo.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@EnableScan
@Profile("DynamoDB")
public interface TodoItemRepository extends CrudRepository<TodoItemEntity, Long> {
}
