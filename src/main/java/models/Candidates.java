package models;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.web.multipart.MultipartFile;

  

public class Candidates {
private int ballotId,cid;
private String name,party,key1,photo,key2,logo,mobile,dob,addr,eduDetails,prof,gender,userid;
 
private MultipartFile file,file1;
private List<Candidates> lstBallot = new ArrayList<Candidates>();
Connection con;
CallableStatement csmt;
PreparedStatement psmt;
ResultSet rs;




public int getCid() {
	return cid;
}

public void setCid(int cid) {
	this.cid = cid;
}

public String getPhoto() {
	return photo;
}

public void setPhoto(String photo) {
	this.photo = photo;
}

public MultipartFile getFile1() {
	return file1;
}

public void setFile1(MultipartFile file1) {
	this.file1 = file1;
}

public int getBallotId() {
	return ballotId;
}

public void setBallotId(int ballotId) {
	this.ballotId = ballotId;
}
 
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getParty() {
	return party;
}

public void setParty(String party) {
	this.party = party;
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

public String getLogo() {
	return logo;
}

public void setLogo(String logo) {
	this.logo = logo;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getDob() {
	return dob;
}

public void setDob(String dob) {
	this.dob = dob;
}

public String getAddr() {
	return addr;
}

public void setAddr(String addr) {
	this.addr = addr;
}

public String getEduDetails() {
	return eduDetails;
}

public void setEduDetails(String eduDetails) {
	this.eduDetails = eduDetails;
}

public String getProf() {
	return prof;
}

public void setProf(String prof) {
	this.prof = prof;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getUserid() {
	return userid;
}

public void setUserid(String userid) {
	this.userid = userid;
}

public MultipartFile getFile() {
	return file;
}

public void setFile(MultipartFile file) {
	this.file = file;
}

public List<Candidates> getLstBallot() {
	return lstBallot;
}

public void setLstBallot(List<Candidates> lstBallot) {
	this.lstBallot = lstBallot;
}

public Candidates()
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
        csmt=con.prepareCall("{call insertCandidates(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        csmt.setString(1, userid);
        csmt.setString(2, name);
        csmt.setString(3, party);
        csmt.setString(4, logo);
        csmt.setString(5, mobile);
        csmt.setString(6, dob);
        csmt.setString(7, addr);
        System.out.println("in registration");
        System.out.println("city");
        System.out.println(eduDetails);
        csmt.setString(8, eduDetails);
        csmt.setString(9, prof);
        csmt.setString(10, gender); 
        csmt.setInt(11, ballotId);
        csmt.setString(12, key1); 
        csmt.setString(13, key2); 
        csmt.setString(14, photo);
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
public void getId()
{
    try
    {
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        csmt=con.prepareCall("{call getMaxIdCandidate()}");
       
         csmt.execute();
         rs=csmt.getResultSet();
                    
        boolean auth=false;
        while(rs.next())
        { System.out.println("true");
            auth=true;
            
            cid=rs.getInt("mxid");
              
        }
    }
       
     
    catch(Exception ex)
    {
        System.out.println("err="+ex.getMessage());
         
    }
}
public Candidates(ResultSet rs)
{
	try
	{
		cid=rs.getInt("cid");
		ballotId=rs.getInt("ballotId");
	userid=rs.getString("userid").toString().trim();
	name=rs.getString("candidateName").toString().trim();
	party=rs.getString("party").toString().trim();
	logo=rs.getString("logo").toString().trim();
	photo=rs.getString("photo").toString().trim();
	mobile=rs.getString("mobile").toString().trim();
	dob=rs.getString("dob").toString().trim();
	addr=rs.getString("addr").toString().trim();
	eduDetails=rs.getString("eduDetails").toString().trim();
	prof=rs.getString("profession").toString().trim();
	gender=rs.getString("gender").toString().trim();
	ballotId=rs.getInt("ballotId") ;
	 userid=rs.getString("userid").toString().trim();
	key1=rs.getString("key1").toString().trim();
	key2=rs.getString("key2").toString().trim();
	}
	catch (Exception e) {
		// TODO: handle exception
		System.out.println("err in const="+e.getMessage());
	}
}
public void getCandidatesDetails()
{
    try
    {
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        csmt=con.prepareCall("{call getCandidates(?)}"); 
        csmt.setInt(1, ballotId);
         csmt.execute();
         rs=csmt.getResultSet();
            lstBallot=new ArrayList<Candidates>();         
        while(rs.next())
        { System.out.println("true");
        lstBallot.add(new Candidates(rs));
              
        }
    }
       
     
    catch(Exception ex)
    {
        System.out.println("err="+ex.getMessage());
         
    }
}
}
