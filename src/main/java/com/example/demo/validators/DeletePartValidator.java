package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Prebuilt;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class DeletePartValidator implements ConstraintValidator<ValidDeletePart, Part> {
    @Override
    public void initialize(ValidDeletePart constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if(part.getPrebuilts().isEmpty()) return true;
        else return false;
    }
}
