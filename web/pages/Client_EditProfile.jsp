<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="pages/results.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
function navhome(){
	window.location.assign("http://localhost:8080/Struts2Starter/mystocks");
	
}


</script>
</head>
<body class="body-class">
	<div class="content">
		<div class="header">StockFronts Application</div>
		<s:form method="post" action="updateUserDetails" theme="simple">
		
		<table align="center">
			<tr>
				<td>Userid </td>
				<td><input type="text" name="userId" id="userId" value=<s:property value="userId"/>></td>
			</tr>
			
            <tr>
				<td>First Name </td>
				<td><input type="text" name="fname" id="fname" value=<s:property value="fname"/>></td>
			</tr> 
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lname" id="lname" value=<s:property value="lname"/>></td>
			</tr>
            <tr>
				<td>Phone Number</td>
				<td><input type="text" name="phNo" id="phNo" value=<s:property value="phNo"/>  ></td>
			</tr>
            
			<tr>
				<td>BirthDate </td>
				<td><input type="text" name="bday" id="bday" value=<s:property value="bday"/>></td>
			</tr>
            
            <tr>
				<td>Email  </td>
				<td><input type="text" name="email" id="email" value=<s:property value="email"/>></td>
			</tr>
			
			  <tr>
				<td>Account Number  </td>
				<%
				String accNo = (String) request.getAttribute("accNo");
				 %>
				<td><input type="text" name="accNo" id="accNo" value="<%out.write(accNo);%>" /></td>
			</tr>
			           
            <tr>
			  <td><input type="submit" value="Update" /> </td>
             
            </tr>
		</table>
		</s:form>
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<button onclick="navhome()"> Home </button>
	</div>
	<div class="footer">Team StockFronts</div>
</body>
</html>