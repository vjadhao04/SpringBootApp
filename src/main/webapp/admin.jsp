 
 
<%@page import="services.JavaFuns"%>
<%@page import="java.util.Vector"%>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html:html>
<head>
    <html:base/>
    <title>Admin</title>
</head>
<body>
   <%
         try{
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setDateHeader("Expires", -1);
 if((session.getAttribute("userid")==null))             
        {
                response.sendRedirect("Invalidate.jsp");
        }
        else if(session.getAttribute("utype").equals("admin")==false)
        {
                response.sendRedirect("Invalidate.jsp");
        }
  
       
%>
     <jsp:include page="Top.jsp"></jsp:include>     
<div id="main">
        
 
        
               <%     
        String userid=String.valueOf(session.getAttribute("user"));
        System.out.println("utype in admin "+String.valueOf(session.getAttribute("utype")));
        String typ=String.valueOf(session.getAttribute("utype"));        
       JavaFuns jf=new JavaFuns();
       Vector v=jf.getValue("select userName,userid,mobile,email,profession from userdetails", 5);
       
     // response.sendRedirect("preferenceWisePhotos.jsp");
        %>
       
            
     
        <center> <h2>Admin Home</h2></center>
    <table class="table table-borderd">
    <tr>
    <th>User Name</th>
    <th>Userid</th>
    <th>Mobile</th>
    <th>Email</th>
     
    <th>Profession</th>
    </tr>
    <%
    for(int i=0;i<v.size();i=i+5)
    {
    	%><tr>
    	<td><%=v.elementAt(i).toString().trim() %></td>
    	<td><%=v.elementAt(i+1).toString().trim() %></td>
    	<td><%=v.elementAt(i+2).toString().trim() %></td>
    	<td><%=v.elementAt(i+3).toString().trim() %></td>
    	<td><%=v.elementAt(i+4).toString().trim() %></td>
     
    	 </tr>
    	<%
    }
    %>
    </table>
        
 
     
</div>
        </center> <%}catch(Exception ex){}%>
     <jsp:include page="Bottom.jsp"></jsp:include> 
    </body>
</html:html> 
