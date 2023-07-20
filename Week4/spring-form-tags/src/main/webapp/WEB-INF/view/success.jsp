<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Added</title>
</head>
<body>
<% Exception e = (Exception) request.getAttribute("err");
	if (e != null) {
   out.write(e.getStackTrace().toString()); } %>
<h1>Hello ${emp.getName()}</h1>

</body>
</html>