<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Registration form</title>
</head>
<body>
	
	<h1>Fill in all the fields!</h1>
	
	<%
		if(request.getServletContext().getAttribute("regError") != null) {
			out.println("<font color=red>"+getServletContext().getAttribute("regError")+"</font>");
			request.getServletContext().setAttribute("regError", null);
		}
	%>
	
	<form action="registration.do" method="post">
		<table>
			<tr>
				<td>Username: </td><td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>Password: </td><td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td>Confirm password: </td><td><input type="password" name="passConfirm"/></td>
			</tr>
			<tr>
				<td>Email: </td><td><input type="text" name="email"/></td>
			</tr>
		</table>
		<input type="checkbox" name="admin" value="admin" /> Register as admin <br />
		<input type="submit" name="submit" value="Register!" /> 
		or <a href="index.jsp">log in!</a>
	</form>

</body>
</html>