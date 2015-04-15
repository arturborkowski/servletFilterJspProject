package com.advancedJava.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.advancedJava.classes.DataCheck;
import com.advancedJava.classes.UserRepository;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserRepository ur = (UserRepository)getServletContext().getAttribute("userRepo");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String check = DataCheck.isLoginPossible(username, password, ur);
		if(check == null) {
			HttpSession session = request.getSession();
			session.setAttribute("logged", ur.getByName(username));
			response.sendRedirect("profile.jsp?profile="+username);
		}
		else {
			getServletContext().setAttribute("logError", check);
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
