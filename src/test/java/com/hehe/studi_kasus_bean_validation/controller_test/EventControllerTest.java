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

}
