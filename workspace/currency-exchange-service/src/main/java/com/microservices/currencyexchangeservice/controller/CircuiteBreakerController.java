package com.microservices.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class CircuiteBreakerController {

    private Logger logger =
           LoggerFactory.getLogger(CircuiteBreakerController.class);

    @GetMapping("/sample-api")
//    @Retry(name = "sample-api",fallbackMethod = "hardcodedResponse")
//    @CircuitBreaker(name="defult",fallbackMethod = "hardcodedResponse")
//    @RateLimiter(name = "defult")
    @Bulkhead(name = "defult")
    public String sampleApi() {
        logger.info("Sample Api call received");
        ResponseEntity<String> forEntity
                = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url"
                    , String.class);
        return forEntity.getBody();
    }

    public String hardcodedResponse(Exception ex){
        return "fallback-response";
    }

}
