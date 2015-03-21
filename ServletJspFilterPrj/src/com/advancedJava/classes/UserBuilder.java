package com.advancedJava.classes;

import javax.servlet.http.HttpServletRequest;


public class UserBuilder {

	HttpServletRequest req;
	
	public UserBuilder(HttpServletRequest request) {
		this.req = request;
	}
	
	
	public User build() {
		User u = new User();
		u.setUsername(req.getParameter("username"));
		u.setPassword(req.getParameter("password"));
		u.setEmail(req.getParameter("email"));
		if(req.getParameter("admin")==null)
			u.setPrivilage(Privilage.DEFAULT);
		else 
			u.setPrivilage(Privilage.ADMIN);
		
		return u;
	}

}
