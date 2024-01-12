package com.ecommerce.Controller;

import java.io.IOException;
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

		List<Cart> myList = new ArrayList<Cart>();

		try {

			// Get the CartList that stored in session.
			ArrayList<Cart> localCartList = (ArrayList<Cart>) session.getAttribute("sessionCart-list");

			if (localCartList != null) {
				myList = productDao.getCartProducts(localCartList);
				
				double listOfPrices = productDao.getTotalCartPrice(localCartList);
				
				request.setAttribute("listOfPrices", Math.floor(listOfPrices));
				session.setAttribute("localCartList", myList);
				System.out.println("cartList Size ==> " + myList.size() + "\nMy list items ==> " + myList.toString());

				RequestDispatcher dispatcher = request.getRequestDispatcher("/app/cart.jsp");
				dispatcher.forward(request, response);

			} else {
				request.setAttribute("msg", "No Cart List here");
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
