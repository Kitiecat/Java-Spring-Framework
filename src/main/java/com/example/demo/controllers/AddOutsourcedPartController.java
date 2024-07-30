package com.example.demo.controllers;

import com.example.demo.domain.InternalPart;
import com.example.demo.domain.Peripherals;
import com.example.demo.domain.Part;
import com.example.demo.service.PeripheralsService;
import com.example.demo.service.PeripheralsServiceImpl;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 *
 *
 *
 *
 */
@Controller
public class AddOutsourcedPartController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showFormAddOutPart")
    public String showFormAddOutsourcedPart(Model theModel){
        Part part=new Peripherals();
        theModel.addAttribute("outsourcedpart",part);
        return "OutsourcedPartForm";
    }

    @PostMapping("/showFormAddOutPart")
    public String submitForm(@Valid @ModelAttribute("outsourcedpart") Peripherals part, BindingResult bindingResult, Model theModel){
        theModel.addAttribute("outsourcedpart",part);
        if(bindingResult.hasErrors()){
            return "OutsourcedPartForm";
        }
        else{
            PeripheralsServiceImpl repo=context.getBean(PeripheralsServiceImpl.class);
            Peripherals op=repo.findById((int)part.getId());
        if(op!=null)part.setPrebuilts(op.getPrebuilts());
            repo.save(part);
        return "confirmationaddpart";}
    }



}
