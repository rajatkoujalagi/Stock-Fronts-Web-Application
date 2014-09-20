<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New User</title>
<link rel="stylesheet" type="text/css" href="pages/results.css">
</head>

<body class="body-class">
<div class="content">
		<div class="header" >StockFronts Application</div>
		<s:form action="goBack" class="DeleteBack" theme ="simple">
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="Submit" value="Admin-Home">
</s:form>
<s:form method="post" action="adduser" id="adduser">

		<table align="center">
			<tr>
				<td>User Type </td>
				<td><input type="text" name="userType" id="userType" value=""></td>
			</tr>
			<tr>
				<td>User ID </td>
				<td><input type="text" name="userId" id="userId" value=""></td>
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
		      </td>
			</tr>           
            
            <tr>            
            </tr>
            
            <tr>
				<td><p>&nbsp;</p>
			        <p>Phone Number </p>
                </td>
				<td><p>&nbsp;</p>
				    <p><input type="text" name="phone" id="phone" value=""></p>
                </td>
			</tr>
			<tr>
				<td>Age </td>
				<td><input type="text" name="age" id="age" value=""></td>
			</tr>
                       
            <tr>
			  <td> <input type="submit" value="Add User"></td>
              <td><input type="reset" value="Cancel"></td>
            </tr>
		</table>
</s:form>
<div class="footer">Team SF</div>
</div>
</body>
</html>