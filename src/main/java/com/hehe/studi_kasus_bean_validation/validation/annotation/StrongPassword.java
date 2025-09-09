package com.hehe.studi_kasus_bean_validation.validation.annotation;

import com.hehe.studi_kasus_bean_validation.validation.validator.StrongPasswordValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = StrongPasswordValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface StrongPassword {

	String message() default "{user.password.weak}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
