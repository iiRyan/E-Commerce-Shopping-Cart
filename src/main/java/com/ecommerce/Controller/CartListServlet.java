package com.ecommerce.Controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.beans.Cart;
import com.ecommerce.beans.User;
import com.ecommerce.dao.CartDao;
import com.ecommerce.dao.ProductDao;

@WebServlet("/app/cart-list")
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("CartListServlet Class Starts...");
		
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		HttpSession session = request.getSession();
		
		CartDao cartDao = new CartDao();
		List<Cart> cartList = cartDao.getUserCartList(user_id);
		session.setAttribute("myCartList", cartList);
		System.out.println("mynewCartList Size ==> "+ cartList.size());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/app/cart.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
