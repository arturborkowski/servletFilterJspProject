package com.advancedJava.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.advancedJava.classes.DataCheck;
import com.advancedJava.classes.UserBuilder;
import com.advancedJava.classes.UserRepository;
import com.advancedJava.classes.items.Message;
import com.advancedJava.classes.items.User;


@WebServlet("/registration.do")
public class RegistrationService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.sendRedirect("register.jsp");
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		UserRepository userRepo = (UserRepository)request.getServletContext().getAttribute("userRepo");
		User newUser = new UserBuilder().build(request);
		
		if(newUser == null) {
			request.getServletContext().setAttribute("regError", Message.PASSWORD_NOT_CONFIRMED);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		else
		{
			String check = DataCheck.isRegistrationPossible(newUser, userRepo);
			if(check == null) {
				userRepo.add(newUser);
				request.getServletContext().setAttribute("message", Message.LOGIN_SUCCESS);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else {
				request.getServletContext().setAttribute("regError", check);
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
		}
		
		
	}

}
