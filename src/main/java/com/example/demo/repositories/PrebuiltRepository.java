package com.example.demo.repositories;

import com.example.demo.domain.Prebuilt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 *
 *
 *
 */
public interface PrebuiltRepository extends CrudRepository<Prebuilt,Long> {
    @Query("SELECT p FROM Prebuilt p WHERE p.name LIKE %?1%")
    public List<Prebuilt> search(String keyword);
}
