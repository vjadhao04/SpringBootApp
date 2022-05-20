
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
 
<div class="col-md-12">
  <center><h2>My Ballots</h2></center>
   <table class="table table-bordered">
 <tr>
 <th> Title</th>
 <th>Voting Date</th>
 <th>Branch</th>
 <th>College</th>
 <th>Company</th>
 <th>State
 <th>City
 <th>Profession
 <th>Area
 <th>Constituency
 <th>Society
 <th>Description
  <th colspan="3"></th>
 </tr>
 <c:forEach var="userdsc" items="${lst}">
		 <tr>
		<td>${userdsc.getTitle() }</td>
		<td>${userdsc.getDt() }</td>
		<td>${userdsc.getCmbbranch() }</td>
		<td>${userdsc.getCmbcollege() }</td>
		<td>${userdsc.getCmbcompany() }</td> 
		<td>${userdsc.getState() }</td> 
		<td>${userdsc.getCity() }</td> 
		<td>${userdsc.getCmbprof() }</td> 
		<td>${userdsc.getCmbarea() }</td> 
		<td>${userdsc.getCmbconstituency() }</td> 
		<td>${userdsc.getCmbsociety() }</td>
		<td>${userdsc.getBallotDesc() }</td>
		<td><a href="RegisterCandidate?ballotId=${userdsc.getBallotId() }">Register Candidates</a> </td>
		 <td><a href="viewCandidateAdmin?ballotId=${userdsc.getBallotId() }">View Candidates</a> </td>
		<td>
		<a href="VoteResult?ballotId=${userdsc.getBallotId() }">View Result</a>
       
		</td>
		 </tr>
		</c:forEach> 
		 
		
		</table>
  

<%
}
catch(Exception ex)
{
	System.out.println("ex="+ex.getMessage());
} 
 %>  
</div>
<br/>
</div>
 <br/><br/>


</div>
</body>
</html>