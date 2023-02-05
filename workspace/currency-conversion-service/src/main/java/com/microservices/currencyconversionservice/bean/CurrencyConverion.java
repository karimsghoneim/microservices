package com.microservices.currencyconversionservice.bean;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class CurrencyConverion {

    private Long id ;
    private String from ;
    private String to ;
    private BigDecimal quantity;
    private BigDecimal conversionMultiple ;
    private BigDecimal totalCalculateAmount ;
    private String environment ;

    public CurrencyConverion() {
    }

    public CurrencyConverion(Long id, String from, String to, BigDecimal quantity, BigDecimal conversionMultiple, BigDecimal totalCalculateAmount, String environment) {
        super();
        this.id = id;
        this.from = from;
        this.to = to;
        this.quantity = quantity;
        this.conversionMultiple = conversionMultiple;
        this.totalCalculateAmount = totalCalculateAmount;
        this.environment = environment;
    }
}
