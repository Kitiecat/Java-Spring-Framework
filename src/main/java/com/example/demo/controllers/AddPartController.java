package com.example.demo.controllers;

import com.example.demo.domain.InternalPart;
import com.example.demo.domain.Peripherals;
import com.example.demo.domain.Part;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *
 *
 *
 *
 */
@Controller
public class AddPartController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showPartFormForUpdate")
    public String showPartFormForUpdate(@RequestParam("partID") int theId,Model theModel){

        PartService repo=context.getBean(PartServiceImpl.class);
        PeripheralsService outsourcedrepo=context.getBean(PeripheralsServiceImpl.class);
        InternalPartService inhouserepo=context.getBean(InternalPartServiceImpl.class);

        boolean internalComponent=true;
        List<Peripherals> outsourcedParts=outsourcedrepo.findAll();
        for(Peripherals outsourcedPart:outsourcedParts) {
            if(outsourcedPart.getId()==theId)internalComponent=false;
        }
        String formtype;
        if(internalComponent){
            InternalPart inhousePart=inhouserepo.findById(theId);
            theModel.addAttribute("inhousepart",inhousePart);
            formtype="InternalPartForm";
        }
        else{
            Peripherals outsourcedPart=outsourcedrepo.findById(theId);
            theModel.addAttribute("outsourcedpart",outsourcedPart);
            formtype="OutsourcedPartForm";
        }
        return formtype;
    }

    @GetMapping("/deletepart")
    public String deletePart(@Valid @RequestParam("partID") int theId,  Model theModel){
        PartService repo = context.getBean(PartServiceImpl.class);
        Part part=repo.findById(theId);
        if(part.getPrebuilts().isEmpty()){
            repo.deleteById(theId);
            return "confirmationdeletepart";
        }
        else{
            return "negativeerror";
        }
    }

}
