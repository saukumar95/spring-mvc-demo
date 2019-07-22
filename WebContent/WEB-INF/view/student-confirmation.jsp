<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation Page</title>
</head>
<body>
	The student is confirmed : ${student.firstName} ${student.lastName }
	<br>
	<br> Country : ${student.countryName }
	<br>
	<br> Favourite Language: ${student.favoriteLanguage }
	<br>
	<br> Operating System:
	<ul>
		<c:forEach var="os" items="${student.favoriteOperatingSystem }">
			<li>${ os}</li>
		</c:forEach>
	</ul>
	<br>
	<br> Free Passes: ${student.freePasses }
	<br>
	<br> Postal Code: ${student.postalCode }
	<br>
	<br> Course Code: ${student.courseCode }
</body>
</html>