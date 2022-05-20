
 
<%@page import="models.DBConnector"%>
<%@page import="services.JavaFuns"%>
<%@page import="java.util.Vector"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.Connection"%>
 
<%@page import="java.util.List"%>
 
 <%@ page import="org.jfree.data.jdbc.JDBCCategoryDataset" %>
<%@ page import="org.jfree.chart.plot.PlotOrientation" %>
<%@ page import="org.jfree.chart.JFreeChart" %>
<%@ page import="org.jfree.chart.ChartUtilities" %>
<%@ page import="org.jfree.chart.ChartFactory" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css"/>
      
    </head>
    <body>
        
        <div class="main">
           
                 
                    <%
                        JavaFuns  cf=new JavaFuns();
                     
               DBConnector obj1=new DBConnector();
                Connection con =obj1.connect()  ; 
 String query ="select candidateName, (select count(*) from getVotes v where v.cid=g.cid and v.ballotId=g.ballotId)  voteCount from getcandidatedetails g  where g.ballotId="+request.getParameter("ballotId").trim()+" order by voteCount desc;";
 JDBCCategoryDataset dataset = new JDBCCategoryDataset(con);
dataset.executeQuery(query);

JFreeChart chart = ChartFactory.createBarChart("Voting Result" , "Candidates", "Votes",dataset, PlotOrientation.HORIZONTAL, true, true,false);

try 
{ 
    File image = new File(getServletContext().getRealPath("/")+"images/Revenue13.png"); 
    ChartUtilities.saveChartAsPNG(image, chart, 750, 350); 
} 
catch (java.io.IOException exc) 
{ 
    out.print(exc.toString());
    System.err.println("Erroring image to file"); 
}

            %>
             <div id="content">
        <IMG SRC="images/Revenue13.png" WIDTH="600" HEIGHT="380" BORDER="0" USEMAP="#chart" /><br/>
        <br/>
      
        </div>
         </div>
            </div></div>
    </body>
</html>
