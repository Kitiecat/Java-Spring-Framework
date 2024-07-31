package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {InventoryMaxValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidInventoryMax {
    String message() default "Inventory is greater than Inventory Maximum!";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
