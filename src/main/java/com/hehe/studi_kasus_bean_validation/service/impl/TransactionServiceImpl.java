package com.hehe.studi_kasus_bean_validation.service.impl;

import com.hehe.studi_kasus_bean_validation.service.TransactionService;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.text.NumberFormat;

@Service
@Validated
public class TransactionServiceImpl implements TransactionService {

	private final MessageSource messageSource;

	public TransactionServiceImpl(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public String transfer(String fromAccount,String toAccount, double amount) {
		String formattedAmount = convertStringCurrency(amount);
		String message = messageSource.getMessage(
				"bank.transfer",
				new Object[]{fromAccount, toAccount, formattedAmount},
				LocaleContextHolder.getLocale()
		);
		return message;
	}


	private String convertStringCurrency(double amount) {
		return NumberFormat.getCurrencyInstance(LocaleContextHolder.getLocale()).format(amount);
	}
}

