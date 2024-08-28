package com.exodiaio.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exodiaio.project.entities.Category;

	// INTERFACE
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
