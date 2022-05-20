<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(request.getParameter("const").trim().equals("other")) {%>
<br/><input type="text" name="otherconst" required class="form-control"/>
<br/><%} %>
</body>
</html>