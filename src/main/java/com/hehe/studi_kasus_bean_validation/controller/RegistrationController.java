package com.hehe.studi_kasus_bean_validation.controller;

import com.hehe.studi_kasus_bean_validation.dto.UserRegistrationRequest;
import com.hehe.studi_kasus_bean_validation.model.User;
import com.hehe.studi_kasus_bean_validation.service.RegistrationService;
import com.hehe.studi_kasus_bean_validation.validation.group_sequence.ValidationSequence;
import com.hehe.studi_kasus_bean_validation.validation.validator.StrongPasswordValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class RegistrationController {

	private RegistrationService registrationService;

	public RegistrationController(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@Validated({ValidationSequence.class}) @RequestBody UserRegistrationRequest userRegistrationRequest) {

		User registeredUser = registrationService.registerUser(userRegistrationRequest);

		return new ResponseEntity<>(registeredUser, HttpStatus.OK);
	}

}
