<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="stockfrontpages/results.css">
<script>

</script>
<style>
table, th, td {border:1px solid black;
border-collapse:collapse;
 }
</style>
</head>
<body class="body-class">
<s:form action="marketplace">
<div class="content">
		<div class="header" >StockFronts Application</div><!--
Search company: <input type="search" name="stock_search"> <button onclick="onSearch()">Search</button> 
--><a href="http://localhost:8080/Struts2Starter/mystocks" style="position:absolute;right:10px">Home</a>
<!--<form action="CMT">-->
<!--<s:property value="user"/>-->
<b></b><br/>

<s:iterator value="stocks">
<table>
<tr>
	<tr>
    <th>Company name</th>
    <!--<th>Company ID</th>
	--><th>IPOYear</th>
	<th>Company Type</th>
	<th>Link</th>
	<th>No. of Stocks</th>
	</tr>
	<td><s:property value="compname"/></td>
	<!--<td><s:property value="compid"/></td>
	--><td><s:property value="ipoyear"/></td>
	<td><s:property value="ctype"/></td>
	<td><s:property value="link"/></td>
	<td><s:property value="nostocks"/></td>
	
	
	
</tr>	
</table>
	<!--<s:property value="price"/>-->
	<br/>
</s:iterator>
<br/><br/>
<!--<form>-->
<!-- <table align="center">
	<tr>
		<th>Broker ID</th>
		<th>Name</th>
		<th>StockID</th>
		<th>Company</th>
		<th>Modify</th>
	</tr>
	
	<tr>
		<td>BR_014</td>
		<td>Sam</td>
		<td>ST_877</td>
		<td>Amazon</td>
		<td><button>Remove</button></td>
	</tr>
	
	<tr>
		<td>BR_138</td>
		<td>John</td>
		<td>ST_654</td>
		<td>Microsoft</td>
		<td><button>Remove</button></td>
	</tr>
	
	
	
	
	
</table> -->
</div>
<div class="footer">Team StockFronts</div>
</s:form>
</body>
</html>