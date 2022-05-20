
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
  <center><h2>Cast Your Vote Carefully</h2></center>
  <form method="post" action="castVote">
   <table class="table table-bordered">
 <tr>
 <th>Logo</th>
  <th>Photo 
 <th> Candidate Name</th>
 <th>Party</th> 
  

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
		  
		<td> <input class="form-radio" type="radio" name="cid" value="${userdsc.getCid() }"/></td>
		
		 </tr>
		</c:forEach> 
		 <tr><td colspan="4">
		 <input type="hidden" name="userid" value="<%=session.getAttribute("userid").toString().trim() %>"/>
		 <input type="hidden" name="ballotId" value="<%=request.getAttribute("ballotId").toString().trim() %>"/>
		 <input type="submit" class="form-control" value="Submit"/></td>
		
		</table>
  </form>

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