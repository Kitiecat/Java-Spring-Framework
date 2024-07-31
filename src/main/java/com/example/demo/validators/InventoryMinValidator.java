package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InventoryMinValidator implements ConstraintValidator<ValidInventoryMin, Part> {

    @Autowired
    private ApplicationContext context;

    public static ApplicationContext myContext;

    @Override
    public void initialize(ValidInventoryMin constraintAnnotation){
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part myPart, ConstraintValidatorContext constraintValidatorContext) {
        if(context==null)return true;
        if(context!=null)myContext=context;
        PartService repo = myContext.getBean(PartServiceImpl.class);
        if(myPart.getInv() < myPart.getInvMin()) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(constraintValidatorContext.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("invMin").addConstraintViolation();
            return false;
        }
        else return true;
    }


}
