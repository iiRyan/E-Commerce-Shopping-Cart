package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.beans.User;
import com.ecommerce.db.DBConnection;
import com.ecommerce.helper.HashPassword;

public class UserDAOimpl implements UserDAO {

	static Connection connection = DBConnection.getConnection();

	@Override
	public boolean addUser(User user) throws SQLException {
		try {
			String insertStatement = "INSERT INTO ecommerce_cart.users (name, email,password) VALUES (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());

			int result = preparedStatement.executeUpdate();
			return result == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteUser(int id) throws SQLException {
		try {
			String deleteStatement = "delete from ecommerce_cart.users where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(deleteStatement);

			preparedStatement.setInt(1, id);
			boolean result = preparedStatement.executeUpdate() == 1 ? true : false;
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User getUser(int id) {
		try {
			String query = "select * from ecommerce_cart.users where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);

			User User = new User();
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				User.setId(resultSet.getInt("id"));
				User.setName(resultSet.getString("name"));
				User.setEmail(resultSet.getString("email"));
			}
			return User;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<User> getAllUsers() throws SQLException {
		try {
			Connection connection = DBConnection.getConnection();

			String query = "SELECT * FROM ecommerce_cart.users;";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			List<User> Users = new ArrayList<User>();

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));

				Users.add(user);
			}

			return Users;
		} catch (Exception e) {
			System.out.println("exception ===================> " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateUser(User user) throws SQLException {
		try {
			String query = "update ecommerce_cart.users SET NAME = ?, email = ? WHERE id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setInt(5, user.getId());

			boolean result = preparedStatement.executeUpdate() == 1 ? true : false;
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) throws SQLException {
		UserDAOimpl UserDAOImpl = new UserDAOimpl();
		User user = new User();
		
		String password = "rayan123"; // rayan123
		String encryptedPassword = HashPassword.hashedPassword(password);

		user.setName("Rayan");
		user.setEmail("rayan@gamil.com");
		user.setPassword(encryptedPassword);
		
		
		

		System.out.println(UserDAOImpl.addUser(user));

	}

}
