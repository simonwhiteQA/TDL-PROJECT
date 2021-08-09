package com.qa.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	
	@Id //Uniquely identifies field (PK)
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increments ID
	private Long id;
	
	@Column
	private String category;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Priority priority;
	
	@Column
	private String description;

	//default constructor
	public Item() {
		super();
	}

	//Constructor without ID
	public Item(String category, Priority priority, String description) {
		super();
		this.category = category;
		this.priority = priority;
		this.description = description;
	}
	
	//Constructor with ID
	public Item(Long id, String category, Priority priority, String description) {
		super();
		this.id = id;
		this.category = category;
		this.priority = priority;
		this.description = description;
	}

	
	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
