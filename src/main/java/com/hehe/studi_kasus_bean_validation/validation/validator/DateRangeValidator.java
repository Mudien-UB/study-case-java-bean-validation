package com.hehe.studi_kasus_bean_validation.validation.validator;

import com.hehe.studi_kasus_bean_validation.dto.EventRequest;
import com.hehe.studi_kasus_bean_validation.validation.annotation.ValidDateRange;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, EventRequest> {

	@Override
	public boolean isValid(EventRequest eventRequest, ConstraintValidatorContext constraintValidatorContext) {
		if(eventRequest.getStartDate() == null || eventRequest.getEndDate() == null) {
			return true;
		}

		return eventRequest.getStartDate().isBefore(eventRequest.getEndDate());
	}
}
