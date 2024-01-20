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

		CartDao cartDao = new CartDao();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Cart cart = new Cart();

		int user_id = Integer.parseInt(request.getParameter("user_id"));
		int product_id = Integer.parseInt(request.getParameter("id"));

		try {
			cart.setId(product_id);
			cart.setUser_id(user_id);
			cart.setQuantity(1); // By Default Quantity is 1.
			

			List<Cart> sessionCartList = (ArrayList<Cart>) session.getAttribute("myCartList");

			if (sessionCartList == null || sessionCartList.isEmpty()) {
				if (user != null) {
					int cartInsertionResult = cartDao.insertCartList(cart);

					List<Cart> cartList = new ArrayList<>();

					cart.setCart_id(cartInsertionResult);
					cartList.add(cart);
					System.out.println("cartList ===> " + cartList.toString());

					session.setAttribute("myCartList", cartList);
					request.setAttribute("status", "notExist");
				}
			} else {
				boolean isExist = sessionCartList.stream()
												  .anyMatch(c -> c.getId() == product_id);

				if (isExist) {
					request.setAttribute("status", "isExist");

				} else {

					int result = cartDao.insertCartList(cart);
					cart.setCart_id(result);
					sessionCartList.add(cart);

					System.out.println("From AddToCartList The CartList Size ==> " + sessionCartList.toString());

					request.setAttribute("status", "notExist");
				}

			}

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/app/index");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("msg", "An error occurred while adding the item to the cart.");
			request.getRequestDispatcher("/app/error").forward(request, response);
		}
	}
}
