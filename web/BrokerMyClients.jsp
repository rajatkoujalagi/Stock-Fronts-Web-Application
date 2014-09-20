<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="stockfrontpages/results.css">
<style>
table, th, td {border:1px solid black;
border-collapse:collapse;
 }
</style>
<title>My Clients</title>
</head>
<body class="body-class">
<div class="content">
<div class="header" >StockFronts Application</div>
<a href="http://localhost:8080/Struts2Starter/mystocks" style="position:absolute;right:10px;top:70px">Home</a>
<s:form action="brokerchangetoclient">

<s:textfield name="userid" label="Enter Client User ID"/>
<s:property value="message"/>
</s:form>

<s:form action="myclients">


<s:iterator value="myclientslist">
<table>
	<tr>
		<th>Client ID</th>
		<th>Name</th>
		<th>Phone</th>
		<th>Account Number</th>
	</tr>
	<tr>
		<td><s:property value="cid"/></td>
		<td><s:property value="name"/></td>
		<td><s:property value="phone"/></td>
		<td><s:property value="accno"/></td>

	</tr>

</table>
</s:iterator>
</div>

</s:form>
</div>
</div>
<div class="footer">Team StockFronts</div>
</body>
</html>