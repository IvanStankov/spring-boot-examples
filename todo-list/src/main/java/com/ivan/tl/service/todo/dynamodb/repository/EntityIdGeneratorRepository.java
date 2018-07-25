package com.ivan.tl.service.todo.dynamodb.repository;

import com.ivan.tl.meta.DynamoDBProfile;
import com.ivan.tl.service.todo.dynamodb.entity.EntityIdGenerator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@DynamoDBProfile
@Repository
public interface EntityIdGeneratorRepository extends CrudRepository<EntityIdGenerator, String>,
        EntityIdGeneratorCustomRepository {


}
