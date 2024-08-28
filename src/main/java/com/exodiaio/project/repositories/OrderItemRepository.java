package com.exodiaio.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exodiaio.project.entities.OrderItem;

	// INTERFACE
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
}
