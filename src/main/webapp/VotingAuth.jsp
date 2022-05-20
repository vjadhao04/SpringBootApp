<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Multipurpose Online Voting</title>
</head>
<body>
<jsp:include page="DefaultTop.jsp"></jsp:include>
<% try{ response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setDateHeader("Expires", -1);
 
  %>
  <div class="container jumbotron">
  <center><h2>Secrete Key Authentication</h2></center>
  <div class="row">
  <div class="col-md-6">
  <img src="images/otp.png" width="70%"/>
  </div>
  <div class="col-md-6">
  <form action="KeyAuth" method="post">
  <table>
  <tr>
  <td>Userid</td>
  <td>
  <input type="text" value="<%=request.getAttribute("userid").toString().trim() %>" name="userid" class="form-control" required/>
    
  </td>
  </tr>
   <tr>
  <td>Secrete Key</td>
  <td>
  <input type="password" name="otp" class="form-control" required/>
  <input type="hidden" value="<%=request.getAttribute("otp").toString().trim() %>" name="sentOTP" />
  <input type="hidden" value="<%=request.getAttribute("ballotId").toString().trim() %>" name="ballotId" />
   <input type="hidden" value="<%=request.getAttribute("email").toString().trim() %>" name="email" />
  </td>
  </tr>
   <tr>
  <td colspan="2"><input type="submit" class="btn btn-primary" value="Submit"/>  </td>   
  </tr>
  </table>
  </form>
  </div></div></div>
  <%
}
catch(Exception ex)
{
	
}
%>
</body>
</html>