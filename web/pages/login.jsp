<%@ page contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="pages/results.css">
</head>
<body class="body-class">
	<div class="content">
		<div class="header" >StockFronts Application</div>
			<br />
			<br />
			<br />
			
	<s:form method="post" action="Welcome" theme="simple">		 
<table align="center" >
<div class="td">
	  <tr>
		<td><img src="pages/stocks.jpg"></td>

		<td>
		<table align="center">
            
            <tr>
			<td> 
			<font style="margin-left: 100px" size="3px">Username</font> :<s:textfield name="username"/> <br/></br>
		
			     <font style="margin-left: 100px">Password</font> :<s:password name="password" />
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="submit" name="login" value="Login" /> 
				
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="submit"  name="register" value="Register" />
				
				</td>
			
            </tr>
		</table>
		</td>
	  </tr>
	 </div> 
	</table>
	</s:form>			
			
		
		<div class="footer">Team SF</div>
		</div>
	</body>
</html>