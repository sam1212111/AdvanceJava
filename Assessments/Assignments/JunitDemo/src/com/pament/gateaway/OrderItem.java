package com.pament.gateaway;



public class OrderItem {
	
	PamentGateaway pg1;
	public OrderItem(PamentGateaway pg) {
		this.pg1 = pg;
	}
	
	
	public void placeOrderItem(int amount) {
		if(amount<=0) {
			throw new IllegalArgumentException("Invalid amount");
		}
		pg1.processPayment(amount);
	}
	

}
