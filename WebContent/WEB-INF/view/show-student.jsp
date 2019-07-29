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
	<div>
		<ul>
			<li>${student.firstName}</li>
			<li>${student.lastName}</li>
			<li>${student.countryName}</li>
			<li>${student.favoriteLanguage}</li>
			<li>${student.freePasses}</li>
			<li>${student.postalCode}</li>
			<li>${student.courseCode}</li>
		</ul>
		<span><a href="/spring-mvc-demo/student/listStudent">Back</a></span> <span><a
			href="/spring-mvc-demo/student/updateStudent/${student.id}">Edit</a></span>
		<span><a
			href="/spring-mvc-demo/student/deleteStudent/${student.id}">Delete</a></span>
	</div>
	<script type="text/javascript">
		var abc = document.getElementsByTagName("LI")[0].innerText;
		if (abc === "") {
			alert("Not Records Found")
		}
	</script>
</body>
</html>