package com.advancedJava.classes;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class DataCheck {

	HttpServletRequest req;
	UserRepository uRepo;
	List<User> list;
	
	@SuppressWarnings("unchecked")
	public DataCheck(HttpServletRequest request, UserRepository uRepo) {
		this.req = request;
		this.list = (ArrayList<User>) req.getServletContext().getAttribute("listOfUsers");
		this.uRepo = uRepo;
	}
	
	
	public boolean isRegistrationPossible() {
		if(req.getParameter("username").isEmpty() || req.getParameter("password").isEmpty()
				|| req.getParameter("email").isEmpty()) {
			req.getServletContext().setAttribute("regError", "You must fill in all the fields!");
			return false;
		}
		else {
			if(uRepo.getAll().contains(uRepo.getByName(req.getParameter("username")))) {
				req.getServletContext().setAttribute("regError", "Such username already exist. Try to use some other!");
				return false;
			}
			else {
				if(req.getParameter("password").equals(req.getParameter("passConfirm"))) 
					return true;
				else
					req.getServletContext().setAttribute("regError", "You have to retype your password correctly!");
					return false;
			}
			
		}
		
	}
	
	
	public boolean isLoginPossible() {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User u = uRepo.getByName(username);
		
		if(u != null) {
			if(u.getPassword().equals(password))
				return true;
			else
				req.getServletContext().setAttribute("logError", "Wrong username or password!");
				return false;
		} 
		else {
			req.getServletContext().setAttribute("logError", "There is not such user!");
			return false;
		}
	}

}
