package com.ivan.mf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Random;

@RestController
public class ForexController {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue getExchange(@PathVariable final String from, @PathVariable final String to) {
        final ExchangeValue exchangeValue = new ExchangeValue();
        exchangeValue.setFrom(from);
        exchangeValue.setTo(to);
        exchangeValue.setConversionMultiple(BigDecimal.valueOf(new Random().nextInt(1000)));
        return exchangeValue;
    }

}
