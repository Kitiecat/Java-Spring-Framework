package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import com.example.demo.validators.ValidInventoryMax;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InventoryMaxValidator implements ConstraintValidator<ValidInventoryMax, Part> {

    @Autowired
    private ApplicationContext context;

    public static ApplicationContext myContext;

    @Override
    public void initialize(ValidInventoryMax constraintAnnotation){
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part myPart, ConstraintValidatorContext constraintValidatorContext) {
        if(context==null)return true;
        if(context!=null)myContext=context;
        PartService repo = myContext.getBean(PartServiceImpl.class);
        if(myPart.getInv() > myPart.getInvMax()) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(constraintValidatorContext.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("invMax").addConstraintViolation();
            return false;
        }
        else return true;
    }


}
