<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
</head>
<body>
	<h1>Add an Employee:</h1>
	<br>
	<form action='addEmployee' method='post'>
		Name: <input name='name' /> <br> Salary: <input name='salary' />
		<br>
		<input type=submit value=submit />
	</form>
</body>
</html>