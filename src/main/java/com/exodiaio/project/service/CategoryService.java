package com.exodiaio.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exodiaio.project.entities.Category;
import com.exodiaio.project.repositories.CategoryRepository;

// DECLARANDO QUE A CLASS É UMA CLASS DE SERVIÇOS
@Service
public class CategoryService {

	@Autowired // INJETANDO O REPOSITORIO
	private CategoryRepository repository;

			// PUXANDO O FINDALL DO RESPOSITORY, QUE IMPLEMANTA O JPAREPOSITORY
	public List<Category> findAll(){
		return repository.findAll();
	// REPOSITORIO QUE PUXA UMA LISTA DE OBJETOS	
	}
	
	public Category findById(Long id) {
		// TERMO IMPLEMENTADO DESDO JAVA 8
		Optional<Category> optionalRepository = repository.findById(id);
		return optionalRepository.get();
	// RETORNANDO UM OBJETO PELO ID	
	}
}
