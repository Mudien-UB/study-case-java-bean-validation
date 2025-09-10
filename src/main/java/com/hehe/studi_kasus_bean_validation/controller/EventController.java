package com.hehe.studi_kasus_bean_validation.controller;

import com.hehe.studi_kasus_bean_validation.dto.EventRequest;
import com.hehe.studi_kasus_bean_validation.model.Event;
import com.hehe.studi_kasus_bean_validation.service.EventService;
import com.hehe.studi_kasus_bean_validation.validation.group_sequence.EventValidationGroupSequence;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {

	private EventService eventService;

	public EventController(EventService eventService) {
		this.eventService = eventService;
	}

	@PostMapping("/create")
	public ResponseEntity<?> createEvent(@Validated({EventValidationGroupSequence.class}) @RequestBody EventRequest eventRequest) {

		Event newEvent = eventService.addEvent(eventRequest);

		return new ResponseEntity<>(newEvent, HttpStatus.OK);
	}

}
