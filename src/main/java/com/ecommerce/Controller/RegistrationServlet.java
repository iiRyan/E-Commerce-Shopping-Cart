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
	UserDAOimpl userDao = new UserDAOimpl();

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
		
		System.out.println("RegistrationServlet Class Starts...");
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if(userDao.emailIsExist(email)) {
			request.setAttribute("msg", "The Email is already exist!, please try again.");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		
		// Encrypt the password.
		String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

		User user = new User(username, email, encryptedPassword);
		System.out.println("addNewEmployee, Employee Details ==> " + user);

		
		boolean action = false;
		try {
			action = userDao.addUser(user);
			
			if (action) {

				System.out.println("Create new user Successfully!");
				request.getRequestDispatcher("login.jsp").forward(request, response);

			} else {

				request.setAttribute("msg", "Unknown login, please try again.");
				request.getRequestDispatcher("register.jsp").forward(request, response);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
