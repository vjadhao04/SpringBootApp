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
get.setCity(city);
get.setState(state);
get.getConstituency();
get.getArea(); 
%>
<table><tr><td>Area</td>
                    <td>
                    <%		
								 
									 
									 List<String> lstareList=get.getLstarea();
									 %>
									  <select required name="cmbarea" class="form-control" onchange="makeGetRequestAreaS1(this.value)">
									 <option value=""><--select--></option>
										<%for(int i=0;i<lstareList.size();i++)
											{%>
									 <option value="<%=lstareList.get(i).trim() %>"><%=lstareList.get(i).trim() %></option>											
											<%}%>
										 <option value="NA">NA</option>
										 <option value="other">other</option>															  
									 </select>
                    <div id="area"></div>
                </tr>
                 <tr><td>Constituency</td>
                    <td>
                    <%		
								 
									 
									 List<String> lstconst=get.getLstcontituency();
									 %>
									  <select required name="cmbconstituency" class="form-control" onchange="makeGetRequestConst(this.value)"  >
									 <option value=""><--select--></option>
										<%for(int i=0;i<lstconst.size();i++)
											{%>
									 <option value="<%=lstconst.get(i).trim() %>"><%=lstconst.get(i).trim() %></option>											
											<%}%>
										 <option value="NA">NA</option>	
										 <option value="other">other</option>														  
									 </select>
                     <div id="const"></div>
                     
                </tr></table>
</body>
</html>