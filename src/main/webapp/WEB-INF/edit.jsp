<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>
	<h1>Bad Break</h1>
	<h2>Network:    MVC</h2>

	
	<form action="/shows/destroy/${show.id}" method="POST">
		<input type="submit" value="Delete" />
	</form>
	
	
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Rating</th>
		</tr>
		<c:forEach items="${shows}" var="show">
			<tr>
				<td><a href="/shows/${show.id}">${show.id}</a></td>
					<c:if test="${show.getUsers().contains(userObj)}">
						<form action="/shows/unlike/${show.id}" method="POST">
							<button>Unlike</button>
						</form>
					</c:if>
			</tr>
		</c:forEach>
	</table>
	
	
		<form action="/shows/update${show.id}" method="POST">
		<input name="title" type="text" placeholder="${show.title}" value="${show.title}"/>
		<input name="network" type="text" placeholder="${show.network}" value="${show.network}"/>
		
		<input type="submit" value="Update" />
	</form>
	
</body>
</html>