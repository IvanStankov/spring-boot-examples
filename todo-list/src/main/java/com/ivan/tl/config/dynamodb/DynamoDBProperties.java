package com.ivan.tl.config.dynamodb;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("dynamodb")
public class DynamoDBProperties {

    private String url;
    private String region;

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(final String region) {
        this.region = region;
    }
}
