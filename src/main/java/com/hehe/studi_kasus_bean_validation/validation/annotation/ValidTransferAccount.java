package com.hehe.studi_kasus_bean_validation.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = com.hehe.studi_kasus_bean_validation.validation.validator.TransferAccountsValidator.class)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTransferAccount {

	String message() default "{bank.account.valid.transfer}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
