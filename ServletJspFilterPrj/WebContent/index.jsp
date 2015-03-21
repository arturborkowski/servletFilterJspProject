<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Login page</title>
</head>
<body>

	<h1>Please log in!</h1>
	
	<form action="login.do" method="post">
		<table>
			<tr>
				<td>Login: </td><td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>Password: </td><td><input type="password" name="password"/></td>
			</tr>
		</table>
		<input type="submit" name="submit" value="Log in!" />
		or <a href="register.jsp">register!</a>
	</form>
	
	<%
		if(request.getServletContext().getAttribute("logError") != null) {
			out.println("<font color=red>"+request.getServletContext().getAttribute("logError")+"</font>");
			request.getServletContext().setAttribute("logError", null);
		}
		else if(request.getServletContext().getAttribute("message") != null) {
			out.println("<font color=green>"+request.getServletContext().getAttribute("message")+"</font>");
			request.getServletContext().setAttribute("message", null);
		}
	
		
	%>

</body>
</html>