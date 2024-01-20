package com.ecommerce.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.beans.*;
import com.ecommerce.dao.CartDao;
import com.ecommerce.dao.OrderDao;

@WebServlet("/app/check-out")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		System.out.println("From CheckoutServlet Class...");

		HttpSession session = request.getSession();
		OrderDao orderDao = new OrderDao();
		String contextPath = request.getContextPath();
		User user = (User) session.getAttribute("user");
		int user_id = user.getId();
		double totalCartCost = 0;
		CartDao cartDao = new CartDao();

		int cart_id = Integer.parseInt(request.getParameter("cart_id"));

		try {
			if (cart_id != 0) {

				totalCartCost = (double) session.getAttribute("totalCartCost");
				List<Cart> sessionCartList = (ArrayList<Cart>) session.getAttribute("myCartList");

				if (sessionCartList != null && !sessionCartList.isEmpty()) {
					Order order = new Order();
					order.setUser_id(user_id);
					order.setTotal_cost(totalCartCost);

					orderDao.insertOrder(order);
					// Change the Cart_lit Status so it won't be in cartList page.
					cartDao.updateyStatus(1, cart_id);

					session.removeAttribute("totalCartCost");
					session.removeAttribute("myCartList");
					
					List<String> statuses = Arrays.asList("Completed", "In Progress", "Pending");
					request.setAttribute("statuses", statuses);

					response.sendRedirect(contextPath + "/app/orders-list");
				} 
			}else {
				request.setAttribute("status", "ListEmpty");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/app/cart.jsp");
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		    request.setAttribute("msg", "An error occurred while retrieving the cart list."); 
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
