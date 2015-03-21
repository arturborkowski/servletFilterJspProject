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

import com.advancedJava.classes.Privilage;
import com.advancedJava.classes.User;


@WebFilter({ "/grant.jsp", "/grant.do" })
public class GrantingPageFilter implements Filter {

    
	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		if(session.getAttribute("logged") != null) {
			
			User user = (User)session.getAttribute("logged");
			if(user.getPrivilage()!=Privilage.ADMIN) {
				req.getRequestDispatcher("/denied.jsp").forward(req, resp);
			}
		}
		
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
