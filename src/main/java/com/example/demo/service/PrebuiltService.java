package com.example.demo.service;

import com.example.demo.domain.Prebuilt;

import java.util.List;

/**
 *
 *
 *
 *
 */
public interface PrebuiltService {
    public List<Prebuilt> findAll();
    public Prebuilt findById(int theId);
    public void save (Prebuilt theProduct);
    public void deleteById(int theId);
    public List<Prebuilt> listAll(String keyword);

}
