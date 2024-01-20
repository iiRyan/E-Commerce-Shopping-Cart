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

			String insertOrder = "INSERT INTO ecommerce_cart.orders (user_id, total_cost) VALUES(?,?)";
			preparedStatement = connection.prepareStatement(insertOrder);

			preparedStatement.setInt(1, order.getUser_id());
			preparedStatement.setDouble(2, order.getTotal_cost());

			int result = preparedStatement.executeUpdate();
			return result == 1 ? true : false;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public List<Order> getAllOrders(int user_id) {

		List<Order> orderList = new ArrayList<Order>();
		try {

			

			String getAllOrders = "SELECT * FROM ecommerce_cart.orders WHERE user_id = ?";
			preparedStatement = connection.prepareStatement(getAllOrders);
			preparedStatement.setInt(1, user_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Order order = new Order();

				order.setid(resultSet.getInt("id"));
				order.setUser_id(resultSet.getInt("user_id"));
				order.setOrder_date(resultSet.getDate("order_date"));
				order.setTotal_cost(resultSet.getDouble("total_cost"));
				
				orderList.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderList;
	}
	
	
	

	public void cancleOrder(int id) {

		try {
			String deleteOrder = "DELETE FROM ecommerce_cart.orders WHERE id = ?";
			preparedStatement = connection.prepareStatement(deleteOrder);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
