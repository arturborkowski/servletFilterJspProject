<?xml version="1.0" encoding="UTF-8" ?>
	<%@page import="com.advancedJava.classes.UserRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   			 pageEncoding="UTF-8"%>
	<%@page import="java.util.ArrayList"%>
	<%@page import="com.advancedJava.classes.items.User"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Registered users</title>
</head>
<body>


<center>
	<h1>Registered users</h1>
	
	
	<c:forEach var="user" items="${userRepo.all }">
		<table>
			<tr>
				<td align="right">Username: </td><td><a href="profile.jsp?profile=${user.username }">${user.username }</a></td>
			</tr>
			<tr>
				<td align="right">Privilage: </td><td>${user.privilage }</td>
			</tr>
			<tr>
				<td align="right">Email: </td><td>${user.email }</td>
			</tr>
		</table>
		<br />
	
	</c:forEach>
	

	<a href="grant.jsp">Grant/take privilage [ADMIN]</a><br />
	<a href="premium.jsp">Go to the PREMIUM page [PREMIUM/ADMIN]</a><br />
	<a href="logout.do">Logout</a>
</center>


</body>
</html>