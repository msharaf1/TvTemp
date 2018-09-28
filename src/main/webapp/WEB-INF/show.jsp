<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>
				
				
	<h1>Show Page</h1>
	
	<form:form action="/shows/update/${show.id}" method="POST" modelAttribute="show">

    	<p><form:errors path="title"/></p>
    	<p>
        	<form:label path="title">Show: </form:label>
        	<form:input path="title"/>
    	</p>
		
		<p><form:errors path="network" class = "error"></form:errors></p>
		<p>
			<form:label path="network">Network:  </form:label>
			<form:input path="network"></form:input>
		</p>
		
		<p><form:errors path="rating" class = "error"></form:errors></p>
		<p>
			<form:label path="rating">Rating:  </form:label>
			<form:input path="rating"></form:input>
		</p>
		
		
		<input type="submit" value="Update" />
	</form:form>

					<form action="/shows/delete/${ show.id }" method = "post">
						<input type = "hidden" name = "_method" value = "delete">
						<input type = "submit" value = "Delete Show">
					</form>
					
	
	<br><hr>
				<div>
					<form action = "/shows" method = "get">
						<input type = "submit" value = "Back To Homepage">
					</form>
		<br><hr>
					<form action = "/users/logout" method = "get">
						<input type = "submit" value = "Logout">
					</form>
				</div>
		<hr><hr>		


	
	
</body>
</html>