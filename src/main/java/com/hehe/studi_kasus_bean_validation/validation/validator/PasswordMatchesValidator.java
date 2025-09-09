package com.hehe.studi_kasus_bean_validation.validation.validator;

import com.hehe.studi_kasus_bean_validation.dto.UserRegistrationRequest;
import com.hehe.studi_kasus_bean_validation.validation.annotation.PasswordMatches;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserRegistrationRequest> {

	@Override
	public boolean isValid(UserRegistrationRequest request, ConstraintValidatorContext constraintValidatorContext) {
		if(request == null) return true;

		String password = request.getPassword();
		String confirmPassword = request.getConfirmPassword();

		if(password == null || confirmPassword == null) return true;

		boolean isMatch = password.equals(confirmPassword);

		if(!isMatch) {
			constraintValidatorContext.disableDefaultConstraintViolation();
			constraintValidatorContext.buildConstraintViolationWithTemplate(constraintValidatorContext.getDefaultConstraintMessageTemplate()).addPropertyNode("confirmPassword").addConstraintViolation();
		}

		return isMatch;
	}
}
