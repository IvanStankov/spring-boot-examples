package com.ivan.sbe.hw.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class HelloApplicationRunner implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(HelloApplicationRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("--------------------- HelloApplicationRunner !!!");
    }
}
