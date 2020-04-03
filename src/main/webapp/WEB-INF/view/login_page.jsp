<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false"%>
    
    <%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link type = "text/css" rel = "stylesheet" href = "${pageContext.request.contextPath}/resources/css/login_style.css" >
</head>
<body>
	<div class = "wrapper">
	<div class = "container">
		<h1>Welcome</h1>
		<form:form action = "validate" modelAttribute = "user" method = "POST" >
			Username <form:input path = "username" /><br>
			Password <form:input path = "password" type = "password" /><br>
			<input type = "submit" value = "Login" class = "save" /><br>
		</form:form>
		
	</div>
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
	</div>
	<br>
		<p>${errorMsg}</p>
</body>
</html>