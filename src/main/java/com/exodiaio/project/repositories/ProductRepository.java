package com.exodiaio.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exodiaio.project.entities.Product;

	// INTERFACE
public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
