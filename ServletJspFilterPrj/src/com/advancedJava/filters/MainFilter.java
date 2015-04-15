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


@WebFilter(
		urlPatterns = { 
				"/profile.jsp", 
				"/showaddress.jsp",
				"/editaddress.jsp",
				"/addaddress.jsp",
				"/grant.jsp", 
				"/premium.jsp", 
				"/showusers.jsp",
				"/logout.do"
		})
public class MainFilter implements Filter {


	public void destroy() {}

	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		
		if(session.getAttribute("logged") == null) {
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}
		
		chain.doFilter(request, response);
	}


	
	
	public void init(FilterConfig fConfig) throws ServletException {}

}
