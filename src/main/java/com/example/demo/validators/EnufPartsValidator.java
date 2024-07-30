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
    public boolean isValid(Prebuilt product, ConstraintValidatorContext constraintValidatorContext) {
        if(context==null) return true;
        if(context!=null)myContext=context;
        PrebuiltService repo = myContext.getBean(PrebuiltServiceImpl.class);
        if (product.getId() != 0) {
            Prebuilt myProduct = repo.findById((int) product.getId());
            for (Part p : myProduct.getParts()) {
                if (p.getInv()<(product.getInv()-myProduct.getInv()))return false;
            }
            return true;
        }
        else{
                return true;
            }
    }
}
