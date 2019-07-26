<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Form</title>
<script>
	function formSubmit() {
		document.form1.action = "/spring-mvc-demo/student/processForm";
		document.form1.action.submit();
	}
</script>
<style>
.error {
	color: red
}
</style>
</head>
<body>
	<div>
		<form:form onsubmit="formSubmit()" id="form1" name="form1"
			modelAttribute="student">
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
				<form:options items="${ student.countryOptions}" />
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
			<input type="submit" value="Submit">
		</form:form>

	</div>
</body>
</html>