<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome page</title>
<link type = "text/css" rel = "stylesheet" href = "${pageContext.request.contextPath}/resources/css/home_style.css" >
</head>
<body>
	<h1>Generic Tourism</h1><br><br>
	<input type = "button" onclick = "window.location = '${pageContext.request.contextPath}/tourism/login';" value = "Click here to Login" />
</body>
</html>