package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.ecommerce.beans.Cart;
import com.ecommerce.beans.Product;
import com.ecommerce.db.DBConnection;

public class CartDao {

	static Connection connection = DBConnection.getConnection();
	private PreparedStatement preparedStatement;
	private ProductDao productDao = new ProductDao();

	public boolean insertCartList(Cart cart) {

		try {
			String insertCart = "INSERT INTO ecommerce_cart.cart_list (user_id, product_id, quantity) VALUES(?,?,?)";
			preparedStatement = connection.prepareStatement(insertCart);

			preparedStatement.setInt(1, cart.getUser_id());
			preparedStatement.setInt(2, cart.getId()); // ProductID
			preparedStatement.setInt(3, cart.getQuantity());

			int result = preparedStatement.executeUpdate();

			return result == 1 ? true : false;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public List<Cart> getUserCartList(int user_id) {

		List<Cart> cartList = new ArrayList<Cart>();

		try {

			String getUserList = "SELECT * FROM ecommerce_cart.cart_list WHERE user_id = ? ";
			preparedStatement = connection.prepareStatement(getUserList);
			preparedStatement.setInt(1, user_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Cart cart = new Cart();
				int product_id = resultSet.getInt("product_id");
				Product product = productDao.getSingleProduct(product_id);
				cart.setName(product.getName());
				cart.setCategory(product.getCategory());
				cart.setPrice(product.getPrice()*resultSet.getInt("quantity"));
				cart.setImage(product.getImage());
				cart.setQuantity(resultSet.getInt("quantity"));
				
				cartList.add(cart);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		
		return cartList;
	}
}
