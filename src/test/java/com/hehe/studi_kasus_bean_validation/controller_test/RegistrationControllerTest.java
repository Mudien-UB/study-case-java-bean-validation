package com.hehe.studi_kasus_bean_validation.controller_test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Locale;

@SpringBootTest
@AutoConfigureMockMvc
class RegistrationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void whenValidRequest_thenReturnsOk() throws Exception {

		String validJson = """
				{
				   "username": "ubay123",
                   "email": "ubay@example.com",
                   "password": "Str0ngP@ssword",
                   "confirmPassword": "Str0ngP@ssword",
                   "age": 20,
                   "address": {
                       "street": "Jalan Mawar No. 1",
                       "city": "Kediri",
                       "country": "Indonesia",
                       "postalCode": "64123"
                   }
				}
				""";

		Locale locale = new Locale("id", "ID");

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/auth/register")
				.contentType("application/json")
				.content(validJson)
				.locale(locale);

		mockMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());

	}

	@Test
	void whenInvalidRequest_thenReturnsBadRequest() throws Exception {
		String invalidJson = "{}"; // kosong

		Locale locale = new Locale("id", "ID");

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/auth/register")
				.contentType(MediaType.APPLICATION_JSON.toString())
				.content(invalidJson)
				.locale(locale);

		ResultMatcher badRequest = MockMvcResultMatchers.status().isBadRequest();

		mockMvc.perform(requestBuilder).andExpect(badRequest).andDo(MockMvcResultHandlers.print());
	}

	@Test
	void whenInvalidRequest_invalidAddress_thenReturnsBadRequest() throws Exception {

		String validJson = """
				{
				   "username": "ubay123",
                   "email": "ubay@example.com",
                   "password": "Str0ngP@ssword",
                   "confirmPassword": "Str0ngP@ssword",
                   "age": 20,
                   "address": {
                       "city": " ",
                       "country": " ",
                       "postalCode": "64123"
                   }
				}
				""";

		Locale locale = new Locale("id", "ID");

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/auth/register")
				.contentType("application/json")
				.content(validJson)
				.locale(locale)
				;

		mockMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andDo(MockMvcResultHandlers.print());

	}

	@Test
	void whenInvalidRequest_misMatchConfirmPassword_thenReturnsBadRequest() throws Exception {

		String validJson = """
				{
				   "username": "ubay123",
                   "email": "ubay@example.com",
                   "password": "Str0ngP@ssword",
                   "confirmPassword": "Str0npP@ssword",
                   "age": 20,
                   "address": {
                       "street": "Jalan Mawar No. 1",
                       "city": "Kediri",
                       "country": "Indonesia",
                       "postalCode": "64123"
                   }
				}
				""";

		Locale locale = new Locale("id", "ID");

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/auth/register")
				.contentType("application/json")
				.content(validJson)
				.locale(locale)
				;

		mockMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andDo(MockMvcResultHandlers.print());

	}
}

