package com.main.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.Product;

import reactor.core.publisher.Mono;

@Repository
public interface ProductRepo extends ReactiveMongoRepository<Product, String> {

	public Mono<Product> findByName(String name);
}
