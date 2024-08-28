package com.exodiaio.project.entities;

public enum OrderStatus {
	WAITING_PAYMENT(0),
	PAID(1),
	SHIPED(2),
	DELIVERY(3),
	CANCELED(4);
	
	private int code;

	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException();
	}
	
}
