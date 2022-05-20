<%@page import="java.util.Vector"%>
<%@page import="services.JavaFuns"%>
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
}
JavaFuns jf=new JavaFuns();
Vector v=jf.getValue("select title from getBallotDetails where ballotId="+request.getAttribute("ballotId").toString().trim(), 1);

%>
<div class="container jumbotron">
  
   <div class="row">
  <div class="col-md-6"><center><h2>Register Candidate</h2></center>
  <form method="post" name="frm" action="/CandidateReg"  enctype="multipart/form-data">

  <table>
  <tr>
  <td>Name</td>
  <td>
  <input type="text" name="name" class="form-control" required/>
  </td>
  </tr>
  <tr>
  <td>Ballot Title</td>
  <td>
  <input type="text" readonly="readonly" name="ballotTitle" value=<%=v.elementAt(0).toString().trim() %> class="form-control" required/>
  </td>
  </tr>
  
  <tr>
<td>Party</td>
<td>
<%
GetData obj1=new GetData();
 obj1.getParties() ;
 List<String> lstbr=obj1.getLstparties();
 %>
  <select required name="party" class="form-control" onchange="makeGetRequestBr(this.value)">
<option value=""><--select--></option>
<%for(int i=0;i<lstbr.size();i++)
{%>
<option value="<%=lstbr.get(i).trim() %>"><%=lstbr.get(i).trim() %></option>											
<%}%>
 <option value="Independent Candidate">Independent Candidate</option>
 </select>
  </td>
  </tr>
  <tr>
				<td>Mobile Number</td>
				<td>
				<input type="text" required  class="form-control"  name="mobile" pattern="^\d{10}$"  >
				</td>
			</tr>
			<tr>
<td>Profession</td>
<td>
  <input type="text" name="prof" class="form-control"/>
 </td>
 </tr>
  <tr>
<td>DOB</td>
<td>
  <input type="date" min="1930-01-01" max="2003-12-31" name="dob" class="form-control"/>
 </td>
 </tr>
 <tr><td>Address</td>
 <td><textarea name="addr" class="form-control" required></textarea>
 </td>
 </tr>
 <tr><td>Education Details</td>
 <td><textarea name="eduDetails" class="form-control" required></textarea>
 </td>
 </tr>
  <tr>
<td>Gender</td>
<td>
<input type="radio" name="gender" value="Male"   checked="true" required >Male</input>
<input type="radio" name="gender" value="Female"  required>Female</input>
</td>
</tr>
<tr><td>Logo</td>
 <td><input type="file" name="file" class="form-control" required/>
 </td>
 </tr>
 <tr><td>photo</td>
 <td><input type="file" name="file1" class="form-control" required/>
 </td>
 </tr>
	 <tr>
	 <td colspan="2">
	 <input type="hidden" name="userid" value="<%=session.getAttribute("userid").toString().trim() %>"/>
	 <input type="hidden" name="ballotId" value="<%=request.getAttribute("ballotId").toString().trim() %>"/>
	 <input type="submit" value="Submit"/>
	 </td>
  </table>
  </form></div>
  <div class="col-md-6">
  <img src="images/candidate.jpg" width="100%" class="img-responsive"/>
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