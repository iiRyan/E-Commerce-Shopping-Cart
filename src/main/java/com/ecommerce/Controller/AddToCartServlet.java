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

@WebServlet("/app/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("AddToCartServlet Class Starts...");
		RequestDispatcher requestDispatcher  = null;
		
		try{
			
			List<Cart> cartList = new ArrayList<Cart>();
			
			// Get the id from the request.
			int id = Integer.parseInt(request.getParameter("id"));
			
			Cart cart = new Cart();
			cart.setId(id);
			//By Default set Quantity 1.
			cart.setQuantity(1);
			
			HttpSession session = request.getSession();
			
			// Try to get the cart list from the session
			// sessionCartList is a list of Cart objects. Each Cart object represents a single item in the shopping cart. 
			List<Cart> sessionCartList = (ArrayList<Cart>) session.getAttribute("sessionCart-list");
			
			 // If the sessionCartList is null or equals null
			if(sessionCartList == null || sessionCartList.equals(null)) {
				cartList.add(cart);
				session.setAttribute("sessionCart-list", cartList);
				request.setAttribute("status", "notExist");
				requestDispatcher = request.getRequestDispatcher("/app/index");
				requestDispatcher.forward(request, response);
				
			}
			
			// If the cart list is not null, set it to the local variable
			else {
				// set the sessionCartList to local cartList.
				cartList = sessionCartList;
				boolean isExist = false;
				
				for(Cart c: sessionCartList) {
					if(c.getId() == id) {
						isExist = true;
						request.setAttribute("status", "isExist");
						requestDispatcher = request.getRequestDispatcher("/app/index");
						requestDispatcher.forward(request, response);
					}
					
				}
				// If the cart does not exist in the list
				if(!isExist) {
					// Add the new cart to the list
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
