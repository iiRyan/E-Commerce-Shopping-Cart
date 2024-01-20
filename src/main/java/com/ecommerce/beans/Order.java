package com.ecommerce.beans;

import java.util.Date;

public class Order  {

	private int id;
	private int user_id;
	private double total_cost;
	private Date order_date;

	public Order() {
	}

	public Order(int user_id, double total_cost, Date order_date) {

		this.user_id = user_id;
		this.total_cost = total_cost;
		this.order_date = order_date;
	}

	

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Order(int user_id, double total_cost) {
		this.user_id = user_id;
		this.total_cost = total_cost;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public double getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}

	
	@Override
	public String toString() {
		return "Order [id=" + id + ", user_id=" + user_id + ", total_cost=" + total_cost + ", order_date="
				+ order_date + "]";
	}
	
}
