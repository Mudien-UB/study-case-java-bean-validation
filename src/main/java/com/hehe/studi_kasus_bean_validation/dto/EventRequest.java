package com.hehe.studi_kasus_bean_validation.dto;

import com.hehe.studi_kasus_bean_validation.validation.annotation.NotPastDate;
import com.hehe.studi_kasus_bean_validation.validation.annotation.ValidDateRange;
import com.hehe.studi_kasus_bean_validation.validation.group.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@ValidDateRange(groups = BusinessRules.class)
public class EventRequest {

	@NotBlank(message = "{event.name.notblank}", groups = RequiredChecks.class)
	private String eventName;

	@NotNull(message = "{event.start.notnull}", groups = RequiredChecks.class)
	@NotPastDate(message = "{event.start.notpastdate}", includeToday = false, groups = RequiredChecks.class)
	private LocalDate startDate;

	@NotNull(message = "{event.end.notnull}", groups = RequiredChecks.class)
	@NotPastDate(message = "{event.end.notpastdate}", groups = RequiredChecks.class)
	private LocalDate endDate;

	@NotNull(message = "{event.max.notnull}", groups = RequiredChecks.class)
	@Min(value = 1, message = "{event.max.min}", groups = LimitChecks.class)
	private Integer maxParticipants;

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Integer getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(Integer maxParticipants) {
		this.maxParticipants = maxParticipants;
	}
}
