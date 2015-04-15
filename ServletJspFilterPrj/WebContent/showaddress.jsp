<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.advancedJava.classes.items.User, com.advancedJava.classes.items.Address, java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Addresses</title>
</head>
<body>
<center>

		<h2>Addresses of user ${logged.username }</h2>

	<c:forEach items="${logged.addresses}" var="address">
	
			<b>${address.type} address:</b>
			<table>
				<tr><td align="right">City: </td><td>${address.postalCode } ${address.city }</td></tr>
				<tr><td align="right">Street: </td><td>${address.street } ${address.houseNumber }</td></tr>
				<tr><td align="right">Voivodeship:</td><td> ${address.province }</td></tr>
			</table>
			
			<a href="editaddress.jsp?address=${address.id}">Edit </a>
			<a href="deleteaddress.do?address=${address.id}">Delete</a>
			<br /><br />
		
	</c:forEach>
	
	
	
	<a href="addaddress.jsp">Add address</a> <br />
	<a href="profile.jsp?profile=${logged.username}">Back</a>
	
	

</center>

</body>
</html>