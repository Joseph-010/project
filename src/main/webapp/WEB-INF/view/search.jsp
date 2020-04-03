<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Page</title>
<style>

html,body {
	height: 100%;
	background: linear-gradient(45deg, #91c4fa, #9514f7);
}

h1{
	position: absolute;
	top: 7%;
	left: 32%;
	font-family: verdana;
	font-size: 45px;
	color: lightgrey;
}
.container {
	position: absolute;
	top: 40%;
	left: 60%;
	transform: translate(-50%, -50%);
	width: 60%;
	
}
table {
	width: 600px;
	border-collapse: collapse;
	overflow: hidden;
	box-shadow: 0 0 20px rgba(0,0,0,0.1);
}

td {
	padding: 15px;
	background-color: rgba(255,255,255,0.2);
	color: #fff;
}
tr td:first-child{
	text-align: right;
}

label{
	font-family: verdana;
	font-size: 17px;
}

input[type = submit]{
	padding: 13px 22px 13px 22px;
	background-color: rgba(50,205,50,0.6);
	font-family:verdana;
	font-size: 15px;
}
input[type = submit]:hover{
	background-color: rgba(50,205,50,1);
}

input{
	border-radius: 10px;
	padding: 5px 12px 5px 12px;
	border: 1px solid white;
	background-color: rgba(255,255,255,0.5);
}

</style>
</head>
<body>
	<h1>Search by Locations</h1>
	<div class = "container">
	<form:form action = "processSearch" modelAttribute = "formData" method = "POST">
	<table>
		<tr>
		<td><label>From-Location</label></td>
		<td><form:input path = "locationA" /></td>
		</tr>
		<tr>
		<td><label>To-Location</label></td>
		<td><form:input path="locationB"/></td>
		</tr>
		<tr>
			<td><input type = "submit" value = "Search" /></td>
		</tr>
	</table>
	</form:form>
	</div>
</body>
</html>