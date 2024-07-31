package com.example.demo.controllers;

import com.example.demo.domain.Peripherals;
import com.example.demo.domain.Part;
import com.example.demo.service.PeripheralsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 *
 *
 *
 *
 */
@Controller
public class AddPeripheralsPartController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showFormAddPeripheralsPart")
    public String showFormAddPeripheralsPart(Model theModel){
        Part part=new Peripherals();
        theModel.addAttribute("peripheralspart",part);
        return "PeripheralsPartForm";
    }

    @PostMapping("/showFormAddPeripheralsPart")
    public String submitForm(@Valid @ModelAttribute("peripheralspart") Peripherals peripheral, BindingResult bindingResult, Model theModel){
        theModel.addAttribute("peripheralspart",peripheral);
        if(bindingResult.hasErrors()){
            return "PeripheralsPartForm";
        }
        else{
            PeripheralsServiceImpl repo=context.getBean(PeripheralsServiceImpl.class);
            Peripherals op=repo.findById((int)peripheral.getId());
        if(op!=null)peripheral.setPrebuilts(op.getPrebuilts());
            repo.save(peripheral);
        return "confirmationaddpart";}
    }



}
