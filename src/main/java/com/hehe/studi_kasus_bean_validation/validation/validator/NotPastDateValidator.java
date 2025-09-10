package com.hehe.studi_kasus_bean_validation.validation.validator;

import com.hehe.studi_kasus_bean_validation.validation.annotation.NotPastDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

/**
 * Validator for the {@link NotPastDate} annotation.
 *
 * <p>Checks that the given date is not in the past. Behavior depends on {@code includeToday}:</p>
 * <ul>
 *     <li>{@code includeToday = true} → Today is invalid, date must be after today.</li>
 *     <li>{@code includeToday = false} → Today is valid, date must be today or later.</li>
 * </ul>
 *
 * <p>Example values:</p>
 * <pre>
 * {@code
 * @NotPastDate(includeToday = true)   // valid: 2025-09-11, invalid: 2025-09-10 or earlier
 * @NotPastDate(includeToday = false)  // valid: 2025-09-10 or later, invalid: 2025-09-09 or earlier
 * }
 * </pre>
 */
public class NotPastDateValidator implements ConstraintValidator<NotPastDate, LocalDate> {

	/** Determines whether today is considered valid or not */
	private boolean includeToday;

	@Override
	public void initialize(NotPastDate constraintAnnotation) {
		this.includeToday = constraintAnnotation.includeToday();
	}

	@Override
	public boolean isValid(LocalDate localDate, ConstraintValidatorContext context) {
		if (localDate == null) {
			// Let @NotNull handle null validation
			return true;
		}

		LocalDate today = LocalDate.now();

		return includeToday
				? localDate.isAfter(today)   // Today is invalid, must be after today
				: !localDate.isBefore(today); // Today is valid, must be today or later
	}
}
