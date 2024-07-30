package com.example.demo.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Project: demoDarbyFrameworks2-master
 * Package: com.example.demo.domain
 * <p>
 * User: carolyn.sher
 * Date: 6/24/2022
 * Time: 3:44 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
class PeripheralsTest {

    Peripherals op;

    @BeforeEach
    void setUp() {
        op= new Peripherals();
    }

    @Test
    void getPeripheralType() {
        String name="test part type";
        op.setPeripheralType(name);
        assertEquals(name,op.getPeripheralType());
    }

    @Test
    void setPeripheralType() {
        String name="test part type";
        op.setPeripheralType(name);
        assertEquals(name,op.getPeripheralType());
    }
}