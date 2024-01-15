package com.ecommerce.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.OrderDao;

/**
 * Servlet implementation class CancelOrderServlet
 */
@WebServlet("/app/cancel-order")
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("From CancelOrderServlet Class");
		String contextPath = request.getContextPath();

		
		try {
			String id = request.getParameter("id");
			System.out.println("The id ==> "+id );
			if(id != null) {
				OrderDao orderDao = new OrderDao();
				orderDao.cancleOrder(Integer.parseInt(id));
			}
			
			response.sendRedirect(contextPath + "/app/orders-list");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
