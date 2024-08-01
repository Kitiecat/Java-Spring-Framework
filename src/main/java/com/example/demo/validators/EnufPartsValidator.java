package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Prebuilt;
import com.example.demo.service.PrebuiltService;
import com.example.demo.service.PrebuiltServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class EnufPartsValidator implements ConstraintValidator<ValidEnufParts, Prebuilt> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidEnufParts constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Prebuilt prebuilt, ConstraintValidatorContext constraintValidatorContext) {
        if(context==null) return true;
        if(context!=null)myContext=context;
        PrebuiltService repo = myContext.getBean(PrebuiltServiceImpl.class);
        if (prebuilt.getId() != 0) {
            Prebuilt myPrebuilt = repo.findById((int) prebuilt.getId());
            for (Part p : myPrebuilt.getParts()) {
                if (p.getInvMin()<(prebuilt.getInv()-myPrebuilt.getInv()))return false;
            }
            return true;
        }
        else{
                return true;
            }
    }
}
