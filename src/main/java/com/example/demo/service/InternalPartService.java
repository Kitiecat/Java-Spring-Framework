package com.example.demo.service;


import com.example.demo.domain.InternalPart;

import java.util.List;

/**
 *
 *
 *
 *
 */
public interface InternalPartService {
    public List<InternalPart> findAll();
    public InternalPart findById(int theId);
    public void save (InternalPart thePart);
    public void deleteById(int theId);
}
