package com.exodiaio.project.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.exodiaio.project.entities.User;
import com.exodiaio.project.service.UserService;

		// CLASS SENDO CONTROLADA PELO SPRING BOOT


@RestController
@RequestMapping(value="/users") // MAPEANDO ESSA CLASS PARA IMPRESSÃO NO WEBSITE, PARAMETRO /USERS
public class UserResource {
	
	@Autowired
	private UserService service; // INJETANDO DEPENDENCIA DO SERVICE
	
	// METODO QUE SERA IMPRESSO NO PARAMETRO /USERS
	@GetMapping // MAPEANDO METODO, FAZENDO GET
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll(); // ALTERANDO O TIPO DO METODO PARA RECEBE UMA LISTA DE USUARIOS
		return ResponseEntity.ok().body(list); // PASSANDO A LISTA PARA IMPRESSÃO DE TELA
		
// IMPRIMA UMA LISTA(LIST) DE USUARIOS(USER) COM O NOME LIST, PUXE ESSA LISTA DO SERVIÇO(SERVICE) FINDALL		
	}
	
	// GETMAPPING(/USERS/GET) FAZ OQUE OUTRO METODO SEJA IMPRESSO DENTRO DO PARAMETRO /USERS
	
	@GetMapping(value="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User user = service.findById(id);
		return ResponseEntity.ok().body(user);
// IMPRIMA UM USUARIO(USER) COM NOME USER, PUXE O USUARIO DO SERVIÇO(SERVICE) FINDBYID PEGANDO O ID(LONG ID) DELE	
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
		user = service.update(id, user);
		return ResponseEntity.ok().body(user);
	}
	
}
