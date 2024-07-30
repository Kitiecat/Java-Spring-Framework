package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Prebuilt;
import com.example.demo.service.PartService;
import com.example.demo.service.PrebuiltService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 *
 *
 *
 *
 */

@Controller
public class MainScreenControllerr {
   // private final PartRepository partRepository;
   // private final ProductRepository prebuiltRepository;'

    private PartService partService;
    private PrebuiltService prebuiltService;

    private List<Part> theParts;
    private List<Prebuilt> theProducts;

 /*   public MainScreenControllerr(PartRepository partRepository, ProductRepository prebuiltRepository) {
        this.partRepository = partRepository;
        this.prebuiltRepository = prebuiltRepository;
    }*/

    public MainScreenControllerr(PartService partService,PrebuiltService prebuiltService){
        this.partService=partService;
        this.prebuiltService=prebuiltService;
    }
    @GetMapping("/mainscreen")
    public String listPartsandProducts(Model theModel, @Param("partkeyword") String partkeyword, @Param("prebuiltkeyword") String prebuiltkeyword){
        //add to the sprig model
        List<Part> partList=partService.listAll(partkeyword);
        theModel.addAttribute("parts",partList);
        theModel.addAttribute("partkeyword",partkeyword);
    //    theModel.addAttribute("prebuilts",prebuiltService.findAll());
        List<Prebuilt> prebuiltListList=prebuiltService.listAll(prebuiltkeyword);
        theModel.addAttribute("prebuilts", prebuiltListList);
        theModel.addAttribute("prebuiltkeyword",prebuiltkeyword);
        return "mainscreen";
    }
}
