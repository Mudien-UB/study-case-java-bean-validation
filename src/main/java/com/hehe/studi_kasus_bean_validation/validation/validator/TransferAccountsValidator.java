package com.hehe.studi_kasus_bean_validation.validation.validator;

import com.hehe.studi_kasus_bean_validation.validation.annotation.ValidTransferAccount;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;
import jakarta.validation.constraintvalidation.ValidationTarget;
import org.springframework.util.StringUtils;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class TransferAccountsValidator implements ConstraintValidator<ValidTransferAccount, Object[]> {


	@Override
	public boolean isValid(Object[] args, ConstraintValidatorContext context) {

		System.out.println("=== INI DIPANGGIL ===");

		String from = (String) args[0];
		String to = (String) args[1];

		System.out.println("FROM: " + from
		+ " TO: " + to);

		if(from == null || to == null) return true;

		var isValid = from.equals(to);
		System.out.println("IS VALID: " + !isValid);
		return !isValid;

	}
}



