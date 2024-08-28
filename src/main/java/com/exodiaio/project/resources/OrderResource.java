package com.exodiaio.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exodiaio.project.entities.Order;
import com.exodiaio.project.service.OrderService;

		// CLASS SENDO CONTROLADA PELO SPRING BOOT


@RestController
@RequestMapping(value="/orders") // MAPEANDO ESSA CLASS PARA IMPRESSÃO NO WEBSITE, PARAMETRO /OrderS
public class OrderResource {
	
	@Autowired
	private OrderService service; // INJETANDO DEPENDENCIA DO SERVICE
	
	// METODO QUE SERA IMPRESSO NO PARAMETRO /OrderS
	@GetMapping // MAPEANDO METODO, FAZENDO GET
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll(); // ALTERANDO O TIPO DO METODO PARA RECEBE UMA LISTA DE USUARIOS
		return ResponseEntity.ok().body(list); // PASSANDO A LISTA PARA IMPRESSÃO DE TELA
		
// IMPRIMA UMA LISTA(LIST) DE USUARIOS(Order) COM O NOME LIST, PUXE ESSA LISTA DO SERVIÇO(SERVICE) FINDALL		
	}
	
	// GETMAPPING(/OrderS/GET) FAZ OQUE OUTRO METODO SEJA IMPRESSO DENTRO DO PARAMETRO /OrderS
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order Order = service.findById(id);
		return ResponseEntity.ok().body(Order);
// IMPRIMA UM USUARIO(Order) COM NOME Order, PUXE O USUARIO DO SERVIÇO(SERVICE) FINDBYID PEGANDO O ID(LONG ID) DELE	
	}
}
