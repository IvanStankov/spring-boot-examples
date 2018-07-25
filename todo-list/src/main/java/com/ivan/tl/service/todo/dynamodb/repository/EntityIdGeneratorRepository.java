package com.ivan.tl.service.todo.dynamodb.repository;

import com.ivan.tl.service.todo.dynamodb.entity.EntityIdGenerator;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Profile("DynamoDB")
@Repository
public interface EntityIdGeneratorRepository extends CrudRepository<EntityIdGenerator, String>,
        EntityIdGeneratorCustomRepository {


}
