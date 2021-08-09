package com.qa.spring.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.spring.model.Item;
import com.qa.spring.model.Priority;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql(scripts = {"classpath:sql-schema.sql", "classpath:sql-data.sql"},
executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
class ItemControllerIntegrationTest {

	// Mock Controller and relevant mappers
	
	@Autowired
	private MockMvc mock; 
	
	@Autowired
	private ObjectMapper mapper; // CONVERT REQUESTS TO JSON
	
	@Test
	void testCreate() throws Exception {
		
		// 1. Create our Item Object
		Item item = new Item(2L, "School", Priority.HIGH, "do homework");
		
		// 2. Convert it to a JSON String
		String itemAsJSON = this.mapper.writeValueAsString(item);
		
		// 3. Build our mock request
		
		RequestBuilder mockRequest = 
							post("/Item/create")
							.contentType(MediaType.APPLICATION_JSON)
							.content(itemAsJSON);
		
		// 4. Create our "saved" item 
		Item savedItem = new Item(2L, "School", Priority.HIGH, "do homework");
		
		// 5. Convert SAVED item into JSON String
		String savedItemAsJSON = this.mapper.writeValueAsString(savedItem);
		
		// 6. Check if the Status is 201 - CREATED
		ResultMatcher matchStatus = status().isCreated(); 
		
		// 7. Check if the body is the correct "saved" item 
		ResultMatcher matchBody = content().json(savedItemAsJSON);
		
		// 8. Build the request
		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}
	
	@Test
	void testRead() throws Exception {
		
		RequestBuilder mockRequest = get("/Item/readAll");
		
		ResultMatcher matchStatus = status().is(200); 
		
		this.mock.perform(mockRequest).andExpect(matchStatus);
	}
	
	@Test
	void testDelete() throws Exception {
		
		Long id = 1L;
		RequestBuilder mockRequest = delete("/Item/delete/" + id);
		
		ResultMatcher matchStatus = status().isNoContent(); 
		
		this.mock.perform(mockRequest).andExpect(matchStatus);
	}
	
	
}