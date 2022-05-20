package models;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
 
 
 

public class Users {
private String name;
private String mobile;
private String email,branch,cmbarea,otherarea,cmbconstituency,otherconst,cmbsociety,otherSociety;
private String eduDetails,state,city,prof,dob,gender,cmbbranch,otherbranch,aadhar;
private String addr,userid,pass,sentOTP,otp,cmbcollege,othercolg,cmbcompany,othercomp;
private List<Users> lstEmp = new ArrayList<Users>();
Connection con;
CallableStatement csmt;
PreparedStatement psmt;
ResultSet rs;




public String getCmbarea() {
	return cmbarea;
}

public void setCmbarea(String cmbarea) {
	this.cmbarea = cmbarea;
}

public String getOtherarea() {
	return otherarea;
}

public void setOtherarea(String otherarea) {
	this.otherarea = otherarea;
}

public String getCmbconstituency() {
	return cmbconstituency;
}

public void setCmbconstituency(String cmbconstituency) {
	this.cmbconstituency = cmbconstituency;
}

public String getOtherconst() {
	return otherconst;
}

public void setOtherconst(String otherconst) {
	this.otherconst = otherconst;
}

public String getCmbsociety() {
	return cmbsociety;
}

public void setCmbsociety(String cmbsociety) {
	this.cmbsociety = cmbsociety;
}

public String getOtherSociety() {
	return otherSociety;
}

public void setOtherSociety(String otherSociety) {
	this.otherSociety = otherSociety;
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

public String getProf() {
	return prof;
}

public void setProf(String prof) {
	this.prof = prof;
}

public String getDob() {
	return dob;
}

public void setDob(String dob) {
	this.dob = dob;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getCmbbranch() {
	return cmbbranch;
}

public void setCmbbranch(String cmbbranch) {
	this.cmbbranch = cmbbranch;
}

public String getOtherbranch() {
	return otherbranch;
}

public void setOtherbranch(String otherbranch) {
	this.otherbranch = otherbranch;
}

public String getAadhar() {
	return aadhar;
}

public void setAadhar(String aadhar) {
	this.aadhar = aadhar;
}

public String getCmbcollege() {
	return cmbcollege;
}

public void setCmbcollege(String cmbcollege) {
	this.cmbcollege = cmbcollege;
}

public String getOthercolg() {
	return othercolg;
}

public void setOthercolg(String othercolg) {
	this.othercolg = othercolg;
}

public String getCmbcompany() {
	return cmbcompany;
}

public void setCmbcompany(String cmbcompany) {
	this.cmbcompany = cmbcompany;
}

public String getOthercomp() {
	return othercomp;
}

public void setOthercomp(String othercomp) {
	this.othercomp = othercomp;
}

public String getSentOTP() {
	return sentOTP;
}

public void setSentOTP(String sentOTP) {
	this.sentOTP = sentOTP;
}

public String getOtp() {
	return otp;
}

public void setOtp(String otp) {
	this.otp = otp;
}

public List<Users> getLstEmp() {
	return lstEmp;
}

public void setLstEmp(List<Users> lstEmp) {
	this.lstEmp = lstEmp;
}

public String getName() {
	return name;
}

public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}

public void setName(String name) {
	this.name = name;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getEduDetails() {
	return eduDetails;
}

public void setEduDetails(String eduDetails) {
	this.eduDetails = eduDetails;
}

 

public String getBranch() {
	return branch;
}

public void setBranch(String branch) {
	this.branch = branch;
}

public String getAddr() {
	return addr;
}

public void setAddr(String addr) {
	this.addr = addr;
}

public String getUserid() {
	return userid;
}

public void setUserid(String userid) {
	this.userid = userid;
}
public Users()
{
	
}
public boolean Registration()
{
    try
    {
    	System.out.println("in registration");
    	Date dt=new Date();
    	String pass; 
    	Random rnd=new Random();
    	pass="Mpovs@"+(rnd.nextInt()+1000)+"az";
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        csmt=con.prepareCall("{call insertUsers(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        csmt.setString(1, userid);
        csmt.setString(2, pass);
        csmt.setString(3, name);
        csmt.setString(4, mobile);
        csmt.setString(5, email);
        csmt.setString(6, eduDetails);
        csmt.setString(7, addr);
        System.out.println("in registration");
        System.out.println("cmbbranch");
        System.out.println(cmbbranch);
        if(cmbbranch.trim().equals("other"))
        {
        	csmt.setString(8,otherbranch);
        	System.out.println("br="+otherbranch);
        }
        else
        	csmt.setString(8, cmbbranch);
        if(cmbcollege.trim().equals("other"))
        {
        	csmt.setString(9,othercolg);
        	System.out.println("colg="+othercolg);
        }
        else
        	csmt.setString(9, cmbcollege);
        if(cmbcompany.trim().equals("other"))
        {
        	csmt.setString(10,othercomp);
        	System.out.println("comp="+othercomp);
        }
        else
        	csmt.setString(10, cmbcompany);
        csmt.setString(11, state);
        csmt.setString(12, city);
        csmt.setString(13, dob);
        int dobYr=0;
        System.out.println("dob="+dob);
        System.out.println("in registration");
       
        dobYr=Integer.parseInt(dob.split("\\-")[2].trim());
        if(dobYr<100)
        {
        	dobYr=Integer.parseInt(dob.split("\\-")[0].trim());
            
        }
        int yr=dt.getYear()+1900;
        csmt.setInt(14, yr-dobYr);
        csmt.setString(15, prof);
        System.out.println("in registration dob");
        
        if(cmbarea.trim().equals("other"))
        {
        	csmt.setString(16,otherarea);
        	System.out.println("in registration dob"+otherarea);
        }
        else
        	csmt.setString(16, cmbarea);
        if(cmbconstituency.trim().equals("other"))
        {
        	csmt.setString(17,otherconst);
        	System.out.println("in registration dob"+otherconst);
        }
        else
        	csmt.setString(17, cmbconstituency);
        if(cmbsociety.trim().equals("other"))
        {
        	csmt.setString(18,otherSociety);
        	System.out.println("in registration dob"+otherSociety);
        }
        else
        	csmt.setString(18, cmbsociety);
        csmt.setString(19, aadhar);
        int n=csmt.executeUpdate();
         
        System.out.println("in registration");
        boolean flag=false;
        if(n>0)
        { 
        	 flag=true;
        }
        if(flag)
        {
        	Mail mobj=new Mail();
        	
        	String msg="Dear "+name+", Your account has been created on Multipupose Online Voting System.\n Your userid is "+userid+" and Password is : "+pass;
        	try{if(mobj.sendMail(msg, email, "Account Details"))
        	{}
        	}
        	catch (Exception e) {
				// TODO: handle exception
			}
            try{con.close();}catch(Exception ex){}
            System.out.println("true");
        	return true;
        }
        else 
        	return false;
         
        } 
     
    catch(Exception ex)
    {
        System.out.println("err="+ex.getMessage());
        return false;
    }
}
public Users(ResultSet rs)
{
	try
	{
	userid=rs.getString("userid").toString().trim();
	name=rs.getString("empName").toString().trim();
	mobile=rs.getString("mobile").toString().trim();
	email=rs.getString("email").toString().trim();
	eduDetails=rs.getString("eduDetails").toString().trim();
	addr=rs.getString("addr").toString().trim();
	}
	catch (Exception e) {
		// TODO: handle exception
	}
}
public boolean useridAuth()
{
	boolean flag=false;
    try
    {
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        csmt=con.prepareCall("{call useridAuth(?)}");
         csmt.setString(1, userid);
         
         csmt.execute();
         rs=csmt.getResultSet();
                     
        while(rs.next())
        { System.out.println("true");
        email=rs.getString("email").trim();
        name=rs.getString("username").trim();
        flag=true;
              
        }
    }
       
     
    catch(Exception ex)
    {
        System.out.println("err="+ex.getMessage());
         
    }
    return flag;
}
public boolean updatePass()
{
    try
    {
    	 
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        csmt=con.prepareCall("{call updatePassword(?,?)}");
        csmt.setString(1, userid);
        csmt.setString(2, pass);
        
         int n=csmt.executeUpdate();
         
                    
        
        if(n>0)
        {
            try{con.close();}catch(Exception ex){}
            System.out.println("true");
            return true;
        }
        else
            return false;

        }
       
     
    catch(Exception ex)
    {
        System.out.println("err="+ex.getMessage());
        return false;
    }
}
public void getEmployee()
{
    try
    {
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        csmt=con.prepareCall("{call getEmployees(?)}"); 
        csmt.setString(1,branch);
         csmt.execute();
         rs=csmt.getResultSet();
                     
        while(rs.next())
        { System.out.println("true");
        lstEmp.add(new Users(rs));
              
        }
    }
       
     
    catch(Exception ex)
    {
        System.out.println("err="+ex.getMessage());
         
    }
}
public void getEmployee1(String userid1)
{
    try
    {
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        csmt=con.prepareCall("{call getEmployees1(?)}"); 
        csmt.setString(1, userid1);
         csmt.execute();
         rs=csmt.getResultSet();
                     
        while(rs.next())
        { System.out.println("true");
        lstEmp.add(new Users(rs));
              
        }
    }
       
     
    catch(Exception ex)
    {
        System.out.println("err="+ex.getMessage());
         
    }
}
public String getEmployeeName(String uid)
{
	String username="";
    try
    {
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        PreparedStatement pst=con.prepareStatement("select username from users where userid=?"); 
        pst.setString(1, uid);
        pst.execute();
         rs=pst.getResultSet();
                     
        while(rs.next())
        {  
        	username=rs.getString("username");
        }
    }
       
     
    catch(Exception ex)
    {
        System.out.println("err inname="+ex.getMessage());
         
    }
    return username;
}
public void getGroupMembers(String groupName)
{
    try
    {
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        csmt=con.prepareCall("{call getGroupMembers(?)}");
        csmt.setString(1, groupName);
         csmt.execute();
         rs=csmt.getResultSet();
                     
        while(rs.next())
        { System.out.println("true");
        Users eobj=new Users();
        eobj.setUserid(rs.getString("userid").toString());
        eobj.setName(rs.getString("empName").toString());
        lstEmp.add(eobj);
              
        }
    }
       
     
    catch(Exception ex)
    {
        System.out.println("err="+ex.getMessage());
         
    }
}
public void getEmployeesNotInGroup(String groupName)
{
    try
    {
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        csmt=con.prepareCall("{call getNotGroupMembers(?)}");
        csmt.setString(1, groupName);
         csmt.execute();
         rs=csmt.getResultSet();
                     
        while(rs.next())
        { System.out.println("true");
        lstEmp.add(new Users(rs));
              
        }
    }
       
     
    catch(Exception ex)
    {
        System.out.println("err="+ex.getMessage());
         
    }
}
}
