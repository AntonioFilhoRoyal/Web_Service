package com.exodiaio.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exodiaio.project.entities.Order;
import com.exodiaio.project.repositories.OrderRepository;

// DECLARANDO QUE A CLASS É UMA CLASS DE SERVIÇOS
@Service
public class OrderService {

	@Autowired // INJETANDO O REPOSITORIO
	private OrderRepository repository;

			// PUXANDO O FINDALL DO RESPOSITORY, QUE IMPLEMANTA O JPAREPOSITORY
	public List<Order> findAll(){
		return repository.findAll();
	// REPOSITORIO QUE PUXA UMA LISTA DE OBJETOS	
	}
	
	public Order findById(Long id) {
		// TERMO IMPLEMENTADO DESDO JAVA 8
		Optional<Order> optionalRepository = repository.findById(id);
		return optionalRepository.get();
	// RETORNANDO UM OBJETO PELO ID	
	}
}
