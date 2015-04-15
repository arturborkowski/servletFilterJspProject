package com.advancedJava.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.advancedJava.classes.items.User;


@WebFilter("/profile.jsp")
public class ProfilePageFilter implements Filter {

 
	public void destroy() {}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		if(session.getAttribute("logged") != null) {
			
			User user = (User)session.getAttribute("logged");
			if(!user.getUsername().equals((String)req.getParameter("profile"))) {
				req.getRequestDispatcher("/denied.jsp").forward(req, resp);
				/*resp.sendRedirect("denied.jsp");*/
			}
		}
		else {
			req.getServletContext().setAttribute("logError", "Please log in first!");
			resp.sendRedirect("index.jsp");
		}
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {}

}
