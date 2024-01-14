package com.ecommerce.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.beans.Cart;

@WebServlet("/app/inc-dec")
public class QuantityIncDecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("From QuantityIncDecServlet Class");
		
		String contextPath = request.getContextPath();

		try {
			String action = request.getParameter("action");
			int id = Integer.parseInt(request.getParameter("id"));

			List<Cart> localCartList = (List<Cart>) request.getSession().getAttribute("sessionCart-list");

			if (action != null && id >= 0) {
				if (action.equals("inc")) {
					for (Cart c : localCartList) {
						if (c.getId() == id) {
							int quantity = c.getQuantity();
							quantity++;
							c.setQuantity(quantity);
							response.sendRedirect(contextPath + "/app/cart-list");
						}
					}
				}
				if (action.equals("dec")) {
					for (Cart c : localCartList) {
						if (c.getId() == id && c.getQuantity() > 1) {
							int quantity = c.getQuantity();
							quantity--;
							c.setQuantity(quantity);
						}
					}
					response.sendRedirect(contextPath + "/app/cart-list");
				}

			}else {
				response.sendRedirect(contextPath + "/app/cart-list");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
