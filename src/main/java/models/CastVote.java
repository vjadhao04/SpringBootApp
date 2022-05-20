package models;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import org.springframework.web.multipart.MultipartFile;

import services.JavaFuns;

  

public class CastVote {
private int ballotId,cid,voteCount;
private String userid,key1,photo,key2,name,party,logo;
  
private List<CastVote> lstBallot = new ArrayList<CastVote>();
Connection con;
CallableStatement csmt;
PreparedStatement psmt;
ResultSet rs;


 
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
public String getLogo() {
	return logo;
}
public void setLogo(String logo) {
	this.logo = logo;
}
public int getBallotId() {
	return ballotId;
}
public void setBallotId(int ballotId) {
	this.ballotId = ballotId;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getKey1() {
	return key1;
}
public void setKey1(String key1) {
	this.key1 = key1;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
public String getKey2() {
	return key2;
}
public void setKey2(String key2) {
	this.key2 = key2;
}
public List<CastVote> getLstBallot() {
	return lstBallot;
}
public void setLstBallot(List<CastVote> lstBallot) {
	this.lstBallot = lstBallot;
}
public CastVote()
{
	
}
public boolean Registration()
{
    try
    {
    	System.out.println("in registration");
    	Date dt=new Date();
    	String d=(dt.getDate())+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900);
    	String pass; 
    	Random rnd=new Random();
    	key1="k1@"+rnd.nextInt(98);
    	key2=rnd.nextInt(99)+"#k2";
    	 
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        csmt=con.prepareCall("{call insertVote(?,?,?,?,?,?,?,?,?,?)}");
        csmt.setString(1, userid);
        csmt.setInt(2, cid);
        JavaFuns jf=new JavaFuns();
        Vector v=jf.getValue("select candidateName,party,logo,photo from getcandidatedetails where cid="+cid , 4);
        csmt.setInt(3, ballotId);
        csmt.setString(4, d);
        csmt.setString(5, v.elementAt(0).toString().trim());
        csmt.setString(6, v.elementAt(1).toString().trim());
        csmt.setString(7, v.elementAt(2).toString().trim());
        csmt.setString(8, v.elementAt(3).toString().trim());
        csmt.setString(9, key1);
        csmt.setString(10, key2);
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
public CastVote(ResultSet rs)
{
	try
	{
		cid=rs.getInt("cid");
		ballotId=rs.getInt("ballotId");
	//userid=rs.getString("userid").toString().trim();
	name=rs.getString("candidateName").toString().trim();
	party=rs.getString("party").toString().trim();
	logo=rs.getString("logo").toString().trim();
	photo=rs.getString("photo").toString().trim();
	 
	ballotId=rs.getInt("ballotId") ;
	// userid=rs.getString("userid").toString().trim();
	//key1=rs.getString("key1").toString().trim();
	//key2=rs.getString("key2").toString().trim();
	voteCount=rs.getInt("voteCount") ;
	}
	catch (Exception e) {
		// TODO: handle exception
		System.out.println("err in const="+e.getMessage());
	}
}
public void getVotingDetails()
{
    try
    {
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        csmt=con.prepareCall("{call getVotingResult(?)}"); 
        csmt.setInt(1, ballotId);
         csmt.execute();
         rs=csmt.getResultSet();
            lstBallot=new ArrayList<CastVote>();         
        while(rs.next())
        { System.out.println("true");
        lstBallot.add(new CastVote(rs));
              
        }
    }
       
     
    catch(Exception ex)
    {
        System.out.println("err="+ex.getMessage());
         
    }
}
public int getVoteCount() {
	return voteCount;
}
public void setVoteCount(int voteCount) {
	this.voteCount = voteCount;
}
}
