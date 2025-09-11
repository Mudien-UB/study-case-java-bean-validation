package com.hehe.studi_kasus_bean_validation.controller_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void transferTest() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/bank/transfer?from=12ba&to=12ak&amount=1000.00")
						.contentType(MediaType.APPLICATION_JSON)
						.locale(new Locale("id", "ID"))
				)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());


	}


	@Test
	void transferInvalidTest() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/bank/transfer?from=1b&to=1b&amount=1000.00")
						.contentType(MediaType.APPLICATION_JSON)
						.locale(new Locale("id", "ID"))
				)
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andDo(MockMvcResultHandlers.print());


	}
}
