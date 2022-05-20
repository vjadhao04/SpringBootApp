<%@page import="java.util.Date"%>
<%@page import="models.States"%>
<%@page import="models.GetStateNCities"%>
<%@page import="java.util.List"%>
<%@page import="models.GetData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Multipurpose Voting System</title>

<script language="Javascript" type="text/javascript">
 

function createRequestObject() {
    var tmpXmlHttpObject;
    if (window.XMLHttpRequest) {
            tmpXmlHttpObject = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        tmpXmlHttpObject = new ActiveXObject("Microsoft.XMLHTTP");
    }

    return tmpXmlHttpObject;
}


var http = createRequestObject();

function makeGetRequest(st) {
   // st=document.frm.state.value;
    
    http.open('get', 'Cities1.jsp?state=' + st);
    http.onreadystatechange = processResponseState;
    http.send(null);
}

function processResponseState() {
    if(http.readyState == 4){
        var response = http.responseText;
        document.getElementById('cities').innerHTML = response;
    }
}
 
</script>

<script language="Javascript" type="text/javascript">
 

function createRequestObject() {
    var tmpXmlHttpObject;
    if (window.XMLHttpRequest) {
            tmpXmlHttpObject = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        tmpXmlHttpObject = new ActiveXObject("Microsoft.XMLHTTP");
    }

    return tmpXmlHttpObject;
}


var http = createRequestObject();

function makeGetRequestCity1(st) {
    state=document.frm.state.value;
    alert(state);
    http.open('get', 'area.jsp?city=' + st+'&state='+state);
    http.onreadystatechange = processResponseArea;
    http.send(null);
}

function processResponseArea() {
    if(http.readyState == 4){
        var response = http.responseText;
        document.getElementById('area').innerHTML = response;
    }
}
 
</script>

<script language="Javascript" type="text/javascript">
 

function createRequestObject() {
    var tmpXmlHttpObject;
    if (window.XMLHttpRequest) {
            tmpXmlHttpObject = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        tmpXmlHttpObject = new ActiveXObject("Microsoft.XMLHTTP");
    }

    return tmpXmlHttpObject;
}


var http = createRequestObject();

function makeGetRequestArea1(st) {
   state=document.frm.state.value;
   city=document.frm.city.value;
     
    http.open('get', 'getSociety.jsp?area=' + st+'&state='+state+'&city='+city);
    http.onreadystatechange = processResponseArea1;
    http.send(null);
}

function processResponseArea1() {
    if(http.readyState == 4){
        var response = http.responseText;
        document.getElementById('society').innerHTML = response;
    }
}
 
</script>

</head>
<body>
<jsp:include page="Top.jsp"></jsp:include>
<% try{ response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setDateHeader("Expires", -1);
if(session.getAttribute("userid")==null)
{
	response.sendRedirect("index.jsp");
}%>
<div class="container jumbotron">
  
   <div class="row">
  <div class="col-md-6"><center><h2>Register Ballot</h2></center>
  <form method="post" name="frm" action="/RegBallot">

  <table>
  <tr>
  <td>Title</td>
  <td>
  <input type="text" name="title" class="form-control" required/>
  </td>
  </tr>
  <tr>
  <td>Voting Date</td>
  <td>
  <%
  String currentDt="";
  Date dt=new Date();
  String mon=String.valueOf(dt.getMonth()+1);
  String mon1=String.valueOf(dt.getMonth()+2);
  String date1=String.valueOf(dt.getDate());
  if(date1.length()==1)
	  date1="0"+date1;
  
  if(mon.length()==1)
	  mon="0"+mon;
  if(mon1.length()==1)
	  mon1="0"+mon1;
  currentDt=(dt.getYear()+1900)+"-"+mon+"-"+(date1);
  String futureDt=(dt.getYear()+1900)+"-"+mon1+"-"+(date1);
   System.out.println("curr="+currentDt+" "+futureDt);
  %>
  <input type="date"  min="<%=currentDt %>" max="<%=futureDt %>" name="dt" class="form-control" required/>
  </td>
  </tr>
  
  <tr>
<td>Branch</td>
<td>
<%
GetData obj1=new GetData();
 obj1.getBranch();
 List<String> lstbr=obj1.getLstbranch();
 %>
  <select required name="cmbbranch" class="form-control" onchange="makeGetRequestBr(this.value)">
<option value=""><--select--></option>
<%for(int i=0;i<lstbr.size();i++)
{%>
<option value="<%=lstbr.get(i).trim() %>"><%=lstbr.get(i).trim() %></option>											
<%}%>
 <option value="NA">NA</option>
 </select>
  </td>
  </tr>
  
  <tr>
<td>College</td>
<td>
 <%
 obj1.getCollege();
  List<String> lstcollege=obj1.getLstcollege();
  %>
 <select required name="cmbcollege" class="form-control" onchange="makeGetRequestColg(this.value)">
 <option value=""><--select--></option>
 <%for(int i=0;i<lstcollege.size();i++)
 {%>
 <option value="<%=lstcollege.get(i).trim() %>"><%=lstcollege.get(i).trim() %></option>											
 <%}%>
 <option value="NA">NA</option>
 </select>
 </td>
 </tr>
 <tr>
<td>Profession</td>
<td>
 <%
 obj1.getProf();
  List<String> lstprof=obj1.getLstprofession();
  %>
 <select required name="cmbprof" class="form-control" onchange="makeGetRequestColg(this.value)">
 <option value=""><--select--></option>
 <%for(int i=0;i<lstprof.size();i++)
 {%>
 <option value="<%=lstprof.get(i).trim() %>"><%=lstprof.get(i).trim() %></option>											
 <%}%>
  <option value="NA">NA</option>
 </select>
 </td>
 </tr>
 <tr><td>Description</td>
 <td><textarea name="ballotDesc" class="form-control" required></textarea>
 <tr>
 <td>Company</td>
 <td>
 <%		
 obj1.getCompany();
  List<String> lstcompany=obj1.getLstcompany();
 %>
 <select required name="cmbcompany" class="form-control" onchange="makeGetRequestComp(this.value)">
  <option value=""><--select--></option>
 <%for(int i=0;i<lstcompany.size();i++)
 {%>
  <option value="<%=lstcompany.get(i).trim() %>"><%=lstcompany.get(i).trim() %></option>											
 <%}%>
 <option value="NA">NA</option>
  </select>
  </td>
 </tr>
 <%
	  GetStateNCities obj=new GetStateNCities();
	  obj.getStates();
	 List<States> lst=obj.getLststate();
	 %>
	 <tr>
	 <td>State
	 </td>
	  <td> 
	 <select required name="state" class="form-control" onchange="makeGetRequest(this.value)">
	 <option value=""><--select--></option>
	 <%for(int i=0;i<lst.size();i++)
	 {%>
	 <option value="<%=lst.get(i).getState() %>"><%=lst.get(i).getState() %></option>											
	 <%}%>	
	 <option value="NA">NA</option>														  
	 </select>
	 </td>
	 </tr>
	 <tr>
	 <td>City
	 </td>
	 <td> 
	 <div id="cities"></div>
	 </td>
	 </tr>
	 <tr>
	 <td colspan="2">
	 <div id="area"></div>
	 </td>
	 </tr>
	 <tr>
	 <td colspan="2">
	 <div id="society"></div>
	 </td>
	 </tr>
	 <tr>
	 <td colspan="2">
	 <input type="hidden" name="userid" value="<%=session.getAttribute("userid").toString().trim() %>"/>
	 <input type="submit" value="Submit"/>
	 </td>
  </table>
  </form></div>
  <div class="col-md-6">
  <img src="images/ballot.jpg" class="img-responsive"/>
  </div>
  </div></div>
  <br/><br/>
<%}
catch(Exception ex)
{
	
}
%>
</body>
</html>