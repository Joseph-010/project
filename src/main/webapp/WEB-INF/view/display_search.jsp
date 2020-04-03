<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false" %>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Result</title>
<style>

html,body {
	height: 100%;
}

h1{
	position: absolute;
	top: 2%;
	left: 32%;
	font-family: verdana;
	font-size: 40px;
	color: #ff9a26;
}

body {
	margin: 0;
	background: linear-gradient(to top,rgba(252,186,106,0.8),rgba(209,6,40,0.8));
	font-family: sans-serif;
	font-weight: 100;
}

.container {
	position: absolute;
	top: 20%;
	left: 50%;
	transform: translate(-50%, -50%);
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

</style>
</head>
<body>
	<h1>Your Search Results</h1>
	<div class = "container">
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>FROM-LOCATION</th>
			<th>TO-LOCATION</th>
			<th>NO:OFDAYS</th>
			<th>PRICE</th>
			
		</tr>
		<c:forEach var = "tempEntry" items = "${resultList}" >
			<tr>
				<td>${tempEntry.id}</td>
				<td>${tempEntry.name}</td>
				<td>${tempEntry.fromLocation}</td>
				<td>${tempEntry.toLocation}</td>
				<td>${tempEntry.noOfDays}</td>
				<td>${tempEntry.price}</td>
			</tr>
		</c:forEach>
		</table>
		</div>
</body>
</html>