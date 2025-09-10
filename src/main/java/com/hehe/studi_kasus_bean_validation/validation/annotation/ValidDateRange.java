package com.hehe.studi_kasus_bean_validation.validation.annotation;

import com.hehe.studi_kasus_bean_validation.validation.validator.DateRangeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {DateRangeValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDateRange {

	String message() default "{event.date.range.invalid}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}
