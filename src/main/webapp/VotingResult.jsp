
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Multipurpose Online Voting System</title>
</head>
<body>
<jsp:include page="Top.jsp"></jsp:include>
<% try{ response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setDateHeader("Expires", -1);
if(session.getAttribute("userid")==null)
{
	response.sendRedirect("home");
}
%>
<div class="container-fluid">
   

       
<div class="row">
 
<div class="col-md-6">
  <center><h2>Result</h2></center>
   <table class="table table-bordered">
 <tr>
 <th>Logo</th>
  <th>Photo 
 <th> Candidate Name</th>
 <th>Party</th>
 <th>Votes</th> 
  
  <th></th>
 </tr>
 <c:forEach var="userdsc" items="${lst}">
		 <tr>
		 <td>
		 <a href="Uploads/${userdsc.getLogo() }" target="_blank"> <img src="Uploads/${userdsc.getLogo() }" width="50px" height="50px" class="img-responsive"/></a>
		 </td>
		 <td>
		 <a href="Uploads/${userdsc.getPhoto() }" target="_blank"> <img src="Uploads/${userdsc.getPhoto() }" width="50px" height="50px" class="img-responsive"/></a>
		 </td>
		<td>${userdsc.getName() }</td>
		<td>${userdsc.getParty() }</td>
		<td>${userdsc.getVoteCount() }</td>
		 
		 </tr>
		</c:forEach> 
		 
		
		</table></div>
  <div class="col-md-6">
<jsp:include page="EncEval1.jsp"></jsp:include></div>
<%
}
catch(Exception ex)
{
	System.out.println("ex="+ex.getMessage());
} 
 %>  

<br/>
</div>
 <br/><br/>


</div>
</body>
</html>