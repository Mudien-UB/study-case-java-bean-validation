package com.hehe.studi_kasus_bean_validation.request_test;

import com.hehe.studi_kasus_bean_validation.dto.AddressDto;
import com.hehe.studi_kasus_bean_validation.dto.UserRegistrationRequest;
import com.hehe.studi_kasus_bean_validation.validation.group.BasicGroup;
import com.hehe.studi_kasus_bean_validation.validation.group_sequence.ValidationSequence;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class UserRequestTest {

	private ValidatorFactory validatorFactory;
	private Validator validator;

	@BeforeEach
	void setUp() {
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}

	@AfterEach
	void tearDown() {
		validatorFactory.close();
	}

	@Test
	void create() {

		UserRegistrationRequest request = new UserRegistrationRequest();

		Set<ConstraintViolation<UserRegistrationRequest>> violations = validator.validate(request, BasicGroup.class);

		violations.forEach(violation -> System.out.println(violation.getMessage()));

	}

	@Test
	void createAdress() {

		UserRegistrationRequest request = new UserRegistrationRequest();
		request.setUsername("Mudien Ube");
		request.setPassword("Abcdef12345.");
		request.setEmail("MudienUbe@example.com");
		request.setAge(20);

		AddressDto addressDto = new AddressDto();
		request.setAddress(addressDto);
		Set<ConstraintViolation<UserRegistrationRequest>> violations = validator.validate(request, ValidationSequence.class);
		violations.forEach(violation -> System.out.println(violation.getMessage()));

	}
}
