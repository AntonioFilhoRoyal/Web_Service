package com.exodiaio.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exodiaio.project.entities.Category;
import com.exodiaio.project.service.CategoryService;

		// CLASS SENDO CONTROLADA PELO SPRING BOOT


@RestController
@RequestMapping(value="/categories") // MAPEANDO ESSA CLASS PARA IMPRESSÃO NO WEBSITE, PARAMETRO /CategoryS
public class CategoryResource {
	
	@Autowired
	private CategoryService service; // INJETANDO DEPENDENCIA DO SERVICE
	
	// METODO QUE SERA IMPRESSO NO PARAMETRO /CategoryS
	@GetMapping // MAPEANDO METODO, FAZENDO GET
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll(); // ALTERANDO O TIPO DO METODO PARA RECEBE UMA LISTA DE USUARIOS
		return ResponseEntity.ok().body(list); // PASSANDO A LISTA PARA IMPRESSÃO DE TELA
		
// IMPRIMA UMA LISTA(LIST) DE USUARIOS(Category) COM O NOME LIST, PUXE ESSA LISTA DO SERVIÇO(SERVICE) FINDALL		
	}
	
	// GETMAPPING(/CategoryS/GET) FAZ OQUE OUTRO METODO SEJA IMPRESSO DENTRO DO PARAMETRO /CategoryS
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category Category = service.findById(id);
		return ResponseEntity.ok().body(Category);
// IMPRIMA UM USUARIO(Category) COM NOME Category, PUXE O USUARIO DO SERVIÇO(SERVICE) FINDBYID PEGANDO O ID(LONG ID) DELE	
	}
}
