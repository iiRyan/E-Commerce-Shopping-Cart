package com.ecommerce.beans;

public class Product {

	private int id;
	private int user_id;
	private String name;
	private String category;
	private double price;
	private String image;
	
	
	public Product() {
		
	}


	public Product(int id,int user_id, String name, String category, double price, String image) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.image = image;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", user_id=" + user_id + ", name=" + name + ", category=" + category + ", price="
				+ price + ", image=" + image + "]";
	}


	
	
	
	
}
