package com.ivan.tl.service.todo.dynamodb.repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;
import com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
import com.google.common.collect.ImmutableMap;
import com.ivan.tl.service.todo.dynamodb.entity.EntityIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class EntityIdGeneratorCustomRepositoryImpl implements EntityIdGeneratorCustomRepository {

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Override
    public Long incrementCounter(final String id) {

        final UpdateItemResult result = this.amazonDynamoDB.updateItem(new UpdateItemRequest()
                .withTableName(EntityIdGenerator.TABLE_NAME)
                .withKey(ImmutableMap.of("id", new AttributeValue(id)))
                .withUpdateExpression("ADD #c :x")
                .withExpressionAttributeNames(ImmutableMap.of("#c", "counter"))
                .withExpressionAttributeValues(ImmutableMap.of(":x", new AttributeValue().withN("1")))
                .withReturnValues(ReturnValue.UPDATED_NEW));

        final Map<String, AttributeValue> attributes = result.getAttributes();

        return Long.valueOf(attributes.get("counter").getN());
    }
}
