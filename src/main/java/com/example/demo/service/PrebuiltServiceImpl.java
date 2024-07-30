package com.example.demo.service;

import com.example.demo.domain.Prebuilt;
import com.example.demo.repositories.PrebuiltRepository;
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
public class PrebuiltServiceImpl implements ProductService{
    private PrebuiltRepository prebuiltRepository;

    @Autowired

    public PrebuiltServiceImpl(PrebuiltRepository productRepository) {
        this.prebuiltRepository = productRepository;
    }

    @Override
    public List<Prebuilt> findAll() {
        return (List<Prebuilt>) prebuiltRepository.findAll();
    }

    @Override
    public Prebuilt findById(int theId) {
        Long theIdl=(long)theId;
        Optional<Prebuilt> result = prebuiltRepository.findById(theIdl);

        Prebuilt theProduct = null;

        if (result.isPresent()) {
            theProduct = result.get();
        }
        else {
            // we didn't find the product id
            throw new RuntimeException("Did not find part id - " + theId);
        }

        return theProduct;
    }

    @Override
    public void save(Prebuilt theProduct) {
        prebuiltRepository.save(theProduct);

    }

    @Override
    public void deleteById(int theId) {
        Long theIdl=(long)theId;
        prebuiltRepository.deleteById(theIdl);
    }
    public List<Prebuilt> listAll(String keyword){
        if(keyword !=null){
            return prebuiltRepository.search(keyword);
        }
        return (List<Prebuilt>) prebuiltRepository.findAll();
    }
}
