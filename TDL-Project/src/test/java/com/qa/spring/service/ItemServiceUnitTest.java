package com.qa.spring.service;
	
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.spring.model.Item;
import com.qa.spring.model.Priority;
import com.qa.spring.repository.ItemRepository;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ItemServiceUnitTest {

	@MockBean
	private ItemRepository repo; 
	
	@Autowired
	private ItemService service;
	
	@Test
	void testCreateUnit() {
		// GIVEN 
			
		Item test = new Item("School", Priority.HIGH, "do homework");
		Item testId = new Item(1L, "School", Priority.HIGH, "do homework");
		
		// WHEN 
		Mockito.when(this.repo.save(test)).thenReturn(testId);
		
		
		// THEN
		assertThat(this.service.createItem(test)).isEqualTo(testId);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(test);
		
	}
	
	@Test
	void testReadUnit() {
		// GIVEN 
		List<Item> testList = new ArrayList<>();
		Item test = new Item("School", Priority.HIGH, "do homework");
		
		// WHEN 
		testList.add(test);
		Mockito.when(this.repo.findAll()).thenReturn(testList);
	
		// THEN
		assertThat(this.service.getAllItems()).isEqualTo(testList);
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
		
	}
	
	@Test
	void testDeleteUnit() {
		// GIVEN 
		Long id = 1L;
		
		// WHEN 
		Mockito.when(this.repo.existsById(id)).thenReturn(true);
	
		// THEN
		assertThat(this.service.deleteItem(id)).isEqualTo("This item was deleted: " + id);
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(id);
		
	}
	
	@Test
	void testUpdateUnit() {
		// GIVEN 
		Long id = 1L;
		Item updated = new Item(id, "Shopping", Priority.LOW, "do shopping");
		
		// WHEN 
		Mockito.when(this.repo.existsById(id)).thenReturn(true);
	
		// THEN
		Mockito.when(this.service.updateItem(id, updated)).thenReturn(updated);
		assertThat(this.repo.save(updated)).isEqualTo(updated);
		
	}
	

}

