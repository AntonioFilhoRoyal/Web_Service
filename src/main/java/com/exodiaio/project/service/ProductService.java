package com.exodiaio.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exodiaio.project.entities.Product;
import com.exodiaio.project.repositories.ProductRepository;

// DECLARANDO QUE A CLASS É UMA CLASS DE SERVIÇOS
@Service
public class ProductService {

	@Autowired // INJETANDO O REPOSITORIO
	private ProductRepository repository;

			// PUXANDO O FINDALL DO RESPOSITORY, QUE IMPLEMANTA O JPAREPOSITORY
	public List<Product> findAll(){
		return repository.findAll();
	// REPOSITORIO QUE PUXA UMA LISTA DE OBJETOS	
	}
	
	public Product findById(Long id) {
		// TERMO IMPLEMENTADO DESDO JAVA 8
		Optional<Product> optionalRepository = repository.findById(id);
		return optionalRepository.get();
	// RETORNANDO UM OBJETO PELO ID	
	}
}
