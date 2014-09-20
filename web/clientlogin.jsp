<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
function func(){
	window.location.assign("http://localhost:8080/Struts2_Hello_World/clientlog");
}
</script>
<title>Insert title here</title>
</head>
<body>
<s:form action="clientlog">
<s:textfield name="userid"/>
<button onclick="func()">Submit</button>
</s:form>
</body>
</html>