package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Product;
import com.main.repo.ProductRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	public Mono<Product> findById(String id) {
		return productRepo.findById(id);
	}
	
	public Mono<Product> findByName(String name){
		return productRepo.findByName(name);
	}
	
	public Flux<Product> getAllProducts(){
		return productRepo.findAll();
	}
	
	public Mono<Void> deleteAll(){
		return productRepo.deleteAll();
	}
	
	public Mono<Product> insert(Product pro){
		return productRepo.insert(pro);
	}
	
	public Mono<Product> update(Product pro){
		return productRepo.save(pro);
	}
	
	public Mono<Void> deleteById(String id){
		return productRepo.deleteById(id);
	}
}
