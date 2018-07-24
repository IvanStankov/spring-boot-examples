package com.ivan.tl.config.dynamodb;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.ivan.tl.service")
@Profile("DynamoDB")
public class DynamoDBConfiguration {

    @Value("${dynamodb.url}")
    private String endpoint;

    @Bean
    public AmazonDynamoDB amazonDynamoDB(final AWSCredentialsProvider awsCredentialsProvider) {
        return AmazonDynamoDBClientBuilder.standard()
                .withCredentials(awsCredentialsProvider)
                .withEndpointConfiguration(new EndpointConfiguration(this.endpoint, "us-east-1"))
                .build();
    }

    @Bean
    public AWSCredentialsProvider awsCredentialsProvider() {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials("", ""));
    }

    @Bean
    public DynamoDBInitializer dynamoDBInitializer() {
        return new DynamoDBInitializer();
    }

}
