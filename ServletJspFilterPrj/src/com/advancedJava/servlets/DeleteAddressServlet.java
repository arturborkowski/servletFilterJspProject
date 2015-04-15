package com.advancedJava.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.advancedJava.classes.items.Address;
import com.advancedJava.classes.items.User;


@WebServlet("/deleteaddress.do")
public class DeleteAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String addressId = request.getParameter("address");
		User user = (User)request.getSession().getAttribute("logged");
		
		
		user.getAddresses().remove(getAddressById(Integer.parseInt(addressId), user));
		response.sendRedirect("showaddress.jsp");
		
	}
	
	private Address getAddressById(int id, User user){
		for(Address a: user.getAddresses() ) {
			if(a.getId()==id)
				return a;
		}
		return null;
	}

}
