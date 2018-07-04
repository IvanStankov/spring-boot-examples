package com.ivan.sbe.hw.controller;

import com.ivan.sbe.hw.RandomValues;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomController {

//    @Value("${com.ivan.hw.random.int}")
    private int intValue;
//    @Value("${com.ivan.hw.random.long}")
    private long longValue;
//    @Value("${com.ivan.hw.random.secret}")
    private String secret;
//    @Value("${com.ivan.hw.random.uuid}")
    private String uuid;
//    @Value("${random.less.than.20}")
    private int lessThan20;
//    @Value("${random.range.300.400}")
    private int range300_400;

    @GetMapping("/random-values")
    public RandomValues randomNumbers() {
        final RandomValues randomValues = new RandomValues();
        randomValues.setIntValue(this.intValue);
        randomValues.setLongValue(this.longValue);
        randomValues.setSecret(this.secret);
        randomValues.setUuid(this.uuid);
        randomValues.setLessThan20(this.lessThan20);
        randomValues.setRange300_400(this.range300_400);
        return randomValues;
    }

}
