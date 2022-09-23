package com.example.demo;

import com.example.demo.controller.NumberController;
import com.example.demo.model.Payload;
import com.example.demo.service.NumberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(NumberController.class)
class NumberControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@MockBean
	private NumberService numberService;

	private List<Double> numbers = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));

	@Test
	void it_should_return_min() throws Exception {
		Payload payload = new Payload();
		payload.numbers = numbers;
		payload.quantifier = 2;

		when(numberService.getMin(numbers, 2)).thenReturn(Arrays.asList(1.0, 2.0));

		MockHttpServletResponse response = mockMvc.perform(
				post("/min")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(payload))
		).andReturn().getResponse();

		assertThat(response.getStatus(), equalTo(HttpStatus.OK.value()));
		assertThat(response.getContentAsString(), equalTo("[1.0,2.0]"));
	}
}
