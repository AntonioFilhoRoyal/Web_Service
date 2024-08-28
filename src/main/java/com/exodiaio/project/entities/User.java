package com.exodiaio.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

		// MODELO DE USUARIO

@Entity // ENTIDADE. PASSANDO ESSA CLSS PARA UMA ENTIDADE, FAZENDO ELA FICA MAPEADA E OBSERVADA
@Table(name="tb_user") // DEFINIDO NOME DA TABELA NO BANCO DE DADOS
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // GERAÇÃO DE ID PARA IDENTIFICAÇÃO
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	@JsonIgnore // IGNORANDO A CHAMADA DE UMA ORDEM
	// MOTIVO: SEM O JSONIGNORE, AO STARTA A APLICAÇÃO, A CHAMADA DE UM PEDIDO CHAMA O CLIENTE É O CLIENTE CHAMA O PEDIDO
				// ENTÃO FICA NESSE LOOP, COM O JSONIGNORE ISSO NÃO ACONTECE
// UM PARA MUITOS	
	@OneToMany(mappedBy = "client") // MAPEANDO A VARIAVEL CLIENT DENTRO DA CLASS ORDER
	private List<Order> orders = new ArrayList<>();

	public User() {
	
	}

	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Order> getOrders() {
		return orders;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id;
	}
	
	
	
}
