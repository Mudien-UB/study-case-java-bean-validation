package com.hehe.studi_kasus_bean_validation.dto;

import com.hehe.studi_kasus_bean_validation.validation.annotation.NotPastDate;
import com.hehe.studi_kasus_bean_validation.validation.annotation.ValidDateRange;
import com.hehe.studi_kasus_bean_validation.validation.group.AdvancedGroup;
import com.hehe.studi_kasus_bean_validation.validation.group.BasicGroup;
import com.hehe.studi_kasus_bean_validation.validation.group.BusinessGroup;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@ValidDateRange(groups = {BasicGroup.class})
public class EventRequest {

	@NotBlank(message = "{event.name.notblank}", groups = BasicGroup.class)
	private String eventName;

	@NotNull(message = "{event.start.notnull}", groups = BasicGroup.class)
	@NotPastDate(message = "{event.start.notpastdate}", includeToday = false, groups= BasicGroup.class)
	private LocalDate startDate;

	@NotNull(message = "{event.end.notnull}", groups = BasicGroup.class)
	@NotPastDate(message = "{event.end.notpastdate}", groups = BasicGroup.class)
	private LocalDate endDate;

	@NotNull(message = "{event.max.notnull}", groups = BasicGroup.class)
	@Min(value = 1, message = "{event.max.min}", groups = AdvancedGroup.class)
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
