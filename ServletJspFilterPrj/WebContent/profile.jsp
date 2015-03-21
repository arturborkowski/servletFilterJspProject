<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="javax.websocket.SendResult"%>
<%@page import="com.advancedJava.classes.UserRepository"%>
<%@page import="com.advancedJava.classes.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

<%

		String user = request.getParameter("profile");
		UserRepository ur = (UserRepository) getServletContext().getAttribute("userRepo");
		User u = ur.getByName(user);
	
%>

		<center>
		
			<h1> Hello <%=u.getUsername() %>!</h1>
			
			Your access level is: <%= u.getPrivilage() %><br />
			Your email adress is: <%= u.getEmail() %><br /><br />
			
			<a href="logout.do">Logout</a> <br />
			<a href="showusers.jsp">Show all users</a>
			
		
			
		</center>
		


</body>
</html>