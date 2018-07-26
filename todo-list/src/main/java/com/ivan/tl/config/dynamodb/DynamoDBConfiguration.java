package com.ivan.tl.config.dynamodb;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.ivan.tl.meta.DynamoDBProfile;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.ivan.tl.service")
@DynamoDBProfile
@EnableConfigurationProperties(DynamoDBProperties.class)
public class DynamoDBConfiguration {

    @Autowired
    private DynamoDBProperties dynamoDBProperties;

    @Bean
    public AmazonDynamoDB amazonDynamoDB(final AWSCredentialsProvider awsCredentialsProvider) {
        return AmazonDynamoDBClientBuilder.standard()
                .withCredentials(awsCredentialsProvider)
                .withEndpointConfiguration(new EndpointConfiguration(this.dynamoDBProperties.getUrl(), this.dynamoDBProperties.getRegion()))
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
