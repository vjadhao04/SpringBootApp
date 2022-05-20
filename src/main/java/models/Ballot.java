package models;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
 
 
 

public class Ballot {
private int ballotId,votecasted;
private String title;
private String dt;
private String  cmbarea,ballotsts,cmbconstituency,cmbsociety;
private String state,city,cmbprof, cmbbranch;
private String ballotDesc,userid,key1,key2,sentOTP,otp,cmbcollege,cmbcompany;
private List<Ballot> lstBallot = new ArrayList<Ballot>();
Connection con;
CallableStatement csmt;
PreparedStatement psmt;
ResultSet rs;




public int getVotecasted() {
	return votecasted;
}

public void setVotecasted(int votecasted) {
	this.votecasted = votecasted;
}

public int getBallotId() {
	return ballotId;
}

public void setBallotId(int ballotId) {
	this.ballotId = ballotId;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDt() {
	return dt;
}

public void setDt(String dt) {
	this.dt = dt;
}

public String getCmbprof() {
	return cmbprof;
}

public void setCmbprof(String cmbprof) {
	this.cmbprof = cmbprof;
}

public String getBallotDesc() {
	return ballotDesc;
}

public void setBallotDesc(String ballotDesc) {
	this.ballotDesc = ballotDesc;
}

public String getKey1() {
	return key1;
}

public void setKey1(String key1) {
	this.key1 = key1;
}

public String getKey2() {
	return key2;
}

public void setKey2(String key2) {
	this.key2 = key2;
}

public String getCmbarea() {
	return cmbarea;
}

public String getBallotsts() {
	return ballotsts;
}

public void setBallotsts(String ballotsts) {
	this.ballotsts = ballotsts;
}

public void setCmbarea(String cmbarea) {
	this.cmbarea = cmbarea;
}
 
public String getCmbconstituency() {
	return cmbconstituency;
}

public void setCmbconstituency(String cmbconstituency) {
	this.cmbconstituency = cmbconstituency;
}
 
public String getCmbsociety() {
	return cmbsociety;
}

public void setCmbsociety(String cmbsociety) {
	this.cmbsociety = cmbsociety;
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
   
public String getCmbbranch() {
	return cmbbranch;
}

public void setCmbbranch(String cmbbranch) {
	this.cmbbranch = cmbbranch;
}
  

public String getCmbcollege() {
	return cmbcollege;
}

public void setCmbcollege(String cmbcollege) {
	this.cmbcollege = cmbcollege;
}
 

public String getCmbcompany() {
	return cmbcompany;
}

public void setCmbcompany(String cmbcompany) {
	this.cmbcompany = cmbcompany;
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
       
public List<Ballot> getLstBallot() {
	return lstBallot;
}

public void setLstBallot(List<Ballot> lstBallot) {
	this.lstBallot = lstBallot;
}

public String getUserid() {
	return userid;
}

public void setUserid(String userid) {
	this.userid = userid;
}
public Ballot()
{
	
}
public boolean Registration()
{
    try
    {
    	System.out.println("in registration");
    	
    	String pass; 
    	Random rnd=new Random();
    	key1="k1@"+rnd.nextInt(98);
    	key2=rnd.nextInt(99)+"#k2";
    	pass="Exp#"+(rnd.nextInt()+1000);
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        csmt=con.prepareCall("{call insertBallot(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        csmt.setString(1, userid);
        csmt.setString(2, title);
        csmt.setString(3, dt);
        csmt.setString(4, cmbbranch);
        csmt.setString(5, cmbcollege);
        csmt.setString(6, cmbcompany);
        csmt.setString(7, state);
        System.out.println("in registration");
        System.out.println("city");
        System.out.println(cmbprof);
        csmt.setString(8, city);
        if(city.trim().equals("NA"))
        {
        	cmbarea="NA";
        	cmbconstituency="NA";
        	cmbsociety="NA";
        }
        csmt.setString(9, cmbprof);
        csmt.setString(10, cmbarea);
        csmt.setString(11, cmbconstituency);
         csmt.setString(12, cmbsociety);
        csmt.setString(13, key1);
        csmt.setString(14, key2);
        csmt.setString(15, ballotDesc);
        System.out.println("in registration11");
        csmt.execute();
        ResultSet rs=csmt.getResultSet(); 
        System.out.println("in registration ex");
        boolean flag=false;
        while(rs.next())
        { 
        	System.out.println("key="+rs.getString("key1").toString().trim());
        	 flag=true;
        }
        if(flag)
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
public Ballot(ResultSet rs)
{
	try
	{
		ballotId=rs.getInt("ballotId");
	userid=rs.getString("userid").toString().trim();
	title=rs.getString("title").toString().trim();
	dt=rs.getString("vdate").toString().trim();
	cmbbranch=rs.getString("branch").toString().trim();
	cmbcollege=rs.getString("college").toString().trim();
	cmbcompany=rs.getString("company").toString().trim();
	city=rs.getString("city").toString().trim();
	state=rs.getString("state").toString().trim();
	cmbprof=rs.getString("profession").toString().trim();
	cmbarea=rs.getString("area").toString().trim();
	cmbconstituency=rs.getString("constituency").toString().trim();
	cmbsociety=rs.getString("society").toString().trim();
	try
	{
		votecasted=rs.getInt("votecasted");
		System.out.println("vote="+votecasted);
	}
	catch (Exception e) {
		// TODO: handle exception
		System.out.println("err="+e.getMessage());
	}
	try
	{
		ballotsts=rs.getString("ballotsts");
		System.out.println("ballotsts="+ballotsts);
	}
	catch (Exception e1) {
		// TODO: handle exception
		System.out.println("err1="+e1.getMessage());
	}
	ballotDesc=rs.getString("ballotdesc").toString().trim();
	userid=rs.getString("userid").toString().trim();
	key1=rs.getString("key1").toString().trim();
	key2=rs.getString("key2").toString().trim();
	
	}
	catch (Exception e) {
		// TODO: handle exception
		System.out.println("err in const="+e.getMessage());
	}
}
public void getBallotDetails(String userid1)
{
    try
    {
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        csmt=con.prepareCall("{call getBallots(?)}"); 
        csmt.setString(1, userid1);
         csmt.execute();
         rs=csmt.getResultSet();
            lstBallot=new ArrayList<Ballot>();         
        while(rs.next())
        { System.out.println("true");
        lstBallot.add(new Ballot(rs));
              
        }
    }
       
     
    catch(Exception ex)
    {
        System.out.println("err="+ex.getMessage());
         
    }
}
public void getBallotDetailsScheduled(String userid1)
{
    try
    {
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        csmt=con.prepareCall("{call getMatchingElections1(?)}"); 
        csmt.setString(1, userid1);
         csmt.execute();
         rs=csmt.getResultSet();
            lstBallot=new ArrayList<Ballot>();         
        while(rs.next())
        { System.out.println("true");
        lstBallot.add(new Ballot(rs));
              
        }
    }
       
     
    catch(Exception ex)
    {
        System.out.println("err="+ex.getMessage());
         
    }
}
public void getBallotDetailsScheduledToday(String userid1)
{
    try
    {
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        Date d=new Date();
        String mon=String.valueOf(d.getMonth()+1);
        if(mon.length()==1)
        	mon="0"+mon;
        String date=String.valueOf(d.getDate());
        if(date.length()==1)
        	date="0"+date;
        dt=(d.getYear()+1900)+"-"+mon+"-"+date;
        csmt=con.prepareCall("{call getMatchingElections(?,?)}"); 
        csmt.setString(1, userid1);
        csmt.setString(2, dt);
         csmt.execute();
         rs=csmt.getResultSet();
            lstBallot=new ArrayList<Ballot>();         
        while(rs.next())
        { System.out.println("true");
        lstBallot.add(new Ballot(rs));
              
        }
        System.out.println("lst="+lstBallot.size());
    }
       
     
    catch(Exception ex)
    {
        System.out.println("err="+ex.getMessage());
         
    }
}
}
