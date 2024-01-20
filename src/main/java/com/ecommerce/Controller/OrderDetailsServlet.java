package com.ecommerce.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.beans.Cart;
import com.ecommerce.dao.CartDao;


@WebServlet("/app/order-details")
public class OrderDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("From OrderDetailsServlet Class...");
		
		HttpSession session = request.getSession();
		int order_id = Integer.parseInt(request.getParameter("id"));
		
		try {
			
			List<Cart> ordersList = new ArrayList<Cart>();
			
			CartDao cartDao = new CartDao();
			ordersList = cartDao.getOrderDetails(order_id);
			
			
			System.out.println(ordersList.toString()+" \nOrderlist size ==> "+ ordersList.size());
			session.setAttribute("ordersList", ordersList); 
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/app/ordersDetails.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		    request.setAttribute("msg", "An error occurred while retrieving the cart list."); 
		}
	}


	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
