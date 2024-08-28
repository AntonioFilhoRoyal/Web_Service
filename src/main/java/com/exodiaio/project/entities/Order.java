package com.exodiaio.project.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_order")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
// MUITOS PARA UM	
	@ManyToOne
	@JoinColumn(name = "client_id") // ADICIONANDO UMA COLUNA COM FORAGN KEY DENTRO DO BANCO DE DADOS
							// COM O NOME CLIENT_ID
	private User client; // INSTANCIANDO UM TIPO USUARIO COM NOME CLIENT
	
	// MAPEANDO OS ITENS DE ORDERITEMS PELO: ID QUE ENTRA DENTRO DA CLASS ORDERITEMPK, ORDER QUE PUXA A ORDER(PEDIDO)
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	private Integer orderStatus;
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;
	
	private Double total;
	
	public Order() {
		super();
	}

	public Order(Long id, Instant moment, OrderStatus orderStatus,User client) {
		super();
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Instant getMoment() {
		return moment;
	}
	
	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	
	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	
	public Double getTotal() {
		Double sum = 0.0;
		for(OrderItem x : items) {
			sum += x.getSubTotal();
		}
		
		return sum;
	}

	// O METODO VALUEOF DENTRO DO ENUM PUXA O VALOR DO CODIGO DE CADA ENUM
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

		// PARAMETRO ORDERSTATUS DIFERENTE DE NULL IRA PEGA O CODE DO STATUS
	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
	}
	
	public Set<OrderItem> getOrderItem(){
		return items;
	}

	// INSTANCIANDO PAYMENT
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
