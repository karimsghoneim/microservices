package com.microservices.currencyconversionservice.controller;

import com.microservices.currencyconversionservice.bean.CurrencyConverion;
import com.microservices.currencyconversionservice.bean.CurrencyExchageProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {

    private final CurrencyExchageProxy currencyExchageProxy;

    public CurrencyConversionController(CurrencyExchageProxy currencyExchageProxy) {
        this.currencyExchageProxy = currencyExchageProxy;
    }

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConverion calcCurrencyConverion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        HashMap<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);

        ResponseEntity<CurrencyConverion> responseEntity = new RestTemplate().getForEntity
                ("http://localhost:8001/currency-exchange/from/{from}/to/{to}", CurrencyConverion.class, uriVariables);
        CurrencyConverion currencyConverion = responseEntity.getBody();

        return new CurrencyConverion(currencyConverion.getId(), from, to, quantity,
                currencyConverion.getConversionMultiple(),
                quantity.multiply(currencyConverion.getConversionMultiple()),
                currencyConverion.getEnvironment());

    }

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConverion calcCurrencyConverionFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {


        CurrencyConverion currencyConverion = currencyExchageProxy.currencyExchange(from,to);

        return new CurrencyConverion(currencyConverion.getId(), from, to, quantity,
                currencyConverion.getConversionMultiple(),
                quantity.multiply(currencyConverion.getConversionMultiple()),
                currencyConverion.getEnvironment() + " " + " feign");

    }
}
