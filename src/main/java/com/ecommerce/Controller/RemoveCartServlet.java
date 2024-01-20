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
import com.ecommerce.beans.User;
import com.ecommerce.dao.CartDao;

/**
 * Servlet implementation class RemoveCartServlet
 */
@WebServlet("/app/remove-art-item")
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html;charset=UTF-8");
		  
		  System.out.println("Starts RemoveCartServlet Class...");
		  String contextPath = request.getContextPath();

		  User user = (User) request.getSession().getAttribute("user");
		  int product_id = Integer.parseInt(request.getParameter("product_id"));
		  System.out.println("product_id "+product_id);
		  CartDao cartDao = new CartDao();
		  
		  int user_id = user.getId();
		  try {
		     
		     if(product_id > 0) {
		        
		        List<Cart> cartList = (ArrayList<Cart>) request.getSession().getAttribute("myCartList");
		        System.out.println(cartList.size() +"  is? " +cartList.isEmpty());
		        if(cartList != null) {
		           for(Cart c:cartList) {
		              if(c.getId() == product_id) {
		                cartList.remove(cartList.indexOf(c));
		                cartDao.deleteproduct(product_id);
		                break;
		              }
		           }
		           // Update the session with the new cartList
		           request.getSession().setAttribute("myCartList", cartList);
		           response.sendRedirect(contextPath + "/app/cart-list?user_id="+user_id);
		        }
		     }else {
		        response.sendRedirect(contextPath + "/app/cart-list?user_id="+user_id);
		     }
		     
		  } catch (Exception e) {
		     System.out.println(e);
		  }
		}


}
