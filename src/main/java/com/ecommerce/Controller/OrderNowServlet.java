package com.ecommerce.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.beans.Cart;
import com.ecommerce.beans.Order;
import com.ecommerce.beans.User;
import com.ecommerce.dao.OrderDao;

@WebServlet("/app/order-now")
public class OrderNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	OrderDao orderDao = new OrderDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		System.out.println("From OrderNowServlet Class");
		String contextPath = request.getContextPath();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		
		try {
			User user = (User) request.getSession().getAttribute("user");
			if (user != null) {
				int productId = Integer.parseInt(request.getParameter("id"));
				int productQuantity = Integer.parseInt(request.getParameter("quantity"));

				if (productQuantity <= 0) {
					productQuantity = 1;
				}

				Order order = new Order();
				order.setId(productId);
				order.setUid(user.getId());
				order.setQuantity(productQuantity);
				order.setDate(formatter.format(date));

				

				boolean result = orderDao.insertOrder(order);

				if (result) {
					List<Cart> cartList = (ArrayList<Cart>) request.getSession().getAttribute("sessionCart-list");
					if(cartList != null) {
						for(Cart c:cartList) {
							if(c.getId() == productId) {
								cartList.remove(cartList.indexOf(c));
								break;
							}
						}
						
					}
					response.sendRedirect(contextPath + "/app/cart-list");
				} else {
					System.out.println("ORDER FAILED");
				}

			} else {
				response.sendRedirect("login.jsp");
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
