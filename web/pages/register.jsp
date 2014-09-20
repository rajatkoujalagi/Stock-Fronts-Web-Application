
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="pages/results.css">
</head>

<body class="body-class">
<div class="content">
		<div class="header" >StockFronts Application</div>
<s:actionerror />
<s:form method="post" action="register">

		<table align="center">
			<tr>
				<td>E-mail ID </td>
				<td><input type="text" name="email" id="email" value=""></td>
			</tr>
			<tr>
				<td><p>Password </p>
			    <p>&nbsp;</p></td>
				<td><p>
				  <input type="password" name="passwd" id="passwd" value="">
				</p>
			    <p>&nbsp; </p></td>
			</tr>
            <tr>
				<td>Name </td>
				<td><input type="text" name="name" id="name" value=""></td>
			</tr>
			<tr>
				<td>Address </td>
				<td><input type="text" name="add1" id="add1" value=""></td>
			</tr>
            <tr>
				<td></td>
				<td><input type="text" name="add2" id="add2" value=""></td>
			</tr>
            <tr>
				<td></td>
				<td><p>
				  <input type="text" name="add3" id="add3" value="">
				</p>
			    <p>&nbsp; </p></td>
			</tr>           
            <tr>            </tr>
            <tr>
				<td>Phone Number </td>
				<td><input type="text" name="phone" id="phone" value=""></td>
			</tr>
			<tr>
				<td>Date of Birth </td>
				<td><input type="text" name="age" id="age" value=""></td>
			</tr>
            <tr>
				<td><p>Account Number</p>
			    <p>&nbsp; </p></td>
				<td><p>
				  <input type="text" name="account" id="account" value="">
				</p>
			    <p>&nbsp; </p></td>
			</tr>
			<tr>
				<td>Type </td>
				<td><input type="radio" name="client" id="client" value="client">Client<br>
				    <input type="radio" name="broker" id="broker" value="broker">Broker
            </tr>
            
            <tr>
			  <td><input type="submit" value="Register" align="middle"></td>
              <td><input type="reset" value="Cancel" align="middle"></td>
            </tr>
		</table>
</s:form>
<div class="footer">Team SF</div>
</div>
</body>
</html>