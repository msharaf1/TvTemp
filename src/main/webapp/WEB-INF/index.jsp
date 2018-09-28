<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tv Shows</title>
</head>
<body>
	<h1>Welcome, ${userObj.firstName}!</h1>
	<h3><a href="/users/logout">Logout</a></h3>
	<h1>Shows</h1>
	
	<table border="1">
		<tr>
			<th>Shows</th>
			<th>Network</th>
			<th>Average Rating</th>
	
		</tr>
		<c:forEach items="${shows}" var="show">
			<tr>
				<td><a href="/shows/${show.id}">${show.title}</a></td>
				<td><a href="/shows/${show.id}">${show.network}</a></td>
				<td><a href="/shows/${show.id}">${show.rating}</a></td>

			</tr>
		</c:forEach>
	</table>
	<br>
	
	<form method="GET" action="/shows/newshow">
		<input type="submit" value="Add A Show"/>
	</form>
	
</body>
</html>