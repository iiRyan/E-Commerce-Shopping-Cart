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
import com.ecommerce.dao.ProductDao;

@WebServlet("/app/cart-list")
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("CartListServlet Class Starts...");
		
		ProductDao productDao = new ProductDao();
		HttpSession session = request.getSession();
		DecimalFormat decimaPrice = new DecimalFormat("#.##");
	
		try {

			// Get the CartList that stored in sessionAttribut.
			List<Cart> localCartList = (List<Cart>) session.getAttribute("sessionCart-list");

			if (localCartList != null) {
				
				localCartList = productDao.getCartProducts(localCartList);
				double listOfPrices = productDao.getTotalCartPrice(localCartList);
				
				request.setAttribute("listOfPrices", decimaPrice.format(listOfPrices));
				session.setAttribute("localCartList", localCartList);
				System.out.println("cartList Size ==> " + localCartList.size() + "\nMy list items ==> " + localCartList.toString());

				RequestDispatcher dispatcher = request.getRequestDispatcher("/app/cart.jsp");
				dispatcher.forward(request, response);

			} else {
				request.setAttribute("msg", "The Cart is Empty");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/app/cart.jsp");
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
