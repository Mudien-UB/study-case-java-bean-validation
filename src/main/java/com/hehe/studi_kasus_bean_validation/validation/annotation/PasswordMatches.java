package com.hehe.studi_kasus_bean_validation.validation.annotation;

import com.hehe.studi_kasus_bean_validation.validation.validator.PasswordMatchesValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordMatches {

	String message() default "{user.confirmPassword.mismatch}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
