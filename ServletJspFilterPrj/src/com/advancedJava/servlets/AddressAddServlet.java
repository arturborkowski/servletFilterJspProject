package com.advancedJava.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.advancedJava.classes.AddressBuilder;
import com.advancedJava.classes.items.Address;
import com.advancedJava.classes.items.User;


@WebServlet("/addressadd.do")
public class AddressAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Address a = new AddressBuilder().build(request);
		User currentUser = (User)request.getSession().getAttribute("logged");
		
		if(a != null) {
			currentUser.getAddresses().add(a);
			response.sendRedirect("showaddress.jsp");
		}
			
		
	}

}
