package com.hehe.studi_kasus_bean_validation.controller_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.Locale;

@SpringBootTest
@AutoConfigureMockMvc
public class EventControllerTest {

	@Autowired
    private MockMvc mockMvc;

	@Test
	void whenValidEventRequest_thenReturnsOk() throws Exception {
		String validJson = """
        {
            "eventName": "Workshop Java",
            "startDate": "%s",
            "endDate": "%s",
            "maxParticipants": 50
        }
        """.formatted(
				LocalDate.now().plusDays(1),
				LocalDate.now().plusDays(2)
		);

		Locale locale = new Locale("id", "ID");

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/event/create")
				.contentType("application/json")
				.content(validJson)
				.locale(locale);

		mockMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	void whenInvalidEventRequest_thenReturnsBadRequest() throws Exception {
		String invalidJson = """
        {
            "eventName": "",
            "startDate": "%s",
            "endDate": "%s",
            "maxParticipants": 10
        }
        """.formatted(
				LocalDate.now().minusDays(1),
				LocalDate.now().minusDays(2)
		);

		Locale locale = new Locale("id", "ID");

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/event/create")
				.contentType("application/json")
				.content(invalidJson)
				.locale(locale);

		mockMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	void whenRequiredChecksFail_thenBusinessRulesAndLimitChecksNotExecuted() throws Exception {
		// Hanya error di RequiredChecks: eventName kosong
		String json = """
    {
        "eventName": "",
        "startDate": "%s",
        "endDate": "%s",
        "maxParticipants": 10
    }
    """.formatted(
				LocalDate.now().plusDays(1),
				LocalDate.now().plusDays(2)
		);

		mockMvc.perform(MockMvcRequestBuilders.post("/event/create")
						.contentType("application/json")
						.content(json)
						.locale(new Locale("id", "ID")))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	void whenBusinessRulesFail_thenLimitChecksNotExecuted() throws Exception {
		// RequiredChecks lolos, BusinessRules gagal: startDate setelah endDate
		String json = """
    {
        "eventName": "Workshop Java",
        "startDate": "%s",
        "endDate": "%s",
        "maxParticipants": 10
    }
    """.formatted(
				LocalDate.now().plusDays(3),
				LocalDate.now().plusDays(2)  // endDate sebelum startDate
		);

		mockMvc.perform(MockMvcRequestBuilders.post("/event/create")
						.contentType("application/json")
						.content(json)
						.locale(new Locale("id", "ID")))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	void whenLimitChecksFail_thenRequiredAndBusinessChecksPassed() throws Exception {
		// RequiredChecks dan BusinessRules lolos, LimitChecks gagal: maxParticipants < 1
		String json = """
    {
        "eventName": "Workshop Java",
        "startDate": "%s",
        "endDate": "%s",
        "maxParticipants": 0
    }
    """.formatted(
				LocalDate.now().plusDays(1),
				LocalDate.now().plusDays(2)
		);

		mockMvc.perform(MockMvcRequestBuilders.post("/event/create")
						.contentType("application/json")
						.content(json)
						.locale(new Locale("id", "ID")))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	void whenErrorsInDifferentGroups_thenErrorsAppearInGroupSequenceOrder() throws Exception {
		// EventRequest ini memiliki dua error:
		// 1. RequiredChecks gagal → eventName kosong
		// 2. LimitChecks gagal → maxParticipants < 1
		// BusinessRules lolos
		String json = """
    {
        "eventName": "",
        "startDate": "%s",
        "endDate": "%s",
        "maxParticipants": 0
    }
    """.formatted(
				LocalDate.now().plusDays(1),
				LocalDate.now().plusDays(2)
		);

		mockMvc.perform(MockMvcRequestBuilders.post("/event/create")
						.contentType("application/json")
						.content(json)
						.locale(new Locale("id", "ID")))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andDo(MockMvcResultHandlers.print());
	}



}
