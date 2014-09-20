<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="pages/results.css">
<title>Insert title here</title>
</head>
<body class="body-class">
<br><br><br>

<br><br><br>
	<table align="center" border=1>
			<tr>
				<td> Client(Max Tranaction) </td>
				<td>Client Name</td>
				<td>Number of Transactions</td>
			</tr>
			<%
			String clientId = (String)request.getAttribute("clientId");
			String clientName = (String)request.getAttribute("clientName");
			String clientNoDeals = (String)request.getAttribute("clientNoDeals");
			
			%>
			<tr>
			<td><%out.write(clientId); %></td>
			<td><%out.write(clientName) ;%></td>
			<td><%out.write(clientNoDeals) ;%></td>
			</tr>
			</table>
			<br><br>
			<table align="center" border=1>
			<tr>
				<td> Broker(Max Transaction) </td>
				<td>Broker Name</td>
				<td>Number of Transactions</td>
				
			</tr>
			<%
			String brokerId = (String)request.getAttribute("brokerId");
			String brokerName = (String)request.getAttribute("brokerName");
			String brokerNoDeals = (String)request.getAttribute("brokerNoDeals");
			
			%>
			<tr>
			<td><%out.write(brokerId); %></td>
			<td><%out.write(brokerName) ;%></td>
			<td><%out.write(brokerNoDeals) ;%></td>
			</tr>
			</table>
			<br><br>
		 <table align="center" border=1>
			<tr>
				<td>Popular Broker </td>
				<td>Broker Name</td>
				<td>Number of Clients</td>
				
			</tr>
			<%
			String popBrokerId = (String)request.getAttribute("popBrokerId");
			String popBrokerName = (String)request.getAttribute("popBrokerName");
			String popBrokerNoDeals = (String)request.getAttribute("popBrokerNoDeals");
			
			%>
			<tr>
			<td><%out.write(popBrokerId); %></td>
			<td><%out.write(popBrokerName) ;%></td>
			<td><%out.write(popBrokerNoDeals) ;%></td>
			</tr>
			</table> 
			<br><br>
		 <table align="center" border=1>
			<tr>
				<td>Max Profit Client </td>
				<td>Client Name</td>
				<td>Profit</td>
				
			</tr>
			<%
			String maxProfitClientId = (String)request.getAttribute("maxProfitClientId");
			String maxProfitClientName = (String)request.getAttribute("maxProfitClientName");
			String maxProfitVal = (String)request.getAttribute("maxProfitVal");
			
			%>
			<tr>
			<td><%out.write(maxProfitClientId); %></td>
			<td><%out.write(maxProfitClientName) ;%></td>
			<td><%out.write(maxProfitVal) ;%></td>
			</tr>
			</table> 
			<br><br>
		 <table align="center" border=1>
			<tr>
				<td>Max Loss Client </td>
				<td>Client Name</td>
				<td>Loss</td>
				
			</tr>
			<%
			String maxLossClientId = (String)request.getAttribute("maxLossClientId");
			String maxLossClientName = (String)request.getAttribute("maxLossClientName");
			String maxLossVal = (String)request.getAttribute("maxLossVal");
			
			%>
			<tr>
			<td><%out.write(maxLossClientId); %></td>
			<td><%out.write(maxLossClientName) ;%></td>
			<td><%out.write(maxLossVal) ;%></td>
			</tr>
			</table> 
				<br><br>
		 <table align="center" border=1>
			<tr>
				<td>Max Profit Broker </td>
				<td>Broker Name</td>
				<td>Profit</td>
				
			</tr>
			<%
			String maxProfitBrokerId = (String)request.getAttribute("maxProfitBrokerId");
			String maxProfitBrokerName = (String)request.getAttribute("maxProfitBrokerName");
			String maxProfitBrokerVal = (String)request.getAttribute("maxProfitBrokerVal");
			
			%>
			<tr>
			<td><%out.write(maxProfitBrokerId); %></td>
			<td><%out.write(maxProfitBrokerName) ;%></td>
			<td><%out.write(maxProfitBrokerVal) ;%></td>
			</tr>
			</table> 
			<br><br>
		 <table align="center" border=1>
			<tr>
				<td>Max Loss Broker </td>
				<td>Broker Name</td>
				<td>Loss</td>
				
			</tr>
			<%
			String maxLossBrokerId = (String)request.getAttribute("maxLossBrokerId");
			String maxLossBrokerName = (String)request.getAttribute("maxLossBrokerName");
			String maxLossBrokerVal = (String)request.getAttribute("maxLossBrokerVal");
			
			%>
			<tr>
			<td><%out.write(maxLossBrokerId); %></td>
			<td><%out.write(maxLossBrokerName) ;%></td>
			<td><%out.write(maxLossBrokerVal) ;%></td>
			</tr>
			</table> 
			<br><br>
	<table align="center" border=1>
			<tr>
				<td> Company(Max Tranaction) </td>
				<td>Company Name</td>
				<td>Number of Transactions</td>
			</tr>
			<%
			String compId = (String)request.getAttribute("compId");
			String compName = (String)request.getAttribute("compName");
			String maxTransaction = (String)request.getAttribute("maxTransaction");
			
			%>
			<tr>
			<td><%out.write(compId); %></td>
			<td><%out.write(compName) ;%></td>
			<td><%out.write(maxTransaction) ;%></td>
			</tr>
			</table>

<div class="footer">Team SF</div>
</html>