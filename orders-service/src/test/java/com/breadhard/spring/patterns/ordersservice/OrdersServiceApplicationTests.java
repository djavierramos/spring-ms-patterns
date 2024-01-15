package com.breadhard.spring.patterns.ordersservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = {OrdersServiceApplicationTests.class})
@Slf4j
class OrdersServiceApplicationTests {
	@Autowired
	MockMvc mockMvc;
	@Test
	void contextLoads() {
		log.info("Context loads");
	}
	@Test
	@SneakyThrows
	void testGetCustomerById() {
		mockMvc.perform(
			MockMvcRequestBuilders.get("/api/orders/{order-id}", "asdf")
				.contentType(MediaType.APPLICATION_JSON))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk());		
	}

}
