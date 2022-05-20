<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Voting System</title>
</head>
<body>
<jsp:include page="DefaultTop.jsp"></jsp:include>
<div class="container"><br/><br/>
<%
if(request.getParameter("type").toString().trim().equals("Reg"))
{
	%><h2 class="h2">Your Registration Done Successfully....</h2>
	<br/>
	<a href="home" class="linkStyle">Home</a>
<%}
if(request.getParameter("type").toString().trim().equals("UserReg"))
{
	%><h2 class="h2">Your Registration Done Successfully....</h2>
	<br/>
	<a href="home" class="linkStyle">Home</a>
<%}
else if(request.getParameter("type").toString().trim().equals("Emp"))
{
	%><h2 class="h2">Employee Registration Done Successfully....</h2>
	<br/>
	<a href="branchHome" class="linkStyle">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("BallotReg"))
{
	%><h2 class="h2">Ballot Registration Done Successfully....</h2>
	<br/>
	<a href="userHome" class="linkStyle">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("Branch"))
{
	%><h2 class="h2">Branch Registration Done Successfully....</h2>
	<br/>
	<a href="adminHome" class="linkStyle">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("GroupReg"))
{
	%><h2 class="h2">Group Registered Successfully....</h2>
	<br/>
	<a href="/viewGroups" class="linkStyle">Home</a>
<%
}else if(request.getParameter("type").toString().trim().equals("AddMem"))
{
	%><h2 class="h2">New Member added to selected group successfully....</h2>
	<br/>
	<a href="/viewGroups" class="linkStyle">continue...</a>
<%
}else if(request.getParameter("type").toString().trim().equals("DelMem"))
{
	%><h2 class="h2">Selected Members Removed from group successfully....</h2>
	<br/>
	<a href="/viewGroups" class="linkStyle">continue...</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("GroupComm"))
{
	%><h2 class="h2">Message Sent Successfully....</h2>
	<br/>
	<a href="viewMyGroups" class="linkStyle">continue...</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("OneToOne"))
{
	%><h2 class="h2">Message Sent Successfully....</h2>
	<br/>
	<a href="OneToOne" class="linkStyle">continue...</a>
<%
}else if(request.getParameter("type").toString().trim().equals("ShareMsg"))
{
	%><h2 class="h2">Message Shared with selected employee Successfully....</h2>
	<br/>
	<a href="myMessages" class="linkStyle">continue...</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("CandReg"))
{
	%><h2 class="h2">Candidate Registered Successfully....</h2>
	<br/>
	<a href="viewBallot" class="linkStyle">continue...</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("VoteCasted"))
{
	%><h2 class="h2">Vote Casted Successfully....</h2>
	<br/>
	<a href="userHome" class="linkStyle">continue...</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("ShareDoc"))
{
	%><h2 class="h2">Document Shared Successfully....</h2>
	<br/>
	<a href="getDocuments" class="linkStyle">continue...</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("ChangePass"))
{
	%><h2 class="h2">Password Changed Successfully....</h2>
	<br/>
	<a href="<%=session.getAttribute("utype").toString().trim() %>Home">continue...</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("passEmail"))
{
	%><h2 class="h2">New Password has been sent on your registered email id  Successfully....</h2>
	<br/>
	<a href="home" class="linkStyle">continue...</a>
<%
}
%>
</div>
</body>
</html>