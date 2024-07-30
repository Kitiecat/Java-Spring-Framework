package com.example.demo.controllers;

import com.example.demo.domain.InternalPart;
import com.example.demo.service.InternalPartService;
import com.example.demo.service.InternalPartServiceImpl;
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
public class AddInternalPartController{
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showFormAddInPart")
    public String showFormAddInternalPart(Model theModel){
        InternalPart internalpart=new InternalPart();
        theModel.addAttribute("internalpart",internalpart);
        return "InternalPartForm";
    }

    @PostMapping("/showFormAddInPart")
    public String submitForm(@Valid @ModelAttribute("internalpart") InternalPart part, BindingResult theBindingResult, Model theModel){
        theModel.addAttribute("internalpart",part);
        if(theBindingResult.hasErrors()){
            return "InternalPartForm";
        }
        else{
        InternalPartService repo=context.getBean(InternalPartServiceImpl.class);
        InternalPart ip=repo.findById((int)part.getId());
        if(ip!=null)part.setPrebuilts(ip.getPrebuilts());
            repo.save(part);

        return "confirmationaddpart";}
    }

}
