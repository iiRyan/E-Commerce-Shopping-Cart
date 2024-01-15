package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.beans.Cart;
import com.ecommerce.beans.Product;
import com.ecommerce.db.DBConnection;

public class ProductDao {

	static Connection connection = DBConnection.getConnection();
	private PreparedStatement preparedStatement;

	public List<Product> getAllProducts() {

		List<Product> products = new ArrayList<Product>();

		try {

			String selectAll = "SELECT * FROM ecommerce_cart.products";
			preparedStatement = connection.prepareStatement(selectAll);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Product row = new Product();
				row.setId(resultSet.getInt("id"));
				row.setName(resultSet.getString("name"));
				row.setCategory(resultSet.getString("category"));
				row.setPrice(resultSet.getDouble("price"));
				row.setImage(resultSet.getString("image"));

				products.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public List<Cart> getCartProducts(List<Cart> cartList) {
		
		
		List<Cart> product = new ArrayList<Cart>();

		try {

			if(cartList.size() > 0) {
				
				for(Cart item:cartList) {	
					String selectAll = "SELECT * FROM ecommerce_cart.products WHERE id = ?";
					preparedStatement = connection.prepareStatement(selectAll);
					preparedStatement.setInt(1, item.getId());
					ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					Cart row = new Cart();
					row.setId(resultSet.getInt("id"));
					row.setName(resultSet.getString("name"));
					row.setCategory(resultSet.getString("category"));
					row.setPrice(resultSet.getDouble("price")*item.getQuantity());
					row.setQuantity(item.getQuantity());

					product.add(row);
				}
			}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;

	}
	
	
	 public Product getSingleProduct(int id) {
		 Product row = null;
	        try {
	            String selectById = "select * from ecommerce_cart.products where id=? ";
	            

	            preparedStatement = connection.prepareStatement(selectById);
	            preparedStatement.setInt(1, id);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	            	row = new Product();
	                row.setId(resultSet.getInt("id"));
	                row.setName(resultSet.getString("name"));
	                row.setCategory(resultSet.getString("category"));
	                row.setPrice(resultSet.getDouble("price"));
	                row.setImage(resultSet.getString("image"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }

	        return row;
	    }
	
	
	public double getTotalCartPrice(List<Cart> cartList) {
		double sum = 0;
		
		try {
			if(cartList.size() > 0) {
				for(Cart item:cartList) {
					String getPrice = "SELECT * FROM ecommerce_cart.products WHERE id = ?";
					preparedStatement = connection.prepareStatement(getPrice);
					preparedStatement.setInt(1, item.getId());
					ResultSet resultSet = preparedStatement.executeQuery();
					
					while(resultSet.next()) {
						sum+=resultSet.getDouble("price")*item.getQuantity();
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return sum;
	}
}