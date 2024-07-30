package com.example.demo.service;

import com.example.demo.domain.Peripherals;

import java.util.List;

/**
 *
 *
 *
 *
 */
public interface PeripheralsService {
        public List<Peripherals> findAll();
        public Peripherals findById(int theId);
        public void save (Peripherals thePart);
        public void deleteById(int theId);
}
