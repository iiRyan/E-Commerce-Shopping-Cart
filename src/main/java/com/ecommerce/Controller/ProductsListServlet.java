package com.ecommerce.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.beans.Product;
import com.ecommerce.dao.ProductDao;

/**
 * Servlet implementation class ProoductsListServlet
 */
@WebServlet("/app/index")
public class ProductsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   System.out.println("ProductsListServlet Class Starts...");

		   ProductDao productDao = new ProductDao();
		   List<Product> products = null;

		   try {
		       products = productDao.getAllProducts();
		       
		   } catch (Exception e) {
		       e.printStackTrace();
		       request.setAttribute("msg", "An error occurred while retrieving the products.");
		       return;
		   }

		   request.setAttribute("products", products);		
		   RequestDispatcher dispatcher = request.getRequestDispatcher("/app/index.jsp");
		   dispatcher.forward(request, response);
		}

}

