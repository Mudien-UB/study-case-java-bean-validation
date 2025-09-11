package com.hehe.studi_kasus_bean_validation.controller;

import com.hehe.studi_kasus_bean_validation.service.TransactionService;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class TransactionController {

	private TransactionService transactionService;

	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@PostMapping("/transfer")
	public ResponseEntity<?> transfer(
			@RequestParam @NotBlank String from,
			@RequestParam @NotBlank String to,
			@RequestParam @Min(1) double amount
	) {
		var transfer = transactionService.transfer(from, to, amount);
		return ResponseEntity.ok().body(transfer);
	}

}
