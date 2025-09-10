package com.hehe.studi_kasus_bean_validation.service.impl;

import com.hehe.studi_kasus_bean_validation.dto.EventRequest;
import com.hehe.studi_kasus_bean_validation.model.Event;
import com.hehe.studi_kasus_bean_validation.service.EventService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

	private List<Event> events;

	public EventServiceImpl() {
		this.events = new ArrayList<Event>();
	}

	@Override
	public Event addEvent(EventRequest eventRequest) {


		Event event = new Event();
		event.setId(generatedId());
		event.setEventName(eventRequest.getEventName());
		event.setStartDate(eventRequest.getStartDate());
		event.setEndDate(eventRequest.getEndDate());
		event.setMaxParticipants(eventRequest.getMaxParticipants());

		var now = LocalDateTime.now();
		event.setCreatedAt(now);
		event.setUpdatedAt(now);

		events.add(event);
		return event;

	}

	private long generatedId() {
		if (events.size() <= 0) {
			return 1;
		} else {
			return events.getLast().getId() + 1;
		}
	}
}
