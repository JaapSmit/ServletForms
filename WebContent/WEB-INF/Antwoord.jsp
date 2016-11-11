<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<ul>
	<li><%= request.getAttribute("antwoord1") %></li>
	<li><%= request.getAttribute("antwoord2") %></li>
	<li><%= request.getAttribute("antwoord3") %></li>
	<li><%= request.getAttribute("antwoord4") %></li>
	<li><%= request.getAttribute("antwoord5") %></li>
</ul>

<form action="Antwoord">
<input type="text" name="getal1" />
<select name="operatie">
<option value="plus"> plus </option>
<option value="min"> min </option>
<option value="vermenigvuldig"> vermenigvuldig met</option>
<option value="delen"> delen door </option>
</select> <br>
<input type="text" name="getal2" />
<input type="submit" value="submit" /></form>



</body>
</html>