package com.ecommerce.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.beans.Cart;
import com.ecommerce.dao.CartDao;

/**
 * Servlet implementation class RemoveCartServlet
 */
@WebServlet("/app/remove-art-item")
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartDao cartDao = null;;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("Starts RemoveCartServlet Class...");
		String contextPath = request.getContextPath();
		
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		System.out.println("product_id "+product_id);
		
		try {
			
			if(product_id > 0) {
				
				List<Cart> cartList = (ArrayList<Cart>) request.getSession().getAttribute("sessionCart-list");
				
				if(cartList != null) {
					for(Cart c:cartList) {
						if(c.getId() == product_id) {
							cartList.remove(cartList.indexOf(c));
							cartDao.deleteproduct(product_id);
							
							break;
						}
					}
					response.sendRedirect(contextPath + "/app/cart-list");
				}
			}else {
				response.sendRedirect(contextPath + "/app/cart-list");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
