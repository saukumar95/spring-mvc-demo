<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>List Student</title>
</head>
<body class="bg-secondary vh-100">
	<div class="container mt-3">
		<ul>
			<c:forEach var="os" items="${studentList }">
				<li>${ os.firstName}&nbsp;${ os.lastName}&nbsp;<span><a
						class="text-light"
						href="/spring-mvc-demo/student/showStudent/${os.id}">Show</a></span>
				</li>
			</c:forEach>
		</ul>
		<span><a class="text-light" href="/spring-mvc-demo/">Home</a></span>
	</div>
</body>
</html>