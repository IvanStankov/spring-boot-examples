package com.ivan.mce.proxy;

import com.ivan.mce.controller.ExchangeValue;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ForexServiceProxyFallback implements ForexServiceProxy {

    @Override
    public ExchangeValue getExchangeValue(String from, String to) {
        return new ExchangeValue(from, to, BigDecimal.ZERO);
    }
}
