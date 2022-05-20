package models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

 

public class GetData {
	Connection con;
    CallableStatement csmt;
    private String state,city,area;
    ResultSet rs;
    
   private List<String> lstbranch = new ArrayList<String>();
   private List<String> lstcollege = new ArrayList<String>();
   private List<String> lstcompany = new ArrayList<String>();
   private List<String> lstparties = new ArrayList<String>();
   private List<String> lstprofession = new ArrayList<String>();
   private List<String> lstarea = new ArrayList<String>();
   private List<String> lstcontituency = new ArrayList<String>();
   private List<String> lstsociety = new ArrayList<String>();
   private List<String> lstdt = new ArrayList<String>();
   private List<String> lstMon = new ArrayList<String>();
   private List<String> lstDOBYr = new ArrayList<String>();
   private List<String> lstelDt = new ArrayList<String>();
   private List<String> lstelMon = new ArrayList<String>();
   private List<String> lstelYr = new ArrayList<String>();
    

	public List<String> getLstparties() {
	return lstparties;
}
public void setLstparties(List<String> lstparties) {
	this.lstparties = lstparties;
}
	public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public List<String> getLstbranch() {
	return lstbranch;
}
public void setLstbranch(List<String> lstbranch) {
	this.lstbranch = lstbranch;
}
public List<String> getLstcollege() {
	return lstcollege;
}
public void setLstcollege(List<String> lstcollege) {
	this.lstcollege = lstcollege;
}
public List<String> getLstcompany() {
	return lstcompany;
}
public void setLstcompany(List<String> lstcompany) {
	this.lstcompany = lstcompany;
}
public List<String> getLstprofession() {
	return lstprofession;
}
public void setLstprofession(List<String> lstprofession) {
	this.lstprofession = lstprofession;
}
public List<String> getLstarea() {
	return lstarea;
}
public void setLstarea(List<String> lstarea) {
	this.lstarea = lstarea;
}
public List<String> getLstcontituency() {
	return lstcontituency;
}
public void setLstcontituency(List<String> lstcontituency) {
	this.lstcontituency = lstcontituency;
}
public List<String> getLstsociety() {
	return lstsociety;
}
public void setLstsociety(List<String> lstsociety) {
	this.lstsociety = lstsociety;
}
public void setArea(String area) {
	this.area = area;
}
	public void getBranch()
	    {
	        try
	        {
	             DBConnector obj=new  DBConnector();
	            con=obj.connect();
	            csmt=con.prepareCall("{call getBranches()}");
	           
	             csmt.execute();
	             rs=csmt.getResultSet();
	                         
	            while(rs.next())
	            { System.out.println("true");
	            lstbranch.add(rs.getString("branch").toString().trim());
	                  
	            }
	        }
	           
	         
	        catch(Exception ex)
	        {
	            System.out.println("err="+ex.getMessage());
	             
	        }
	    }
	public void getCollege()
    {
        try
        {
             DBConnector obj=new  DBConnector();
            con=obj.connect();
            csmt=con.prepareCall("{call getColleges()}");
           
             csmt.execute();
             rs=csmt.getResultSet();
                         
            while(rs.next())
            { System.out.println("true");
            lstcollege.add(rs.getString("college").toString().trim());
                  
            }
        }
           
         
        catch(Exception ex)
        {
            System.out.println("err="+ex.getMessage());
             
        }
    }
	public void getParties()
    {
        try
        {
             DBConnector obj=new  DBConnector();
            con=obj.connect();
            csmt=con.prepareCall("{call getParties()}");
           
             csmt.execute();
             rs=csmt.getResultSet();
                         
            while(rs.next())
            { System.out.println("true");
            lstparties.add(rs.getString("party").toString().trim());
                  
            }
        }
           
         
        catch(Exception ex)
        {
            System.out.println("err="+ex.getMessage());
             
        }
    }
	public void getCompany()
    {
        try
        {
             DBConnector obj=new  DBConnector();
            con=obj.connect();
            csmt=con.prepareCall("{call getCompanies()}");
           
             csmt.execute();
             rs=csmt.getResultSet();
                         
            while(rs.next())
            { System.out.println("true");
            lstcompany.add(rs.getString("company").toString().trim());
                  
            }
        }
           
         
        catch(Exception ex)
        {
            System.out.println("err="+ex.getMessage());
             
        }
    }
	public void getProf()
    {
        try
        {
             DBConnector obj=new  DBConnector();
            con=obj.connect();
            csmt=con.prepareCall("{call getProf()}");
           
             csmt.execute();
             rs=csmt.getResultSet();
                         
            while(rs.next())
            { System.out.println("true");
            lstprofession.add(rs.getString("profession").toString().trim());
                  
            }
        }
           
         
        catch(Exception ex)
        {
            System.out.println("err="+ex.getMessage());
             
        }
    }
	public void getArea()
    {
        try
        {
             DBConnector obj=new  DBConnector();
            con=obj.connect();
            csmt=con.prepareCall("{call getArea(?,?)}");
            csmt.setString(1, state);
            csmt.setString(2, city);
             csmt.execute();
             rs=csmt.getResultSet();
                         
            while(rs.next())
            { System.out.println("true");
            lstarea.add(rs.getString("area").toString().trim());
                  
            }
        }
           
         
        catch(Exception ex)
        {
            System.out.println("err="+ex.getMessage());
             
        }
    }
	public void getConstituency()
    {
        try
        {
             DBConnector obj=new  DBConnector();
            con=obj.connect();
            csmt=con.prepareCall("{call getConstituency(?,?)}");
            csmt.setString(1, state);
            csmt.setString(2, city);
             csmt.execute();
             rs=csmt.getResultSet();
                         
            while(rs.next())
            { System.out.println("true");
            lstcontituency.add(rs.getString("constituency").toString().trim());
                  
            }
        }
           
         
        catch(Exception ex)
        {
            System.out.println("err="+ex.getMessage());
             
        }
    }
	 
	public void getSociety()
    {
        try
        {
             DBConnector obj=new  DBConnector();
            con=obj.connect();
            csmt=con.prepareCall("{call getSocieties(?,?,?)}");
            csmt.setString(1, state);
            csmt.setString(2, city);
            csmt.setString(3, area);
             csmt.execute();
             rs=csmt.getResultSet();
                         
            while(rs.next())
            { System.out.println("true");
            lstsociety.add(rs.getString("society").toString().trim());
                  
            }
        }
           
         
        catch(Exception ex)
        {
            System.out.println("err="+ex.getMessage());
             
        }
    }
	
}
