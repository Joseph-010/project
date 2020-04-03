<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false" %>
    
    <%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form for ADD</title>
<style type="text/css">
html,body {
	height: 100%;
	background: linear-gradient(45deg, #59fff4, #0a16a1);
}

.error{
	color:red;
}

.container {
	position: absolute;
	top: 40%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 60%;
}

table {
	width: 800px;
	border-collapse: collapse;
	overflow: hidden;
	box-shadow: 0 0 20px rgba(0,0,0,0.1);
}

th,td {
	padding: 15px;
	background-color: rgba(255,255,255,0.2);
	color: #fff;
}

th {
	text-align: left;
}

thead th{
	background-color: #55608f;
}

input{
	border-radius: 10px;
	padding: 5px 12px 5px 12px;
	border: 1px solid white;
	background-color: rgba(255,255,255,0.5);
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
input[type = button]{
	position: absolute;
	top: 70%;
	left:20%;
	background-color: rgba(255,128,0,0.7);
	padding: 15px 22px 15px 22px;
	font-family:verdana;
	font-size: 15px;
}
input[type = button]:hover{
	background-color: rgba(255,128,0,1);
}
label{
	font-family: verdana;
	font-size: 17px;
}

</style>
</head>
<body>
	<div class = "container">
	<form:form action = "processForm" modelAttribute = "entry" method = "POST">
		<form:hidden path="id"/>
		<table>
			<tbody>
				<tr>
					<td><label>Name</label></td>
					<td><form:input path="name" /></td>
					<td><form:errors path = "name" cssClass = "error" /></td>
				</tr>
				<tr>
					<td><label>From-Location</label></td>
					<td><form:input path="fromLocation" /></td>
					<td><form:errors path = "fromLocation" cssClass = "error" /></td>
				</tr>
				<tr>
					<td><label>To-Location</label></td>
					<td><form:input path="toLocation" /></td>
					<td><form:errors path = "toLocation" cssClass = "error" /></td>
				</tr>
				<tr>
					<td><label>No: of Days</label></td>
					<td><form:input path="noOfDays" /></td>
					<td><form:errors path = "noOfDays" cssClass = "error" /></td>
				</tr>
				<tr>
					<td><label>Price</label></td>
					<td><form:input path="price" /></td>
					<td><form:errors path = "price" cssClass = "error" /></td>
				</tr>
				<tr>
					<td><input type = "submit" value = "Save" class = "save" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	</div>
	<input type = "button" onclick = "window.location = '${pageContext.request.contextPath}/tourism/list';" value = "Display List" />
	
</body>
</html>