<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show</title>
</head>
<body>
	<h1><a href="/users/logout">Logout</a></h1>
	<h1>Breaking Bad</h1>
	
	<form:form method="POST" action="/shows/newshow" modelAttribute="creShow">
		<p><form:errors path="title" class = "error"></form:errors></p>
		<p>
			<form:label path="title">Title: </form:label>
			<form:input path="title"></form:input>
		</p>
		
			<p><form:errors path="network" class = "error"></form:errors></p>
		<p>
			<form:label path="network">Network: </form:label>
			<form:input path="network"></form:input>
		</p>
		
		
		<input type = "submit" value = "Add a Show">
	</form:form>
	<a href="/shows">Go Back</a>
</body>
</html>