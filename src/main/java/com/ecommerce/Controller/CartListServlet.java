package com.ecommerce.Controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.beans.Cart;
import com.ecommerce.dao.CartDao;
import com.ecommerce.dao.ProductDao;

@WebServlet("/app/cart-list")
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("CartListServlet Class Starts...");
		
		CartDao cartDao = new CartDao();
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		HttpSession session = request.getSession();
		ProductDao productDao = new ProductDao();
		double totalCartCost = 0;
		
		
		try {
			List<Cart> sessionCartList = (ArrayList<Cart>) session.getAttribute("myCartList");
			
			if(sessionCartList != null && !sessionCartList.isEmpty()) {
				
				sessionCartList = cartDao.getUserCartList(user_id);
				totalCartCost = productDao.getTotalCartPrice(sessionCartList);
				
				System.out.println("sessionCartList ==><> "+sessionCartList.toString());
				/*********************************Rayan*************************************
		         *  																	   *
		         * 							   No comment								   *
		         * 					   												       *
		         ***************************************************************************/
				session.setAttribute("myCartList", sessionCartList); 
				session.setAttribute("totalCartCost", totalCartCost);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/app/cart.jsp");
				dispatcher.forward(request, response);
				
			}else {
				request.setAttribute("msg", "Cart List is empty");
				
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
		
		doGet(request, response);
	}

}