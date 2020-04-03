<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false" %>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Page</title>
<link type = "text/css" rel = "stylesheet" href = "${pageContext.request.contextPath}/resources/css/table_styles.css" >
</head>
<body>
	<div class = "container">
	<input type ="button" value = "Add New Entry" onclick = "window.location.href = 'showFormForAdd'; return false;"
	class = "add-button" /><br><br>
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>FROM-LOCATION</th>
			<th>TO-LOCATION</th>
			<th>NO:OFDAYS</th>
			<th>PRICE</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var = "tempEntry" items = "${listOfEntries}" >
		<c:url var = "updateLink" value = "/tourism/showFormForUpdate" >
			<c:param name = "tourId" value = "${tempEntry.id }" />
		</c:url>
		<c:url var = "deleteLink" value = "/tourism/showFormForDelete" >
			<c:param name = "TourId" value = "${tempEntry.id }" />
		</c:url>
			<tr>
				<td>${tempEntry.id}</td>
				<td>${tempEntry.name}</td>
				<td>${tempEntry.fromLocation}</td>
				<td>${tempEntry.toLocation}</td>
				<td>${tempEntry.noOfDays}</td>
				<td>${tempEntry.price}</td>
				<td><button id = "update" onclick = "location.href = '${updateLink}';">UPDATE</button></td>
				<td><button id = "delete" onclick = "location.href = '${deleteLink}';">DELETE</button></td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<input id = "search" type = "button" onclick = "window.location = '${pageContext.request.contextPath}/tourism/showFormForSearch';" value = "Search" />
	<input id = "logout" type = "button" onclick = "window.location = '${pageContext.request.contextPath}/tourism/login';" value = "Logout" />
</body>
</html>