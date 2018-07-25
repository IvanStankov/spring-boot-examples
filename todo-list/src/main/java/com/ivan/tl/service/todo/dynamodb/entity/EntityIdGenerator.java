package com.ivan.tl.service.todo.dynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = EntityIdGenerator.TABLE_NAME)
public class EntityIdGenerator {

    public static final String TABLE_NAME = "todo_item_id_generator";

    @DynamoDBHashKey
    private String id;

    @DynamoDBAttribute
    private Long counter;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCounter() {
        return counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }
}
