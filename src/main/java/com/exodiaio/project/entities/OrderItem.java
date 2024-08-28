package com.exodiaio.project.entities;

import java.util.Objects;

import com.exodiaio.project.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem {
	
	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();
	private Integer quntity;
	private Double price;
	
	public OrderItem() {
		super();
	}

	
	public OrderItem(Order order, Product product, Integer quntity, Double price) {
		super();
		id.setOrder(order); // PUXA A ORDER DENTRO DA ORDERITEMPK, O MESMO COM O PRODUCT
		id.setProduct(product);
		this.quntity = quntity;
		this.price = price;
	}

	public Integer getQuntity() {
		return quntity;
	}

	public void setQuntity(Integer quntity) {
		this.quntity = quntity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	// CALCULO DE SUBTOTAL
	public Double getSubTotal() {
		return price * quntity;
	}

	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	
	@JsonIgnore
	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product) {
		id.setProduct(product);
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
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
