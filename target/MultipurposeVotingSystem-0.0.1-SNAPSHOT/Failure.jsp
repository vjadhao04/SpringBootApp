<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cryptouch</title>
</head>
<body>
<jsp:include page="DefaultTop.jsp"></jsp:include>
<div class="container">
<%
if(request.getParameter("type").toString().trim().equals("Reg"))
{
	%><h2>Registration Failed!!</h2>
	<br/>
	<a href="index.jsp">Home</a>
<%}else if(request.getParameter("type").toString().trim().equals("UserReg"))
{
	%><h2>Registration Failed!!</h2>
	<br/>
	<a href="home">Home</a>
<%}else if(request.getParameter("type").toString().trim().equals("DelMem"))
{
	%><h2 class="h2">Members Removing Failed...</h2>
	<br/>
	<a href="/viewGroups">continue...</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("Auth"))
{
	%><h2>Authentication Failed!!</h2>
	<br/>
	<a href="index.jsp">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("GroupComm"))
{
	%><h2>Message Sending Failed!!</h2>
	<br/>
	<a href="viewMyGroups">try again</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("OneToOne"))
{
	%><h2>Message Sending Failed!!</h2>
	<br/>
	<a href="viewMyGroups">try again</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("ShareMsg"))
{
	%><h2>Message Sharing Failed!!</h2>
	<br/>
	<a href="myMessages">try again</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("DocReg"))
{
	%><h2 class="h2">Document Registration Failed!!</h2>
	<br/>
	<a href="uploaddocs">continue...</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("ShareDoc"))
{
	%><h2 class="h2">Document Sharing Failed!!</h2>
	<br/>
	<a href="getDocuments">continue...</a>
<%
}else if(request.getParameter("type").toString().trim().equals("ChangePass"))
{
	%><h2 class="h2">Password Changing Failed!!</h2>
	<br/>
	<a href="/userHome">continue...</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("passEmail"))
{
	%><h2 class="h2">Password Recovery Failed!!</h2>
	<br/>
	<a href="home">continue...</a>
<%
}
%>
</div>
</body>
</html>