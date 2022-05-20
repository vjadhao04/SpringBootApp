<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(request.getParameter("area").trim().equals("other")) {%>
<br/>
Area <input type="text" name="otherarea" required class="form-control"/>
<br/><%} %>
</body>
</html>