<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Student</title>
</head>
<body>
	<div>
		<ul>
			<c:forEach var="os" items="${studentList }">
				<li>${ os.firstName}</li>
				<li>${ os.lastName}</li>
				<li>${ os.countryName}</li>
				<li>${ os.favoriteLanguage}</li>
				<li>${ os.freePasses}</li>
				<li>${ os.postalCode}</li>
				<li>${ os.courseCode}</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>