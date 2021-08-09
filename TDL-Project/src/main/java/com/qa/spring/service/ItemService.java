package com.qa.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.spring.model.Item;
import com.qa.spring.repository.ItemRepository;

@Service // handles business logic
public class ItemService {

	private ItemRepository repo;

	@Autowired
	public ItemService(ItemRepository repo) {
		this.repo = repo;
	}

	public Item createItem(Item item) {
		return this.repo.save(item);
	}

	public List<Item> getAllItems() {
		return this.repo.findAll();
	}

	public String deleteItem(long id) {
		if(this.repo.existsById(id)) {
			this.repo.deleteById(id);
	    	return "This item was deleted: " + id;
	    } else {
	    	return "This item wasn't deleted: " + id;
	    }
	}
	
	public Item updateItem(long id, Item item) {
		if(this.repo.existsById(id)) {
			return this.repo.save(item);
	    } else {
	    	return null;
	    }
    }
	
	
}
