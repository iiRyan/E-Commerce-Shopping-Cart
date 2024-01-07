package com.ecommerce.Controller;

import java.io.IOException;

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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    String email = request.getParameter("email");
	    String paramPassword = request.getParameter("password");

	    UserDAOimpl userDao = new UserDAOimpl();
	    User user = userDao.userLogin(email,paramPassword); // Fetch user details from DB based on email

	    if (user != null) {
	        String storedPassword = user.getPassword(); // Get the hashed password from the user object

	        boolean isValid = BCrypt.checkpw(paramPassword, storedPassword); // Check if passwords match using BCrypt

	        if (isValid) {
	            HttpSession session = request.getSession(true);
	            session.setAttribute("user", user);
	            System.out.println(user.toString()); 
	            RequestDispatcher dispatcher = request.getRequestDispatcher("app/index.jsp");
	            dispatcher.forward(request, response);
	        } else {
	            request.setAttribute("msg", "Invalid credentials");
	            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	            rd.forward(request, response);
	        }
	    } else {
	        request.setAttribute("msg", "User not found");
	        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	        rd.forward(request, response);
	    }
	}



}
