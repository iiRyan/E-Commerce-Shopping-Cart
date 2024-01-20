package com.ecommerce.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.beans.Cart;
import com.ecommerce.beans.User;
import com.ecommerce.dao.CartDao;

@WebServlet("/app/inc-dec")
public class QuantityIncDecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		System.out.println("From QuantityIncDecServlet Class");

		String contextPath = request.getContextPath();
		CartDao cartDao = new CartDao();
		User user = (User) request.getSession().getAttribute("user");
		int user_id = user.getId();
		HttpSession session = request.getSession();

		try {
			String action = request.getParameter("action");
			int id = Integer.parseInt(request.getParameter("id"));

			List<Cart> sessionCartList = (ArrayList<Cart>) session.getAttribute("myCartList");

			if (action != null && id > 0) {
				switch (action) {
				case "inc":
					incrementQuantity(sessionCartList, id, user_id, cartDao);
					break;
				case "dec":
					decrementQuantity(sessionCartList, id, user_id, cartDao);
					break;
				}
			}
			response.sendRedirect(contextPath + "/app/cart-list?user_id=" + user_id);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "An error occurred while changing the quantity of the item in the cart.");
			request.getRequestDispatcher("/app/error").forward(request, response);
		}
	}

	private void incrementQuantity(List<Cart> sessionCartList, int id, int user_id, CartDao cartDao) {
		for (Cart c : sessionCartList) {
			if (c.getId() == id) {
				int quantity = c.getQuantity();
				int cart_id = c.getCart_id();
				quantity++;
				c.setQuantity(quantity);
				cartDao.updateQuantity(quantity, cart_id, user_id);
			}
		}
	}

	private void decrementQuantity(List<Cart> sessionCartList, int id, int user_id, CartDao cartDao) {
		for (Cart c : sessionCartList) {
			if (c.getId() == id && c.getQuantity() > 1) {
				int quantity = c.getQuantity();
				int cart_id = c.getCart_id();
				quantity--;
				c.setQuantity(quantity);
				cartDao.updateQuantity(quantity, cart_id, user_id);
			}
		}
	}

}
