<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<title>Add Student</title>
</head>
<body>
<ul>
<c:forEach items="${errors}" var="error">
<li>${error}</li>
</c:forEach>
</ul>
<h1>Add Student Form</h1>
<form:form action="addStudent" modelAttribute="student" method="post">
<label for="firstname">Firstname: </label>
<form:input path="firstname" type="text" name="firstname"/>
<br>
<label for=lastname>Lastname: </label>
<form:input path="lastname" name="lastname" type="text" /> 
<br>
<form:button type="submit">Submit</form:button>
</form:form>
</body>
</html>
