package com.exodiaio.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exodiaio.project.entities.Order;

	// INTERFACE
public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
