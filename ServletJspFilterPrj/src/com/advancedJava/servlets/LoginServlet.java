package com.advancedJava.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.advancedJava.classes.DataCheck;
import com.advancedJava.classes.DummyDataBase;
import com.advancedJava.classes.UserRepository;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
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
 
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserRepository ur = (UserRepository)getServletContext().getAttribute("userRepo");
		
		if(new DataCheck(request, ur).isLoginPossible()) {
			HttpSession session = request.getSession();
			session.setAttribute("logged", ur.getByName(request.getParameter("username")));
			response.sendRedirect("profile.jsp?profile="+request.getParameter("username"));
		}
		else {
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
