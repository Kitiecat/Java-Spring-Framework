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
@DiscriminatorValue("1")
public class InternalPart extends Part{
    int partId;

    public InternalPart() {
    }

    public InternalPart(String name, double price, int inv) {
        this.name = name;
        this.price = price;
        this.inv = inv;
    }

    public InternalPart(long id, String name, double price, int inv) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inv = inv;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }
}
