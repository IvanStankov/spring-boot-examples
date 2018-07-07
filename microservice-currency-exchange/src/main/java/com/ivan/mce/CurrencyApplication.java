package com.ivan.mce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.ivan.mce.proxy")
@EnableDiscoveryClient
@EnableCircuitBreaker
public class CurrencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyApplication.class, args);
    }

}
