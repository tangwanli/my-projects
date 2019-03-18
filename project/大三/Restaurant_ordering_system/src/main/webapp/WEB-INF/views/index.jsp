<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<font color="red">
		<%= session.getAttribute("message") == null ? "" : session.getAttribute("message")%>
	</font>
	<form action="http://localhost:8080/Restaurant_ordering_system/checkcode" method="post">
	<br>
		name: <input type="text" name="name"/>
		<br>
		password<input type="password" name="password"/>
		<br>
		checkCode: <input type="text" name="CHECK_CODE_PARAM_NAME"/> 
		<img alt="" src="http://localhost:8080/Restaurant_ordering_system/getVcode"> 
		<input type="submit" value="Submit"/>
	</form>
	
</body>
</html>