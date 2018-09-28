<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review Page</title>
</head>
<body>
<h1>Review Page</h1>


<body>
		<c:if test="${user != null}"><a href="/shows/rating">Home</a></c:if>
		<c:if test="${user != null}"><a href="/users/new">Logout</a></c:if>

		<h1>Review Of: ${rating}</h1>

		<form:form action="/rating/${show.id}/review" method="POST" modelAttribute="review">
			<form:label path="rating">Rating:
				<form:errors path="rating"></form:errors>
				<form:select path="rating">
					<c:forEach items="${rating}" var="rate">
						<form:option value="${rating}">${rating}</form:option>
					</c:forEach>
				</form:select>
			</form:label>

			<input type="submit" value="Submit Review">
		</form:form>
		
		
</body>
</html>