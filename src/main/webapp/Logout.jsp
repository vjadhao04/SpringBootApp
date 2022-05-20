<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body><jsp:include page="DefaultTop.jsp"></jsp:include>
<%
//HttpSession sess=request.getSession();  
//session.invalidate();  

%>
<h2>You are successfully logged out</h2>
<br><br><hr>
<a href="index.jsp">Login</a>
<%response.sendRedirect("index.jsp"); %>
</body>
</html>