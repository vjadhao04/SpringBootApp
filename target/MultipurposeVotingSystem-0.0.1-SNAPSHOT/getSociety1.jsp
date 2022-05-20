<%@page import="java.util.List"%>
<%@page import="models.GetData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
GetData get=new GetData();
String city=request.getParameter("city").trim();
String state=request.getParameter("state").trim();
String area=request.getParameter("area").trim();
get.setCity(city);
get.setState(state);
get.setArea(area);
if(area.equals("other"))
{
	%>
	<br/>Area   <input type="text" name="otherarea" required class="form-control"/>
<br/>
<input type="hidden" name="cmbsociety" value="other"/>
	Society <input type="text" name="otherSociety" required class="form-control"/>
<br/>
	<%
}
else
{
	 
get.getSociety(); 
%>
 
                    <%		
								 
									 
									 List<String> lstareList=get.getLstsociety();
									 %>
									  <select required name="cmbsociety" class="form-control" onchange="makeGetRequestSociety(this.value)">
									 <option value=""><--select--></option>
										<%for(int i=0;i<lstareList.size();i++)
											{%>
									 <option value="<%=lstareList.get(i).trim() %>"><%=lstareList.get(i).trim() %></option>											
											<%}%>
										  	<option value="NA">NA</option>	
										  	<option value="other">other</option>														  
									 </select>
                     
             <%} %>  
</body>
</html>