package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.ecommerce.beans.Cart;
import com.ecommerce.beans.Order;
import com.ecommerce.beans.Product;
import com.ecommerce.db.DBConnection;

public class CartDao {

	static Connection connection = DBConnection.getConnection();
	private PreparedStatement preparedStatement;
	private ProductDao productDao = new ProductDao();

	public int insertCartList(Cart cart) {

		try {
			String insertCart = "INSERT INTO ecommerce_cart.cart_list (user_id, product_id, quantity, Status) VALUES(?,?,?,?)";

			// Passing Statement.RETURN_GENERATED_KEYS to getGeneratedKeys()
			preparedStatement = connection.prepareStatement(insertCart, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setInt(1, cart.getUser_id());
			preparedStatement.setInt(2, cart.getId()); // ProductID
			preparedStatement.setInt(3, cart.getQuantity());
			preparedStatement.setInt(4, cart.getStatus());

			int affectedRows = preparedStatement.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Inserting cart failed, no rows affected.");
			}

			// Retrieve the generated cart_id
			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					int cartId = generatedKeys.getInt(1);
					return cartId; // Return the generated cart_id
				} else {
					throw new SQLException("Inserting cart failed, no ID obtained.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1; // Indicate failure with a negative value
		}
	}

	public List<Cart> getUserCartList(int user_id) {

		List<Cart> cartList = new ArrayList<Cart>();

		try {

			String getUserList = "SELECT * FROM ecommerce_cart.cart_list WHERE user_id = ? AND status = 0 ";
			preparedStatement = connection.prepareStatement(getUserList);
			preparedStatement.setInt(1, user_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Cart cart = new Cart();
				int product_id = resultSet.getInt("product_id");
				Product product = productDao.getSingleProduct(product_id);

				cart.setCart_id(resultSet.getInt("id"));
				cart.setStatus(resultSet.getInt("status"));
				cart.setName(product.getName());
				cart.setCategory(product.getCategory());
				cart.setPrice(product.getPrice() * resultSet.getInt("quantity"));
				cart.setImage(product.getImage());
				cart.setId(product.getId());// product_id
				cart.setQuantity(resultSet.getInt("quantity"));

				cartList.add(cart);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cartList;
	}

	public boolean updateQuantity(int quantity, int cart_id, int user_id) {
		try {

			String updateQuantity = "UPDATE ecommerce_cart.cart_list SET quantity = ? WHERE id = ? AND user_id = ?";
			preparedStatement = connection.prepareStatement(updateQuantity);
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, cart_id);
			preparedStatement.setInt(3, user_id);
			System.out.println("UPDATE" + " quantity " + quantity + " cartItemId " + cart_id + " user_id " + user_id);
			boolean result = preparedStatement.executeUpdate() == 1 ? true : false;
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Cart> getOrderDetails(int order_id) {

		List<Cart> cartList = new ArrayList<Cart>();
		
		try {

			String getOrderDetails = "SELECT * FROM ecommerce_cart.cart_list INNER JOIN ecommerce_cart.orders ON cart_list.user_id = orders.user_id WHERE orders.id = ?;";
			preparedStatement = connection.prepareStatement(getOrderDetails);
			preparedStatement.setInt(1, order_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Cart cart = new Cart();
				int product_id = resultSet.getInt("product_id");
				Product product = productDao.getSingleProduct(product_id);

				cart.setCart_id(resultSet.getInt("id"));
				cart.setStatus(resultSet.getInt("status"));
				cart.setName(product.getName());
				cart.setCategory(product.getCategory());
				cart.setPrice(product.getPrice() * resultSet.getInt("quantity"));
				cart.setImage(product.getImage());
				cart.setId(product.getId());// product_id
				cart.setQuantity(resultSet.getInt("quantity"));

				cartList.add(cart);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cartList;
	}
		
		
	

	public boolean updateyStatus(int status, int cart_id) {
		try {

			String updateQuantity = "UPDATE ecommerce_cart.cart_list SET status = ? WHERE id = ?;";
			preparedStatement = connection.prepareStatement(updateQuantity);
			preparedStatement.setInt(1, status);
			preparedStatement.setInt(2, cart_id);

			System.out.println("UPDATE" + " quantity " + status + " cartItemId ");
			boolean result = preparedStatement.executeUpdate() == 1 ? true : false;
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteproduct(int product_id) {
		try {
			String deleteProduct = "DELETE FROM ecommerce_cart.cart_list WHERE product_id = ?";
			preparedStatement = connection.prepareStatement(deleteProduct);
			preparedStatement.setInt(1, product_id);

			boolean result = preparedStatement.executeUpdate() == 1 ? true : false;
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
