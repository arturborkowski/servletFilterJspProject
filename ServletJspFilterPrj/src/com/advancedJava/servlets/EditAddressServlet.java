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


@WebServlet("/editaddress.do")
public class EditAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/addaddress.jsp").forward(request, response);		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String addressId = request.getParameter("addressId");
		User user = (User)request.getSession().getAttribute("logged");
		
		int index = user.getAddresses().indexOf(getAddressById(Integer.parseInt(addressId), user));
		user.getAddresses().set(index, new AddressBuilder().build(request));
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
