package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Product;
import com.main.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/{id}",produces = {"text/event-stream"})
	public Mono<Product> findById(@PathVariable String id) {
		return productService.findById(id);
	}
	
	@GetMapping(value = "/name/{name}",produces = {"text/event-stream"})
	public Mono<Product> findByName(String name){
		return productService.findByName(name);
	}
	
	@GetMapping(produces = {"text/event-stream"})
	public Flux<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@DeleteMapping(produces = {"text/event-stream"})
	public Mono<Void> deleteAll(){
		return productService.deleteAll();
	}
	@PostMapping(produces = {"text/event-stream"})
	public Mono<Product> insert(@RequestBody Product pro){
		return productService.insert(pro);
	}
	
	@PutMapping(produces = {"text/event-stream"})
	public Mono<Product> update(Product pro){
		return productService.update(pro);
	}
	@DeleteMapping(value = "/{id}",produces = {"text/event-stream"})
	public Mono<Void> deleteById(String id){
		return productService.deleteById(id);
	}

}
