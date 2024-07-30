package com.example.demo.service;

import com.example.demo.domain.InternalPart;
import com.example.demo.repositories.InternalPartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Project: demo
 * Package: com.example.demo.service
 * <p>
 * User: carolyn.sher
 * Date: 5/3/2022
 * Time: 11:36 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
class InternalPartServiceTest {
    InternalPartRepository internalPartRepository;
    InternalPartService internalPartService;
    @BeforeEach
    void setUp() {
        internalPartRepository=mock(InternalPartRepository.class);
        internalPartService=new InhousePartServiceImpl(internalPartRepository);
    }

    @Test
    void findAll() {
        InternalPart part=new InternalPart();
        List partData=new ArrayList();
        partData.add(part);
        when(internalPartRepository.findAll()).thenReturn(partData);
        List<InternalPart> parts=internalPartService.findAll();
        assertEquals(partData.size(),1);
    }
}