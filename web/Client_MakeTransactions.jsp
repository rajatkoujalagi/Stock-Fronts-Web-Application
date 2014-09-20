<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="stockfrontpages/results.css">
<script>
function onSearch(){
	window.location.assign("http://localhost:8080/Struts2Starter/search1");
}
function onBuy(){
	window.location.assign("http://localhost:8080/Struts2Starter/buystocks");
}
function myStocks(){
	window.location.assign("http://localhost:8080/Struts2Starter/mystocks");
}
</script>
<style>
table, th, td {border:1px solid black;
border-collapse:collapse;
 }
</style>
</head>
<body class="body-class">
<div class="content">
		<div class="header" >StockFronts Application</div>
 <!--<input type="search" name="stock_search"> -->

<button onclick="onSearch()">Display Stocks</button> <a href="http://localhost:8080/Struts2Starter/marketplace">View Market Place</a>
<a href="http://localhost:8080/Struts2Starter/mystocks" style="position:absolute;right:10px">Home</a>
<!--<button onclick="myStocks()">My Stocks</button>
--><s:property value="ssa"/>
<br>
<s:form action="buystocks">
<s:property value="message"/>

<s:textfield name="sid" label="Stock ID"></s:textfield>

<s:textfield name="quantity" label="Quantity"></s:textfield>
<button onclick="onBuy()">Buy</button>
</s:form>
<!--<s:form action="maketran">
<s:property value="userid"/>
</s:form>
--><s:form action="search1">
<!--<s:textfield name="tcompid" label="Search Stocks"></s:textfield>
--><s:iterator value="stocks">
<table>
<tr>
	<th><b>Stock ID</b></th>
	<th><b>Company Name</b></th>
	<th><b>Company Type</b></th>
	<th><b>Current Price</b></th>
</tr>
<tr>
	<td><s:property value="stockId"/></td>
	<td><s:property value="compId"/></td>
	<td><s:property value="ctype"/></td>
	<td><s:property value="price"/></td>
	<!--<td><button> Buy </button></td>
	
--></tr>	
</table>
	<br/>
</s:iterator>
</s:form>
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

</body>
</html>