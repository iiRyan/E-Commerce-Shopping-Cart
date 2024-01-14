package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ecommerce.beans.Order;
import com.ecommerce.db.DBConnection;

public class OrderDao {

	static Connection connection = DBConnection.getConnection();
	private PreparedStatement preparedStatement;

	public boolean insertOrder(Order order) {

		try {

			String insertOrder = "INSERT INTO ecommerce_cart.orders (p_id, u_id, o_quantity, o_date) VALUES(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertOrder);
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
}
