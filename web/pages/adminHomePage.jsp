<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home Page</title>
<link rel="stylesheet" type="text/css" href="pages/results.css">
</head>

<body class="body-class">
<div class="content">
<div class="header" >StockFronts Application</div>
<a href="http://localhost:8080/Struts2Starter/Login.action" style="position:absolute;right:10px">Logout</a>
<s:form method="post" action="admin">

	<table>
	  <tr>
		<td><img src="pages/stocks.jpg"></td>
	<td>
		<table align="center">
			<tr>
				<td> </td>
				<td>
				
				     <input type="radio" name="user" value="user"><font size="4px">User</font><br><br> <br>
				     <input type="radio" name="company" value="company"><font size="4px"> Company</font></td>
				    
            </tr>
            
            <tr>
			  <td><input type="submit" value="Add " align="middle" name="add"></td>
              <td><input type="submit" value="Modify" align="middle" name="modify"></td>
              <td><input type="submit" value="Delete" align="middle" name="delete"></td>
            </tr>
		</table>
		</td>
	  </tr>
	</table>
</s:form>
<!-- <comments   new    code added > -->
<s:form method="post" action="viewStatistics" >
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="submit" align="middle" value="Show Statistics" name="showStats"/>
</s:form>


<div class="footer">Team SF</div>
</div>
</body>
</html>