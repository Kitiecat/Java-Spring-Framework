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
public class PriceProductValidator implements ConstraintValidator<ValidProductPrice, Prebuilt> {
    @Autowired
    private ApplicationContext context;

    public static  ApplicationContext myContext;

    @Override
    public void initialize(ValidProductPrice constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Prebuilt product, ConstraintValidatorContext constraintValidatorContext) {
        if(context==null) return true;
        if(context!=null)myContext=context;
        PrebuiltService repo = myContext.getBean(PrebuiltServiceImpl.class);
        double sumPartsPrice = 0;
        if (product.getId() != 0) {
            Prebuilt myProduct = repo.findById((int) product.getId());
            for (Part p : myProduct.getParts()) sumPartsPrice = sumPartsPrice + p.getPrice();
            if (product.getPrice() >= sumPartsPrice) {
                return true;
            } else {
                return false;
            }
        }
        else {
            return true;
        }
    }
}
