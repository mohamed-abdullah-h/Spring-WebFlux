package com.main.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Getter;
import lombok.Setter;

@Document
@Setter
@Getter
public class Product {

	@MongoId
	private String id;
	
	private String name;
	
	private double price;
}
