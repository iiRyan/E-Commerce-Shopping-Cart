package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.beans.Order;
import com.ecommerce.beans.Product;
import com.ecommerce.db.DBConnection;

public class OrderDao {

	static Connection connection = DBConnection.getConnection();
	private PreparedStatement preparedStatement;
	

	public boolean insertOrder(Order order) {

		try {

			String insertOrder = "INSERT INTO ecommerce_cart.orders (p_id, u_id, o_quantity, o_date) VALUES(?,?,?,?)";
			preparedStatement = connection.prepareStatement(insertOrder);
			preparedStatement.setInt(1, order.getId());
			preparedStatement.setInt(2, order.getUid());
			preparedStatement.setInt(3, order.getQuantity());
			preparedStatement.setString(4, order.getDate());

			int result = preparedStatement.executeUpdate();
			return result == 1 ? true : false;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public List<Order> userOrder(int id) {
		List<Order> orderList = new ArrayList<Order>();

		try {
			// TODO: use Inner join
			String selectOrder = "SELECT o.*, p.* FROM ecommerce_cart.orders o INNER JOIN ecommerce_cart.products p ON o.p_id = p.id WHERE o.u_id = ? ORDER BY o.o_id DESC";
			preparedStatement = connection.prepareStatement(selectOrder);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Order order = new Order();
				int p_id = resultSet.getInt("p_id");
				System.out.println("The product Id ==> "+p_id);
				ProductDao productDao = new ProductDao();
				Product product = productDao.getSingleProduct(p_id);
				order.setOrderId(resultSet.getInt("o_id"));
				order.setId(p_id);
				order.setName(product.getName());
				order.setCategory(product.getCategory());
				order.setPrice(product.getPrice() * resultSet.getInt("o_quantity"));
				order.setQuantity(resultSet.getInt("o_quantity"));
				order.setDate(resultSet.getString("o_date"));

				orderList.add(order);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return orderList;
	}
	
	public void cancleOrder(int id) {
		
		try {
			String deleteOrder = "DELETE FROM ecommerce_cart.orders WHERE o_id = ?";
			preparedStatement = connection.prepareStatement(deleteOrder);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	} 
}
