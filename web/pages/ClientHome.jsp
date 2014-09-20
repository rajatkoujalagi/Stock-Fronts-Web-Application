<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="pages/results.css">
<style>
table, th, td {border:1px solid black;
border-collapse:collapse;
 }
</style>
<script>
function onSell(){
	window.location.assign("http://localhost:8080/Struts2_Hello_World/sellstocks");
}

function navEditBrok(){
	window.location.assign("http://localhost:8080/Struts2_Hello_World/Client_EditBroker.jsp")
}
function navMakeTran(){
	window.location.assign("http://localhost:8080/Struts2_Hello_World/Client_MakeTransactions.jsp")
}
function myStocks(){
	window.location.assign("http://localhost:8080/Struts2_Hello_World/mystocks");
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client Home Page</title>
</head>

<body class="body-class">
<div class="content">
		<div class="header" >StockFronts Application</div>
		

	<s:form method="post" action="ModifyUser" >
	<%
		String username =(String) request.getAttribute("username");
		String name = (String) request.getAttribute("name");
		
		
		%>
	Client ID : <input type = "text" name="username" id="username" value="<%  out.write(username);     %>" readonly /> 
	Name : <input type = "text" name="name" id="name" value="<%  out.write(name);     %>" readonly />  
	<input type="Submit" value="Edit Profile">
	</s:form>
	
	
	
	<label>Status </label><input type="text"> <br>
	
	
	<label style="position:absolute; right:120px; top: 70px;">Recommendations</label> 	
			<textarea readonly rows="4" cols="50" style="position:absolute; right:20px; top:90px;">
			</textarea>
	<button onclick="myStocks()">My Stocks</button>	
	
	
	
	
<s:form action="sellstocks">	
Stock ID <s:textfield name="sid"/>
Quantity <s:textfield name="quantity"/>
<!--<s:text name=""></s:text>
--><button onclick="onSell()">Sell</button>
</s:form>
<s:property value="message"/>
<s:form action="clientlog">
<table>
	<th>StockID</th>
	<th>Quantity</th>
</table>
<s:iterator value="stocks">
<table><tr>
			<!--<th>StockID</th>
			<th>Timestamp</th>
			<th>Quantity</th>
			--><!--<th>Buying Price</th>
			<th>Selling Price</th>
			--><!--<th>Status</th>
			<th>Broker</th>
		--></tr>	
		
		<tr>
			<td><s:property value="sid"/></td>
			<td><s:property value="quantity"/></td>
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
	<button onclick="navEditBrok()">Edit Brokers</button>
	<button onclick="navMakeTran()">Make Transactions</button>
	<button onclick="">View Market</button>
	</div>
	</div>	
	
	
 </div>
	<div class="footer">Team StockFronts</div>

</body>
</html>