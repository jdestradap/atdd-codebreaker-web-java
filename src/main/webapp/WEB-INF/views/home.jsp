<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Welcome to CodeBreaker!
</h1>
<% if (request.getSession().getAttribute("last_result")!=null) { %>
Your Last Result Was: [<%=request.getSession().getAttribute("last_result") %>]<br/>
<% } %>
Please input your guess:<br/>
<form action="/codebreaker/play" method="POST">
<input type="text" name="guess"/>&nbsp;
<input type="submit" value="OK" name="submit"/>
</form>
</body>
</html>
