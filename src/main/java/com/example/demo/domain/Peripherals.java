package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 *
 *
 *
 */
@Entity
@DiscriminatorValue("2")
public class Peripherals extends Part{
String peripheralType;

    public Peripherals() {
    }

    public String getPartType() {
        return peripheralType;
    }

    public void setPartType(String companyName) {
        this.peripheralType = companyName;
    }
}
