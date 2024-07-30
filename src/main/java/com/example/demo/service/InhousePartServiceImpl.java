package com.example.demo.service;


import com.example.demo.domain.InternalPart;
import com.example.demo.domain.Peripherals;
import com.example.demo.repositories.InternalPartRepository;
import com.example.demo.repositories.PeripheralsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Service
public class InhousePartServiceImpl implements InternalPartService {
    private InternalPartRepository partRepository;

    @Autowired
    public InhousePartServiceImpl(InternalPartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public List<InternalPart> findAll() {
        return (List<InternalPart>) partRepository.findAll();
    }

    @Override
    public InternalPart findById(int theId) {
        Long theIdl=(long)theId;
        Optional<InternalPart> result = partRepository.findById(theIdl);

        InternalPart thePart = null;

        if (result.isPresent()) {
            thePart = result.get();
        }
        else {
            // we didn't find the InhousePart id
            //throw new RuntimeException("Did not find part id - " + theId);
            return null;
        }

        return thePart;
    }

    @Override
    public void save(InternalPart thePart) {
        partRepository.save(thePart);

    }

    @Override
    public void deleteById(int theId) {
        Long theIdl=(long)theId;
        partRepository.deleteById(theIdl);
    }

}
