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
<script>
function onSell(){
	window.location.assign("http://localhost:8080/Struts2Starter/sellstocks");
}
function navEditProf(){
	window.location.assign("http://localhost:8080/Struts2Starter/ModifyUser.action");
}
function navEditBrok(){
	window.location.assign("http://localhost:8080/Struts2Starter/myclients")
}
function navMakeTran(){
	window.location.assign("http://localhost:8080/Struts2Starter/Client_MakeTransactions.jsp")
	//window.location.assign("http://localhost:8080/Struts2Starter/search1");
}
function myStocks(){
	window.location.assign("http://localhost:8080/Struts2Starter/mystocks");
}
function navMarketPlace(){
	window.location.assign("http://localhost:8080/Struts2Starter/marketplace");
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client Home Page</title>
</head>

<body class="body-class">
<div class="content">
		<div class="header" >StockFronts Application</div>
<a href="http://localhost:8080/Struts2Starter/Login.action" style="position:absolute;right:10px">Logout</a>
	<!--<s:label> Date: </s:label><s:property value="date"/><br>-->
	Client ID :<s:property value="userid"/> <br> 
	
	<label>Name : </label><s:property value="name"/>  <br>
	<label>Status </label><s:property value="status"/> <br>
	
	<button onclick="navEditProf()">Edit Profile</button>
	
	<s:form method="post" action="viewStatistics" >
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="submit" align="middle" value="Show Statistics" name="showStats"/>
</s:form>
	<button onclick="myStocks()">My Transactions</button>	
	
	
	
	
<s:form action="sellstocks">	
 <s:textfield name="sid" label="Stock ID"/>
 <s:textfield name="quantity" label="Quantity"/>
 
<!--<s:text name=""></s:text>
--><button onclick="onSell()">Sell</button>
</s:form>
<s:property value="message"/>
<s:form action="clientlog">
<!--<table>
	<th>StockID</th>
	<th>Quantity</th>
	<th>Buying/Selling price</th>
	<th>Current Price</th>
	<th>Bought or Sold</th>
</table>
--><s:iterator value="stocks">
<table><tr>
			<!--<th>StockID</th>
			<th>Timestamp</th>
			<th>Quantity</th>
			--><!--<th>Buying Price</th>
			<th>Selling Price</th>
			--><!--<th>Status</th>
			<th>Broker</th>
		--></tr>	
		<th>StockID</th>
		<th>Quantity</th>
		<th>Buying/Selling price</th>
		<th>Current Price</th>
		<th>Bought or Sold</th>
		
		<tr>
			<td><s:property value="sid"/></td>
			<td><s:property value="quantity"/></td>
			<td><s:property value="bprice"/></td>
			<td><s:property value="cprice"/></td>
			<td><s:property value="sellorbuy"/></td>
			<!--<td>Microsoft</td>
			<td>$120</td>
			<td>$140</td>
			<td>Profit</td>
			<td>Self</td>
		--></tr>
		
	
	</table>
<br>


<!--<s:property value="compid"/>

--><br>

</s:iterator>
</s:form>
	<button onclick="navEditBrok()">My Clients</button>
	<button onclick="navMakeTran()">Make Transactions</button>
	<button onclick="navMarketPlace()">View Market</button>
	</div>
	</div>	
	
	
 </div>
	<div class="footer">Team StockFronts</div>

</body>
</html>