package com.advancedJava.classes;

import javax.servlet.http.HttpServletRequest;

import com.advancedJava.classes.ifaces.IBuilder;
import com.advancedJava.classes.items.Privilage;
import com.advancedJava.classes.items.User;


public class UserBuilder implements IBuilder<User> {

	private User u = new User();

	public UserBuilder() {}
	
	
	@Override
	public User build(HttpServletRequest req) {
		
		
		if(req.getParameter("password").equals(req.getParameter("passConfirm"))) {
			
			u.setUsername(req.getParameter("username"));
			u.setPassword(req.getParameter("password"));
			u.setEmail(req.getParameter("email"));
			if(req.getParameter("admin")==null)
				u.setPrivilage(Privilage.DEFAULT);
			else 
				u.setPrivilage(Privilage.ADMIN);
			
			return u;
		}
		
		return null;
	}

}
