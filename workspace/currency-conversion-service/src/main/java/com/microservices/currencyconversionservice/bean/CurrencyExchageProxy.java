package com.microservices.currencyconversionservice.bean;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange",url = "http://localhost:8000")
@FeignClient(name="currency-exchange")
public interface CurrencyExchageProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConverion currencyExchange (@PathVariable String from , @PathVariable String to );

    }

