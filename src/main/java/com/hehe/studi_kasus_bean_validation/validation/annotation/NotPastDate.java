package com.hehe.studi_kasus_bean_validation.validation.annotation;

import com.hehe.studi_kasus_bean_validation.validation.validator.NotPastDateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotPastDateValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotPastDate {

	String message() default "{date.notpast}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

	boolean includeToday() default true;

}
