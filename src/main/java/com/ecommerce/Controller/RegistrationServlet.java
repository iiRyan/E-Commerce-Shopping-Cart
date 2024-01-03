package com.ecommerce.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.ecommerce.beans.User;
import com.ecommerce.dao.UserDAOimpl;
import com.ecommerce.helper.HashPassword;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		
		// Encrypt the password.
		String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

		User user = new User(username, email, encryptedPassword);
		System.out.println("addNewEmployee, Employee Details ==> " + user);

		UserDAOimpl userDao = new UserDAOimpl();

		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;

		try {
			boolean action = userDao.addUser(user);

			if (action) {

				dispatcher = request.getRequestDispatcher("login.jsp");
				System.out.println("Create new user Successfully!");
				session.setAttribute("msg", "You've Successfully Registerd");
				dispatcher.forward(request, response);

				
			} 
			else {
				dispatcher = request.getRequestDispatcher("register");
				session.setAttribute("msg", "Something Went Wrong!");
				
			}
		} 
		
		catch (SQLException e) {
			System.out.println(e);
		}
	}

}
