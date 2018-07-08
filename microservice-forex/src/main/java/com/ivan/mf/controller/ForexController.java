package com.ivan.mf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;

@RestController
public class ForexController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue getExchange(@PathVariable final String from, @PathVariable final String to, final Authentication authentication) {
        final ExchangeValue exchangeValue = new ExchangeValue();
        exchangeValue.setFrom(from);
        exchangeValue.setTo(to);
        exchangeValue.setConversionMultiple(BigDecimal.valueOf(new Random().nextInt(1000)));
        exchangeValue.setPort(this.port);
        exchangeValue.setOgranization((String) this.getExtraInfo(authentication).get("organization"));
        return exchangeValue;
    }

    private Map<String, Object> getExtraInfo(final Authentication authentication) {
        final OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        return (Map<String, Object>) details.getDecodedDetails();
    }
}
