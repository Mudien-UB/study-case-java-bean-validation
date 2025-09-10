package com.hehe.studi_kasus_bean_validation.service;

import com.hehe.studi_kasus_bean_validation.dto.EventRequest;
import com.hehe.studi_kasus_bean_validation.model.Event;

public interface EventService {

	Event addEvent(EventRequest eventRequest);


}
