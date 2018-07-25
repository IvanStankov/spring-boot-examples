package com.ivan.tl.service.todo.dynamodb.repository;

public interface EntityIdGeneratorCustomRepository {

    Long incrementCounter(String id);

}
