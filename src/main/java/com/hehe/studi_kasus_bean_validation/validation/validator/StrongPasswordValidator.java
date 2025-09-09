package com.hehe.studi_kasus_bean_validation.validation.validator;

import com.hehe.studi_kasus_bean_validation.validation.annotation.StrongPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StrongPasswordValidator implements ConstraintValidator<StrongPassword, String> {

	@Override
	public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {

		if(string==null){
			return true;
		}

		return
				string.length() >= 8
				&&  string.chars().anyMatch(Character::isLowerCase)
				&&  string.chars().anyMatch(Character::isDigit)
				&&  string.chars().anyMatch(Character::isUpperCase)
				&&  string.matches(".*[^a-zA-Z0-9].*");
	}
}
