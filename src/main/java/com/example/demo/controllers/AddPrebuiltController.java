package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Prebuilt;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import com.example.demo.service.PrebuiltService;
import com.example.demo.service.PrebuiltServiceImpl;
import com.example.demo.validators.ValidEnufParts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 *
 */

@Controller
public class AddPrebuiltController {
    @Autowired
    private ApplicationContext context;
    private PartService partService;
    private List<Part> theParts;
    private static Prebuilt prebuilt1;
    private Prebuilt prebuilt;

    @GetMapping("/showFormAddPrebuilt")
    public String showFormAddPart(Model theModel) {
        theModel.addAttribute("parts", partService.findAll());
        prebuilt = new Prebuilt();
        prebuilt1=prebuilt;
        theModel.addAttribute("prebuilt", prebuilt);

        List<Part>availParts=new ArrayList<>();
        for(Part p: partService.findAll()){
            if(!prebuilt.getParts().contains(p))availParts.add(p);
        }
        theModel.addAttribute("availparts",availParts);
        theModel.addAttribute("assparts",prebuilt.getParts());
        return "prebuiltForm";
    }

    @PostMapping("/showFormAddPrebuilt")
    public String submitForm(@Valid @ModelAttribute("prebuilt") Prebuilt prebuilt, BindingResult bindingResult, Model theModel) {
        theModel.addAttribute("prebuilt", prebuilt);

        if(bindingResult.hasErrors()){
            PrebuiltService prebuiltService = context.getBean(PrebuiltServiceImpl.class);
            Prebuilt prebuilt2 = new Prebuilt();
            try {
                prebuilt2 = prebuiltService.findById((int) prebuilt.getId());
            } catch (Exception e) {
                System.out.println("Error Message " + e.getMessage());
            }
            theModel.addAttribute("parts", partService.findAll());
            List<Part>availParts=new ArrayList<>();
            for(Part p: partService.findAll()){
                if(!prebuilt2.getParts().contains(p))availParts.add(p);
            }
            theModel.addAttribute("availparts",availParts);
            theModel.addAttribute("assparts",prebuilt2.getParts());
            return "prebuiltForm";
        }
 //       theModel.addAttribute("assparts", assparts);
 //       this.prebuilt=prebuilt;
//        prebuilt.getParts().addAll(assparts);
        else {
            PrebuiltService repo = context.getBean(PrebuiltServiceImpl.class);
            if(prebuilt.getId()!=0) {
                Prebuilt prebuilt2 = repo.findById((int) prebuilt.getId());
                PartService partService1 = context.getBean(PartServiceImpl.class);
                if(prebuilt.getInv()- prebuilt2.getInv()>0) {
                    for (Part p : prebuilt2.getParts()) {
                        int inv = p.getInv();
                        p.setInv(inv - (prebuilt.getInv() - prebuilt2.getInv()));
                        partService1.save(p);
                    }
                }
            }
            else{
                prebuilt.setInv(0);
            }
            repo.save(prebuilt);
            return "confirmationaddprebuilt";
        }
    }

    @GetMapping("/showPrebuiltFormForUpdate")
    public String showPrebuiltFormForUpdate(@RequestParam("prebuiltID") int theId, Model theModel) {
        theModel.addAttribute("parts", partService.findAll());
        PrebuiltService repo = context.getBean(PrebuiltServiceImpl.class);
        Prebuilt thePrebuilt = repo.findById(theId);
        prebuilt1=thePrebuilt;
    //    this.prebuilt=prebuilt;
        //set the employ as a model attibute to prepopulate the form
        theModel.addAttribute("prebuilt", thePrebuilt);
        theModel.addAttribute("assparts",thePrebuilt.getParts());
        List<Part>availParts=new ArrayList<>();
        for(Part p: partService.findAll()){
            if(!thePrebuilt.getParts().contains(p))availParts.add(p);
        }
        theModel.addAttribute("availparts",availParts);
        //send over to our form
        return "prebuiltForm";
    }

    @GetMapping("/deleteprebuilt")
    public String deletePrebuilt(@RequestParam("prebuiltID") int theId, Model theModel) {
        PrebuiltService prebuiltService = context.getBean(PrebuiltServiceImpl.class);
        Prebuilt prebuilt2=prebuiltService.findById(theId);
        for(Part part:prebuilt2.getParts()){
            part.getPrebuilts().remove(prebuilt2);
            partService.save(part);
        }
        prebuilt2.getParts().removeAll(prebuilt2.getParts());
        prebuiltService.save(prebuilt2);
        prebuiltService.deleteById(theId);

        return "confirmationdeleteprebuilt";
    }

    public AddPrebuiltController(PartService partService) {
        this.partService = partService;
    }
// make the add and remove buttons work

    @GetMapping("/associatepart")
    public String associatePart(@Valid @RequestParam("partID") int theID, Model theModel){
    //    theModel.addAttribute("prebuilt", prebuilt);
    //    Prebuilt prebuilt1=new Prebuilt();
        if (prebuilt1.getName()==null) {
            return "saveprebuiltscreen";
        }
        else{
        prebuilt1.getParts().add(partService.findById(theID));
        partService.findById(theID).getPrebuilts().add(prebuilt1);
        PrebuiltService prebuiltService = context.getBean(PrebuiltServiceImpl.class);
        prebuiltService.save(prebuilt1);
        partService.save(partService.findById(theID));
        theModel.addAttribute("prebuilt", prebuilt1);
        theModel.addAttribute("assparts",prebuilt1.getParts());
        List<Part>availParts=new ArrayList<>();
        for(Part p: partService.findAll()){
            if(!prebuilt1.getParts().contains(p))availParts.add(p);
        }
        theModel.addAttribute("availparts",availParts);
        return "prebuiltForm";}
 //        return "confirmationassocpart";
    }
    @GetMapping("/removepart")
    public String removePart(@RequestParam("partID") int theID, Model theModel){
        theModel.addAttribute("prebuilt", prebuilt);
      //  Prebuilt prebuilt1=new Prebuilt();
        prebuilt1.getParts().remove(partService.findById(theID));
        partService.findById(theID).getPrebuilts().remove(prebuilt1);
        PrebuiltService prebuiltService = context.getBean(PrebuiltServiceImpl.class);
        prebuiltService.save(prebuilt1);
        partService.save(partService.findById(theID));
        theModel.addAttribute("prebuilt", prebuilt1);
        theModel.addAttribute("assparts",prebuilt1.getParts());
        List<Part>availParts=new ArrayList<>();
        for(Part p: partService.findAll()){
            if(!prebuilt1.getParts().contains(p))availParts.add(p);
        }
        theModel.addAttribute("availparts",availParts);
        return "prebuiltForm";
    }
}
