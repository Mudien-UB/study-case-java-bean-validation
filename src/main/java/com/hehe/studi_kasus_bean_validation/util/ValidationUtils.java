package com.hehe.studi_kasus_bean_validation.util;

import jakarta.validation.ConstraintValidatorContext;

public class ValidationUtils {

	public static void addViolation(ConstraintValidatorContext context, String message) {
		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate(message)
				.addConstraintViolation();
	}

}
