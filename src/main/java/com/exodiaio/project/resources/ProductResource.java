package com.exodiaio.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exodiaio.project.entities.Product;
import com.exodiaio.project.service.ProductService;

		// CLASS SENDO CONTROLADA PELO SPRING BOOT


@RestController
@RequestMapping(value="/products") // MAPEANDO ESSA CLASS PARA IMPRESSÃO NO WEBSITE, PARAMETRO /ProductS
public class ProductResource {
	
	@Autowired
	private ProductService service; // INJETANDO DEPENDENCIA DO SERVICE
	
	// METODO QUE SERA IMPRESSO NO PARAMETRO /ProductS
	@GetMapping // MAPEANDO METODO, FAZENDO GET
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll(); // ALTERANDO O TIPO DO METODO PARA RECEBE UMA LISTA DE USUARIOS
		return ResponseEntity.ok().body(list); // PASSANDO A LISTA PARA IMPRESSÃO DE TELA
		
// IMPRIMA UMA LISTA(LIST) DE USUARIOS(Product) COM O NOME LIST, PUXE ESSA LISTA DO SERVIÇO(SERVICE) FINDALL		
	}
	
	// GETMAPPING(/ProductS/GET) FAZ OQUE OUTRO METODO SEJA IMPRESSO DENTRO DO PARAMETRO /ProductS
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product Product = service.findById(id);
		return ResponseEntity.ok().body(Product);
// IMPRIMA UM USUARIO(Product) COM NOME Product, PUXE O USUARIO DO SERVIÇO(SERVICE) FINDBYID PEGANDO O ID(LONG ID) DELE	
	}
}
