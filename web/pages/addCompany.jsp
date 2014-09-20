
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Company</title>
<link rel="stylesheet" type="text/css" href="pages/results.css">
</head>

<body class="body-class">
<div class="content">
		<div class="header" >StockFronts Application</div>
		<s:form action="goBack" class="DeleteBack" theme ="simple">
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="Submit" value="Admin-Home">
</s:form>
<s:form method="post" action="addCompany" id="addCompany">

		<table align="center">
			<tr>
				<td>CompanyID </td>
				<td><input type="text" name="comp" id="comp" value=""></td>
			</tr>
			
            <tr>
				<td>Company Name </td>
				<td><input type="text" name="name" id="name" value=""></td>
			</tr>
			<tr>
				<td>IPO Year </td>
				<td><input type="text" name="est" id="est" value=""></td>
			</tr>
            <tr>
				<td>Type</td>
				<td><input type="text" name="type" id="type" value=""></td>
			</tr>
            
			<tr>
				<td>Number of Stocks </td>
				<td><input type="text" name="stocks" id="stocks" value=""></td>
			</tr>
            
            <tr>
				<td>Company WebPage </td>
				<td><input type="text" name="link" id="link" value=""></td>
			</tr>
			           
            <tr>
			  <td> <input type="submit" value="Add Company"></td>
              <td><input type="reset" value="Cancel"></td>
            </tr>
		</table>
</s:form>
<div class="footer">Team SF</div>
</div>
</body>
</html>