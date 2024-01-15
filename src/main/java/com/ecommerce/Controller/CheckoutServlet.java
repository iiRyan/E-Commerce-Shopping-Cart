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

import com.ecommerce.beans.*;
import com.ecommerce.dao.OrderDao;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/app/check-out")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("From CheckoutServlet Class...");
		
		
		String contextPath = request.getContextPath();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		// TODO: This method has been implemented before in OrderNowServlet To achive the DRY concept create an Helper class and call the method from there.
		try {
			User user = (User) request.getSession().getAttribute("user");
			List<Cart> cartList = (ArrayList<Cart>) request.getSession().getAttribute("sessionCart-list");
			
			if(user != null && cartList != null) {
				for(Cart c:cartList) {
					Order order = new Order();
					order.setId(c.getId());
					order.setUid(user.getId());
					order.setQuantity(c.getQuantity());
					order.setDate(formatter.format(date));
					
					OrderDao orderDao = new OrderDao();
					boolean result = orderDao.insertOrder(order);
					if(!result) break;
				}
				cartList.clear();
				response.sendRedirect(contextPath + "/app/orders.jsp");
			}else {
				if(user == null || user.equals(null)) response.sendRedirect(contextPath + "login.jsp");	
				response.sendRedirect(contextPath + "/app/cart-list");
					
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
