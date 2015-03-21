<?xml version="1.0" encoding="UTF-8" ?>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
   			 pageEncoding="UTF-8"%>
	<%@page import="java.util.ArrayList"%>
	<%@page import="com.advancedJava.classes.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Registered users</title>
</head>
<body>


<center>
	<h1>Registered users</h1>
	
	<%
		if(request.getServletContext().getAttribute("listOfUsers") == null) {
			out.println("Nie znaleziono!");
		}
		else {
			ArrayList<User> users = (ArrayList<User>) request.getServletContext().getAttribute("listOfUsers");
			for(User u: users) {
				out.println(
						"ID: " + ((users.indexOf(u)+1))
						+ "<br />Username: <a href='profile.jsp?profile="+u.getUsername()+"'>" + u.getUsername() +"</a>"
						+ "<br />Privilige: " + u.getPrivilage()
						+ "<br />Privilige: " + u.getEmail()
						+ "<br /><br />");
			}
		}
	%>
	
	<a href="grant.jsp">Grant/take privilage [ADMIN]</a><br />
	<a href="premium.jsp">Go to the PREMIUM page [PREMIUM/ADMIN]</a><br />
	<a href="logout.do">Logout</a>
</center>


</body>
</html>