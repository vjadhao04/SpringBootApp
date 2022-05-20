<%@page import="models.GetData"%>
<%@page import="models.States"%>
<%@page import="java.util.List"%>
<%@page import="models.GetStateNCities"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Online Voting</title>
   
  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Roboto:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">
 
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
    
    http.open('get', 'Cities?state=' + st);
    http.onreadystatechange = processResponse;
    http.send(null);
}

function processResponse() {
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

function makeGetRequestBr(st) {
   // st=document.frm.state.value;
    
    http.open('get', 'OtherBranch.jsp?branch=' + st);
    http.onreadystatechange = processResponseBr;
    http.send(null);
}

function processResponseBr() {
    if(http.readyState == 4){
        var response = http.responseText;
        document.getElementById('branch').innerHTML = response;
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

function makeGetRequestColg(st) {
   // st=document.frm.state.value;
    
    http.open('get', 'OtherColg.jsp?colg=' + st);
    http.onreadystatechange = processResponseColg;
    http.send(null);
}

function processResponseColg() {
    if(http.readyState == 4){
        var response = http.responseText;
        document.getElementById('colg').innerHTML = response;
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

function makeGetRequestComp(st) {
   // st=document.frm.state.value;
    
    http.open('get', 'OtherComp.jsp?comp=' + st);
    http.onreadystatechange = processResponseComp;
    http.send(null);
}

function processResponseComp() {
    if(http.readyState == 4){
        var response = http.responseText;
        document.getElementById('comp').innerHTML = response;
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

function makeGetRequestArea(st) {
   // st=document.frm.state.value;
    
    http.open('get', 'OtherArea.jsp?area=' + st);
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

function makeGetRequestConst(st) {
   // st=document.frm.state.value;
    
    http.open('get', 'OtherConstituency.jsp?const=' + st);
    http.onreadystatechange = processResponseConst;
    http.send(null);
}

function processResponseConst() {
    if(http.readyState == 4){
        var response = http.responseText;
        document.getElementById('const').innerHTML = response;
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

function makeGetRequestSociety(st) {
   // st=document.frm.state.value;
    
    http.open('get', 'OtherSociety.jsp?society=' + st);
    http.onreadystatechange = processResponseSociety;
    http.send(null);
}

function processResponseSociety() {
    if(http.readyState == 4){
        var response = http.responseText;
        document.getElementById('society1').innerHTML = response;
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

function makeGetRequest1(st) {
   // st=document.frm.state.value;
   
    http.open('get', 'WCities?state=' + st);
    http.onreadystatechange = processResponse1;
    http.send(null);
}

function processResponse1() {
    if(http.readyState == 4){
        var response = http.responseText;
        document.getElementById('wcities').innerHTML = response;
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

function makeGetRequestCity11(st) {
	alert("nn");
    state=document.frm1.state.value;
    alert(state);
    http.open('get', 'area1.jsp?city=' + st+'&state='+state);
    http.onreadystatechange = processResponseArea11;
    http.send(null);
}

function processResponseArea11() {
    if(http.readyState == 4){
        var response = http.responseText;
        document.getElementById('area1').innerHTML = response;
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

function makeGetRequestAreaS1(st) {
   state=document.frm1.state.value;
   city=document.frm1.city.value;
     
    http.open('get', 'getSociety1.jsp?area=' + st+'&state='+state+'&city='+city);
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

  <!-- ======= Top Bar ======= -->
  <div id="topbar" class="d-none d-lg-flex align-items-center fixed-top">
    <div class="container d-flex">
      <div class="contact-info mr-auto">
         </div>
      
    </div>
  </div>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">

      <h1 class="logo mr-auto"><a href="#">Multi-Purpose Online Voting System<span>.</span></a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo mr-auto"><img src="assets/img/logo.png" alt=""></a>-->

      <nav class="nav-menu d-none d-lg-block">
        <ul>
          <li class="active"><a href="home">Home</a></li>
          <li><a href="#testimonials">Login</a></li>
          <li><a href="#services">Registration</a></li>
         <!-- <li><a href="#portfolio">Portfolio</a></li>
          <li><a href="#team">Team</a></li>
          <li class="drop-down"><a href="">Drop Down</a>
            <ul>
              <li><a href="#">Drop Down 1</a></li>
              <li class="drop-down"><a href="#">Deep Drop Down</a>
                <ul>
                  <li><a href="#">Deep Drop Down 1</a></li>
                  <li><a href="#">Deep Drop Down 2</a></li>
                  <li><a href="#">Deep Drop Down 3</a></li>
                  <li><a href="#">Deep Drop Down 4</a></li>
                  <li><a href="#">Deep Drop Down 5</a></li>
                </ul>
              </li>
              <li><a href="#">Drop Down 2</a></li>
              <li><a href="#">Drop Down 3</a></li>
              <li><a href="#">Drop Down 4</a></li>
            </ul>
          </li>
          <li><a href="#contact">Contact</a></li>
 --> 
        </ul>
      </nav><!-- .nav-menu -->

    </div>
  </header><!-- End Header -->

  <!-- ======= Hero Section ======= -->
  <section id="hero" class="d-flex align-items-center">
    <div class="container" data-aos="zoom-out" data-aos-delay="100">
      <h1>Welcome to <span>Multi-Purpose Online Voting System</spa>
      </h1>
    
    </div>
  </section><!-- End Hero -->

  <main id="main">
 
      
    <!-- ======= Services Section ======= -->
    <section id="services" class="services">
      <div class="container" data-aos="fade-up">
<h2>Registration</h2>
          <form method="post" name="frm1" action="/Registration">

        <div class="row">
       
           <div class="col-md-4">
                  
<table class="tblform">
<tr>
<td>User Name</td>
<td>
<input type="text"  name="name" required class="form-control"></input>
</td>
</tr>
<tr>
<td>User Id</td>
<td>
<input type="text"  name="userid" required class="form-control"></input>
</td>
</tr>
<tr>
				<td>Mobile Number</td>
				<td>
				<input type="text" required  class="form-control"  name="mobile" pattern="^\d{10}$"  >
				</td>
			</tr>
			
                <tr><td>Email ID:</td>
                    <td><input type="text" class="form-control" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"  name="email" required></td>
                </tr>
                      
             <tr><td>Education Details</td>
                    <td><textarea  class="form-control"    name="eduDetails" required></textarea></td>
                </tr>
                <tr><td>Address</td>
                    <td><textarea  class="form-control"    name="addr" required></textarea></td>
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
	  <td>Profession
	  </td>
	 <td> 
									 <input required type="text" name="prof" class="form-control"/>
									 </td>
									 </tr>
									 <tr>
<td>DOB</td>
<td>
<input type="date" name="dob" value="" 
        min="1930-01-01" max="2003-12-31" required class="form-control"/>
</td>
</tr>
<tr>
<td>Gender</td>
<td>
<input type="radio" name="gender" value="Male"   checked="true" required >Male</input>
<input type="radio" name="gender" value="Female"  required>Female</input>
</td>
</tr>
  
</table>
   </div>
   <div class="col-md-4">
                  
<table class="tblform">
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
 <option value="other">other</option>
 </select>
 <div id="branch"></div>
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
 <option value="other">other</option>
 </select>
 <div id="colg"></div>
</td>
</tr>
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
				 <option value="other">other</option>
				 </select>
				<div id="comp"></div>
				</td>
			</tr>
			
                
                <tr><td colspan="2"> 
                    <div id="area1"></div>
                    </td>
                </tr>
                  
                 <tr><td>Society</td>
                    <td>
                     
                    <div id="society"></div> <div id="society1"></div>
                </tr>
                <tr><td>Aadhar No</td>
                    <td><input type="text"  class="form-control"    name="aadhar" required></textarea></td>
                </tr>
                  
 <tr>
 <td colspan="2">
 <input type="submit" value="Submit" class="btn btn-primary"/>
 </td>
 </tr>
</table>
   </div> </div>

     
</form>
         </div>

       
    </section><!-- End Services Section -->

    <!-- ======= Testimonials Section ======= -->
    <section id="testimonials" class="testimonials">
      <div class="container" data-aos="zoom-in">

          <div class="row">
                  <div class="col-md-6">
                  <img src="images/lgin.png" width="60%"/>
                  </div><div class="col-md-6">
                   <form name="frm" method="post" action="login">
 <div class="jumbotron"> <h2 class="pb-3"> Login</h2>
<table class="tblform ">
<tr>
<td>UserID
<td><input type="text" class="form-control" required name="txtuserid">
</tr>

<tr>
<td>Password
<td><input type="password"  class="form-control" required name="txtpass">
</tr>

<tr>
<td><input type="submit" class="btn btn-primary" value="Submit"> 
<td>
</tr>
<tr>
<td><a href="forgot" >Password Recovery</a>
<td>
</tr>
</table></div>
</form></div></div>
      </div>
    </section><!-- End Testimonials Section -->
    

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer id="footer">
 
 

    <div class="container py-4">
      <div class="copyright">
        &copy; Copyright <strong><span>Online Voting System</span></strong>. All Rights Reserved
      </div>
      <div class="credits">
        <!-- All the links in the footer should remain intact. -->
        <!-- You can delete the links only if you purchased the pro version. -->
        <!-- Licensing information: https://bootstrapmade.com/license/ -->
        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/bizland-bootstrap-business-template/ -->
      </div>
    </div>
  </footer><!-- End Footer -->

  <div id="preloader"></div>
  <a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/jquery/jquery.min.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/waypoints/jquery.waypoints.min.js"></script>
  <script src="assets/vendor/counterup/counterup.min.js"></script>
  <script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/venobox/venobox.min.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>