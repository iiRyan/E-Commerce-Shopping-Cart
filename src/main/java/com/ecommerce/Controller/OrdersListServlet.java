package com.ecommerce.Controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.beans.Order;
import com.ecommerce.beans.User;
import com.ecommerce.dao.OrderDao;


@WebServlet("/app/orders-list")
public class OrdersListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrdersListServlet Class Starts...");
		
		OrderDao orderDao = new OrderDao();
		HttpSession session = request.getSession(false);
		DecimalFormat decimaPrice = new DecimalFormat("#.##");
		
		User user = (User)session.getAttribute("user");
		
		try {
			List<Order> orderList = orderDao.userOrder(user.getId());
			System.out.println(orderList.toString());
			request.setAttribute("orderList", orderList);
			System.out.println("OrderList Size ==> "+ orderList.size());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/app/orders.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
