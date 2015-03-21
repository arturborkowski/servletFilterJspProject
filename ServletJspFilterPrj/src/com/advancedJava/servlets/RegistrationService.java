package com.advancedJava.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.advancedJava.classes.DataCheck;
import com.advancedJava.classes.DummyDataBase;
import com.advancedJava.classes.User;
import com.advancedJava.classes.UserBuilder;
import com.advancedJava.classes.UserRepository;


@WebServlet("/registration.do")
public class RegistrationService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@Override
	public void init() throws ServletException {  
		
		// create in context database and repository to action on database
		if(getServletContext().getAttribute("userRepo") == null) {
			DummyDataBase db = new DummyDataBase();
			getServletContext().setAttribute("userRepo", new UserRepository(db));
			getServletContext().setAttribute("listOfUsers", db.users);
		}
		
		super.init();
	}

	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.sendRedirect("register.jsp");
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		UserRepository userRepo = (UserRepository)request.getServletContext().getAttribute("userRepo");
		
		if(new DataCheck(request, userRepo).isRegistrationPossible()) {
			User newUser = new UserBuilder(request).build();
			userRepo.add(newUser);
			request.getServletContext().setAttribute("message", "You are successfully registered. You may now log in!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
			
		
		}
		else {
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		
		
	}

}
