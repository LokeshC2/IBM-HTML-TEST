<%@ page
	import="java.util.List, java.util.ArrayList, com.example.model.League"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<title>Add League</title>
</head>

<body>

	<h1>Add League</h1>
	<%
	List<?> temp = (List<?>) request.getAttribute("ERROR");
	List<String> errors = new ArrayList<String>();
	for (Object o : temp)
		errors.add((String) o);

	if (!errors.isEmpty())
		for (String str : errors)
			out.println("<font color='red'>" + str + "</font><br />");
	%>
	<p>This form allows you to create a new soccer league.</p>

	<form action="addLeague" method="POST">
		Year: <input type="text" name="year" /> <br /> <br /> Season: <select
			name="season">
			<%
			List<String> seasons = (List<String>) request.getAttribute("seasons");
			for (String str : seasons)
				out.println("<option value='" + str + "'>" + str + "</option>");
			%>
		</select> <br /> <br /> Title: <input type='text' name="title" /> <br /> <br />
		<input type="submit" value="Add League" />
	</form>
	<a href="./"><- Back to Home</a>
</body>

</html>