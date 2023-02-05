package com.microservices.limitsservice.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Limits {
    private int minimum ;
    private int maximum ;

    public Limits(int minimum, int maximum) {
        super();
        this.minimum = minimum;
        this.maximum = maximum;
    }
}
