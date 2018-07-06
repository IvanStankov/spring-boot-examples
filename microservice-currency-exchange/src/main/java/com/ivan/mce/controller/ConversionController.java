package com.ivan.mce.controller;

import com.ivan.mce.proxy.ForexServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class ConversionController {

    @Autowired
    private ForexServiceProxy forexServiceProxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public ConversionResult convertCurrency(@PathVariable final String from, @PathVariable final String to,
                                @PathVariable final BigDecimal quantity) {

        final ExchangeValue exchangeValue = this.forexServiceProxy.getExchangeValue(from, to);

        return new ConversionResult(quantity, exchangeValue.getConversionMultiple(), quantity.multiply(exchangeValue.getConversionMultiple()));
    }

}
