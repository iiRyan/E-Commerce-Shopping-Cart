package com.ecommerce.Controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/app/*")
public class LoginFilter extends HttpFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init(FilterConfig config) throws ServletException {
		// If you have any <init-param> in web.xml, then you could get them
		// here by config.getInitParameter("name") and assign it as field.
	}

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp"); // No logged-in user found, so redirect to login
																		// page.
		} else {
			chain.doFilter(request, response); // Logged-in user found, so just continue request.
		}
	}

	@Override
	public void destroy() {
		// If you have assigned any expensive resources as field of
		// this Filter class, then you could clean/close them here.
	}

}
