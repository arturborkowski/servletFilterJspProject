<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Address form</title>
</head>
<body>
<center>



	<h2>Define your address</h2>

	<form action="addressadd.do" method="post">
	<table>
	<tr>
		<td align="right">Select type of an address: </td>
		<td>
			<select name="addressType">
			  <option value="default">--select type of an address--</option>
			  <option value="Permanent">Permanent</option>
			  <option value="Mailing">Mailing</option>
			  <option value="Workplace">Workplace</option>
			</select>
		</td>
	</tr>
	<tr>
		<td align="right">Select province: </td>
		<td>
			<select name="province">
				<option value="default">--choose province--</option>
				<option value="dolnoslaskie">dolnośląskie</option>
				<option value="kujawsko-pomorskie">kujawsko-pomorskie</option>
				<option value="lubelskie">lubelskie</option>
				<option value="lubuskie">lubuskie</option>
				<option value="lodzkie">łódzkie</option>
				<option value="małopolskie">małopolskie</option>
				<option value="mazowieckie">mazowieckie</option>
				<option value="opolskie">opolskie</option>
				<option value="podkarpackie">podkarpackie</option>
				<option value="podlaskie">podlaskie</option>
				<option value="pomorskie">pomorskie</option>
				<option value="slaskie">śląskie</option>
				<option value="swietokrzyskie">świętokrzyskie</option>
				<option value="warminsko-mazurskie">warmińsko-mazurskie</option>
				<option value="wielkopolskie">wielkopolskie</option>
				<option value="zachodniopomorskie">zachodniopomorskie</option>
			</select>
		</td>
	</tr>
	<tr>
		<td align="right">City: </td><td><input type="text" name="city" /></td>
	</tr>
	<tr>
		<td align="right">Postal code: </td><td><input type="text" name="postalCode" /></td>
	</tr>
	<tr>
		<td align="right">Street: </td><td><input type="text" name="street" /></td>
	</tr>
	<tr>
		<td align="right">House number: </td><td><input type="text" name="houseNumber" /></td>
	</tr>
	
	</table>
		<input type="submit" name="submit" value="Submit!" />
	</form>
	
</center>
</body>
</html>