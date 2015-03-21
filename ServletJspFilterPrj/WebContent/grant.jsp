<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

	<h2>Grant "Premium" privilage</h2>
	
	<form action="grant.do" method="post">
		Username: <input type="text" name="username" /> <br />
		<input type="radio" name="privilage" value="grant" checked/> Grant premium 
		<input type="radio" name="privilage" value="take" /> Take premium <br />
		<input type="submit" name="submit"  value="Execute!" /> <a href="showusers.jsp">Back</a>
	</form>
	
	<%
		if(request.getAttribute("message") != null) {
			out.println("<font color=green>"+request.getAttribute("message")+"</font>");
		}
	%>
	
	
</body>
</html>