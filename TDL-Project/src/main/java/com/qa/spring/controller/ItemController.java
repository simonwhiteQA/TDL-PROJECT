package com.qa.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.spring.model.Item;
import com.qa.spring.service.ItemService;


@RestController //handles HTTP requests
@CrossOrigin
@RequestMapping("/Item")
public class ItemController {
	
private ItemService service;
	
	@Autowired
	public ItemController(ItemService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Item> createItem(@RequestBody Item itemData) {
		 return new ResponseEntity<>(this.service.createItem(itemData), HttpStatus.CREATED);
	}
	
	@GetMapping("/readAll") //Get all items
	public ResponseEntity<List<Item>> getAllItems() {
		return new ResponseEntity<>(this.service.getAllItems(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable long id) {
	    return new ResponseEntity<>(this.service.deleteItem(id), HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/update/{id}")
    public Item updateItem(@PathVariable long id, @RequestBody Item item) {
        return this.service.updateItem(id, item);
    }

}
