package com.microservices.currencyexchangeservice.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
public class CurrencyExchange {

    @Id
    private Long id ;
    @Column(name="currency_from")
    private String from ;
    @Column(name="currency_to")
    private String to ;
    private BigDecimal conversionMultiple ;
    private String environment ;

    public CurrencyExchange(){

    }

    public CurrencyExchange(Long id, String from, String to, BigDecimal conversionMultiple) {
        super();
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }
}
