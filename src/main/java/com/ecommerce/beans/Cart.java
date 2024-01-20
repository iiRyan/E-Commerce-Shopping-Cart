package com.ecommerce.beans;

public class Cart extends Product {
	
	private int cart_id;
	private int quantity;
	private int status;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public Cart() {
		
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", quantity=" + quantity + ", status=" + status + "]";
	}
	
	

}
