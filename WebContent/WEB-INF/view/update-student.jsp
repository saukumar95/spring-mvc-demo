<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation Page</title>
<style>
.error {
	color: red
}
</style>
</head>
<body>
	<div>
		<form:form method="POST"
			action="/spring-mvc-demo/student/updateAndSave">
			<form:hidden path="id" />
			<label>First Name:<span style="color: 'red'">*</span></label>
			<form:input path="firstName" />
			<form:errors path="firstName" cssClass="error"></form:errors>
			<br>
			<br>
			<label>Last Name:<span style="color: 'red'">*</span></label>
			<form:input path="lastName" />
			<form:errors path="lastName" cssClass="error"></form:errors>
			<br>
			<br>
			<label>Country:</label>
			<form:select path="countryName">
				<form:options items="${countryOptions}" />
			</form:select>
			<br>
			<br>
			Java <form:radiobutton path="favoriteLanguage" value="Java" />
			Python <form:radiobutton path="favoriteLanguage" value="Python" />
			NodeJs <form:radiobutton path="favoriteLanguage" value="NodeJs" />
			C# <form:radiobutton path="favoriteLanguage" value="C#" />
			<br>
			<br>
			Free passes: <form:input path="freePasses" />
			<form:errors path="freePasses" cssClass="error" />
			<br>
			<br>
			Postal Code: <form:input path="postalCode" />
			<form:errors path="postalCode" cssClass="error" />
			<br>
			<br>
			Course Code: <form:input path="courseCode" />
			<form:errors path="courseCode" cssClass="error" />
			<br>
			<br>
			<input type="submit" value="Update">
			<span><a href="/spring-mvc-demo/student/showStudent/${id }">Back</a></span>
		</form:form>
	</div>
</body>
</html>