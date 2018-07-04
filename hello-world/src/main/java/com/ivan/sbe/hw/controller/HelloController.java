package com.ivan.sbe.hw.controller;

import com.ivan.sbe.hw.RandomValues;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${com.ivan.hw.name:World}")
    private String name;

    @GetMapping("/hello")
    public String greet() {
        return String.format("Hello, %s!", this.name);
    }
}
