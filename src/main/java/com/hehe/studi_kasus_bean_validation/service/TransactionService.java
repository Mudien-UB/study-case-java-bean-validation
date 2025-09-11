package com.hehe.studi_kasus_bean_validation.service;


import com.hehe.studi_kasus_bean_validation.validation.annotation.ValidTransferAccount;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public interface TransactionService {

	@ValidTransferAccount
	String transfer(@NotBlank String fromAccount, @NotBlank String toAccount, @NotNull double amount );
}
