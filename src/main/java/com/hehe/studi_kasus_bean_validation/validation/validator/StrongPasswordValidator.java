package com.hehe.studi_kasus_bean_validation.validation.validator;

import com.hehe.studi_kasus_bean_validation.util.ValidationUtils;
import com.hehe.studi_kasus_bean_validation.validation.annotation.StrongPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StrongPasswordValidator implements ConstraintValidator<StrongPassword, String> {

	@Override
	public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {

		if(string==null){
			return true;
		}

		boolean isValid = true;

		if(string.length()<8){
			ValidationUtils.addViolation(constraintValidatorContext, "{user.password.invalid.length}");
			isValid = false;
		}
		if(string.chars().noneMatch(Character::isUpperCase)){
			ValidationUtils.addViolation(constraintValidatorContext, "{user.password.invalid.uppercase}");
			isValid = false;
		}
		if(string.chars().noneMatch(Character::isLowerCase)){
			ValidationUtils.addViolation(constraintValidatorContext, "{user.password.invalid.lowercase}");
			isValid = false;
		}
		if(string.chars().noneMatch(Character::isDigit)){
			ValidationUtils.addViolation(constraintValidatorContext, "{user.password.invalid.digit}");
			isValid = false;
		}
		if(!string.matches(".*[^a-zA-Z0-9].*")){
			ValidationUtils.addViolation(constraintValidatorContext, "{user.password.invalid.symbol}");
			isValid = false;
		}

		return isValid;

	}
}
