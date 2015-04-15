package com.advancedJava.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.advancedJava.classes.UserRepository;
import com.advancedJava.classes.items.Privilage;


@WebServlet("/grant.do")
public class GrantingPrivilageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("grant.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String check = request.getParameter("privilage");
		UserRepository userRepo = (UserRepository) getServletContext().getAttribute("userRepo");
		
		if(userRepo.getByName(userName) != null) {
			switch(check) {
				case "grant":
				{
					userRepo.getByName(userName).setPrivilage(Privilage.PREMIUM);
					request.setAttribute("message", "Premium granted!");
					getServletContext().getRequestDispatcher("/grant.jsp").forward(request, response);
					break;
				}
				case "take":
				{
					userRepo.getByName(userName).setPrivilage(Privilage.DEFAULT);
					request.setAttribute("message", "Set to default!");
					getServletContext().getRequestDispatcher("/grant.jsp").forward(request, response);
					break;
				}
				default:
				{}
			}
			
		}
		else {
			request.setAttribute("message", "User not found!");
			getServletContext().getRequestDispatcher("/grant.jsp").forward(request, response);
			
		}
	}

}
