package com.ivan.mce.service;

import com.ivan.mce.controller.ExchangeValue;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "forex-service")
@RibbonClient(name = "forex-service")
public interface ForexServiceProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to);

}
