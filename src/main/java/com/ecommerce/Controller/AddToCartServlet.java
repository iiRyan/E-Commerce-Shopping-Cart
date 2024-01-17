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
import com.ecommerce.beans.User;
import com.ecommerce.dao.CartDao;

@WebServlet("/app/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		

		System.out.println("AddToCartServlet Class Starts...");
		RequestDispatcher requestDispatcher = null;
		String contextPath = request.getContextPath();
		CartDao cartDao = new CartDao();
		HttpSession session = request.getSession();
		User user = (User) request.getSession().getAttribute("user");
		Cart cart = new Cart();
		
		
		
		

		int user_id = Integer.parseInt(request.getParameter("user_id"));
		int product_id = Integer.parseInt(request.getParameter("id"));
		
		cart.setId(product_id);
		cart.setUser_id(user_id);
		cart.setQuantity(1); // By Default Quantity is 1.
		
		

		List<Cart> sessionCartList = (ArrayList<Cart>) session.getAttribute("sessionCart-list");

		try {
			List<Cart> cartList = new ArrayList<Cart>();

			if (sessionCartList == null || sessionCartList.equals(null) && user != null) {
				
				
				System.out.println(user_id);
				boolean result = cartDao.insertCartList(cart);
				
				
				cartList.add(cart);

				
				

				session.setAttribute("sessionCart-list", cartList);
				requestDispatcher = request.getRequestDispatcher("/app/index");
				requestDispatcher.forward(request, response);
			} else {
				cartList = sessionCartList;
				boolean isExist = false;

				for (Cart c : sessionCartList) {
					if (c.getId() == product_id) {
						isExist = true;
						request.setAttribute("status", "isExist");
						requestDispatcher = request.getRequestDispatcher("/app/index");
						requestDispatcher.forward(request, response);
					}
				}
				if(!isExist) {
					// Add the new cart to the list
					boolean result = cartDao.insertCartList(cart);
					cartList.add(cart);
					System.out.println("From AddToCartList The CartList Size ==> " + cartList.size());
					request.setAttribute("status", "notExist");
					requestDispatcher = request.getRequestDispatcher("/app/index");
					requestDispatcher.forward(request, response);
				}
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
