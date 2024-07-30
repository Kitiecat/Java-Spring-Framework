package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Prebuilt;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import com.example.demo.service.PrebuiltService;
import com.example.demo.service.PrebuiltServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@Controller
public class BuyPrebuiltController {
    @Autowired
    private ApplicationContext context;
    @GetMapping("/buyprebuilt")
    public String showFormBuyPrebuilt(@RequestParam("prebuiltID") int theId, Model theModel){
        PrebuiltService prebuiltService = context.getBean(PrebuiltServiceImpl.class);
        Prebuilt prebuiltToBuy = prebuiltService.findById(theId);
        if ( prebuiltToBuy.getInv() > 0){
            prebuiltToBuy.decreaseInvByAmount(1);
            prebuiltService.save(prebuiltToBuy);
            return"successfulbuyprebuilt";
        }
        else {
            return"unsuccessfulbuyprebuilt";
        }
    }
}
