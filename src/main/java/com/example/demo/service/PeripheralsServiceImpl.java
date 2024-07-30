package com.example.demo.service;

import com.example.demo.domain.Peripherals;
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
public class PeripheralsServiceImpl implements PeripheralsService{
    private PeripheralsRepository peripheralsRepository;

    @Autowired
    public PeripheralsServiceImpl(PeripheralsRepository peripheralsRepository) {
        this.peripheralsRepository = peripheralsRepository;
    }

    @Override
    public List<Peripherals> findAll() {
        return (List<Peripherals>) peripheralsRepository.findAll();
    }

    @Override
    public Peripherals findById(int theId) {
        Long theIdl=(long)theId;
        Optional<Peripherals> result = peripheralsRepository.findById(theIdl);

        Peripherals thePart = null;

        if (result.isPresent()) {
            thePart = result.get();
        }
        else {
            // we didn't find the OutSourced id
            //throw new RuntimeException("Did not find part id - " + theId);
            return null;
        }

        return thePart;
    }

    @Override
    public void save(Peripherals thePart) {
        peripheralsRepository.save(thePart);

    }

    @Override
    public void deleteById(int theId) {
        Long theIdl=(long)theId;
        peripheralsRepository.deleteById(theIdl);
    }

}
