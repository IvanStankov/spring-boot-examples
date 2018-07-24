package com.ivan.tl.config.dynamodb;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.ivan.tl.service.todo.repository.TodoItemEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

public class DynamoDBInitializer implements ApplicationListener<ApplicationStartedEvent> {
    private static final Logger logger = LoggerFactory.getLogger(DynamoDBInitializer.class);

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Override
    public void onApplicationEvent(final ApplicationStartedEvent event) {
        logger.info("Initializing DynamoDB...");

        final DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(this.amazonDynamoDB);

        final DynamoDB dynamoDB = new DynamoDB(this.amazonDynamoDB);

        final ListTablesResult listTablesResult = this.amazonDynamoDB.listTables(new ListTablesRequest()
                .withExclusiveStartTableName(TodoItemEntity.TABLE_NAME));

        if (!listTablesResult.getTableNames().contains(TodoItemEntity.TABLE_NAME)) {
            logger.info("Tables already exist");
            return;
        }

        this.amazonDynamoDB.createTable(dynamoDBMapper
                .generateCreateTableRequest(TodoItemEntity.class)
                .withProvisionedThroughput(new ProvisionedThroughput(100L, 100L)));

        dynamoDB.getTable(TodoItemEntity.TABLE_NAME)
                .putItem(new Item().withPrimaryKey("id", 1L)
                        .withString("name", "Create")
                        .withString("description", "Create something"));
    }
}
