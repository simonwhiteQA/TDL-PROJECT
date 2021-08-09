package com.qa.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.spring.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
