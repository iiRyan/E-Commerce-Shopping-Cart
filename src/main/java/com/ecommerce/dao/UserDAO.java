package com.ecommerce.dao;

import java.sql.SQLException;
import java.util.List;

import com.ecommerce.beans.User;

public interface UserDAO {

	// 1- Insert new User
	public boolean addUser(User user) throws SQLException;

	// 2- Delete User
	public boolean deleteUser(int userId) throws SQLException;

	// 3- Update User
	public boolean updateUser(User User) throws SQLException;

	// 4- Get User using User ID
	public User getUser(int UserId) throws SQLException;

	// 5- Get All Users
	public List<User> getAllUsers() throws SQLException;
}
