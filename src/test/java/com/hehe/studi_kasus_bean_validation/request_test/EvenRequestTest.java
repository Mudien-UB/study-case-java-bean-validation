package com.hehe.studi_kasus_bean_validation.request_test;

import com.hehe.studi_kasus_bean_validation.dto.EventRequest;
import com.hehe.studi_kasus_bean_validation.validation.group.BasicGroup;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class EvenRequestTest {

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


		EventRequest eventRequest = new EventRequest();
		eventRequest.setEventName("Holiday");
		eventRequest.setStartDate(LocalDate.of(2025, 9, 10));
		eventRequest.setEndDate(LocalDate.of(2025, 9, 27));
		eventRequest.setMaxParticipants(100);

		Set<ConstraintViolation<EventRequest>> constraintViolations = validator.validate(eventRequest, BasicGroup.class);

		constraintViolations.forEach(System.out::println);

	}
}
