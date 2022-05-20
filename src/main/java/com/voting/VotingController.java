 package com.voting;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
 
import models.Ballot;
import models.Candidates;
import models.CastVote;
import models.Login;
import models.Mail;
import models.Pass;
import models.Users;
import services.JavaFuns;
import services.RandomString;

@Controller
public class VotingController implements ErrorController {
	@RequestMapping("/error")
    public String handleError() {
        //do something like logging
		return "home";
    }
 
    @Override
    public String getErrorPath() {
        return "/error";
    }
    @RequestMapping("/castVote")
	public String castVote(CastVote cast,HttpSession ses)
	{
    	cast.setUserid(ses.getAttribute("userid").toString().trim());
    	if(cast.Registration())
    	{
    		
    	}
    	System.out.println("vote="+cast.getCid());
		return "Success.jsp?type=VoteCasted";
	}	
    @RequestMapping("/Cities")
	public String cities()
	{
		return "Cities.jsp";
	}	 
	@RequestMapping("/home")
	public String myspring()
	{
		return "index.jsp";
	}
	@RequestMapping("/branchHome")
	public String branchHome()
	{
		return "branch.jsp";
	}
	 
	@RequestMapping("/forgot")
	public String forgot()
	{
		return "Forgot.jsp";
	}
	@RequestMapping("/ChangePass")
	public String ChangePass()
	{
		return "ChangePass.jsp";
	}
	@RequestMapping("/OTPAuth")
	public ModelAndView OTPAuth(Users user,HttpSession ses)
	{
		ModelAndView mv=new ModelAndView();
		try {
			if(user.getSentOTP().equals(user.getOtp()))
			{
				 
				
			    mv.setViewName(ses.getAttribute("utype").toString().trim()+"Home");
			    
			    
			}
			else
			{
				mv.setViewName("Failure.jsp?type=Auth");
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	    return mv;
	}
	@RequestMapping("/KeyAuth")
	public ModelAndView KeyAuth(Users user,HttpSession ses,HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		try {
			if(user.getSentOTP().equals(user.getOtp()))
			{ 
			    mv.setViewName("voting?ballotId="+request.getParameter("ballotId").trim());
			     
			}
			else
			{
				mv.setViewName("Failure.jsp?type=Auth");
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	    return mv;
	}
	@RequestMapping("/passRecoveryOTPAuth")
	public ModelAndView passRecoveryOTPAuth(Users user)
	{
		ModelAndView mv=new ModelAndView();
		try {
			if(user.getSentOTP().equals(user.getOtp()))
			{
				String pass=RandomString.getAlphaNumericString(8);
				user.setPass(pass);
				if(user.updatePass())
				{
					
				}
				
				
			    mv.setViewName("Success.jsp?type=passEmail");
			    
			    Mail mail=new Mail();
			    String msg="Dear "+user.getName()+" \n Your password has been reset to : "+pass;
			    System.out.println("pass="+pass);
			    try
			    {
			    	if(mail.sendMail(msg,user.getEmail(), "New password"))
			    	{
			    		
			    	}
			    }
			    catch (Exception e) {
					// TODO: handle exception
				}
			}
			else
			{
				mv.setViewName("Failure.jsp?type=passEmail");
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	    return mv;
	}
	@RequestMapping("/passRecovery")
	public ModelAndView passRecovery(Users user)
	{
		ModelAndView mv=new ModelAndView();
		try {
			if(user.useridAuth())
			{
				String otp=RandomString.getAlphaNumericString(4);
				
			    mv.setViewName("ForgotOTP.jsp");
			    mv.addObject("userid",user.getUserid());
			    mv.addObject("otp",otp);
			    mv.addObject("email",user.getEmail());
			    Mail mail=new Mail();
			    String msg="Dear "+user.getName()+" \n Your one time password is : "+otp;
			    System.out.println("otp="+otp);
			    try
			    {
			    	if(mail.sendMail(msg,user.getEmail(), "One Time Password"))
			    	{
			    		
			    	}
			    }
			    catch (Exception e) {
					// TODO: handle exception
				}
			}
			else
			{
				mv.setViewName("Failure.jsp?type=Auth");
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	    return mv;
	}
	 
	@RequestMapping("/ChangePassService")
	public String ChangePassService(Pass eobj,HttpSession ses)
	{
		 
		 try
		 {
			 
			 eobj.setUserid(ses.getAttribute("userid").toString().trim());
			 if(eobj.changePassword())
			 {
				 
				 
				 return "Success.jsp?type=ChangePass";
			 }
			 else
			 { 
				 return "Failure.jsp?type=ChangePass";
			 }
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 System.out.println("err="+e.getMessage());
			 return("Failure.jsp?type=Auth");
		}
		 
	}
	 

	@RequestMapping("/adminHome")
	public String adminHome()
	{
		return "admin.jsp";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
        session.invalidate();
		return "Logout.jsp";
	}
	@RequestMapping("userHome")
	public String userHome()
	{
		return "user.jsp";
	}
	@SessionScope
	@RequestMapping("/CandidateReg")
	public String CandidateReg(Candidates eobj,ServletRequest request,HttpSession ses)
	{
		 
		 try
		 {
			 MultipartFile file=eobj.getFile();
			 MultipartFile file1=eobj.getFile1();
		 String filepath=request.getServletContext().getRealPath("/")+"/Uploads/";
		  
		 System.out.println("path="+filepath);
		 File f=new File(filepath);
		 f.mkdir();
		 
		 try {
			 eobj.getId();
			 int mx=eobj.getCid();
			 String fileName="Logo"+mx+"."+ file.getOriginalFilename().split("\\.")[1];
			 file.transferTo(new File(filepath+"/"+fileName));
			 String fileName1="Photo"+mx+"."+ file1.getOriginalFilename().split("\\.")[1];
			 file1.transferTo(new File(filepath+"/"+fileName1));
			 eobj.setPhoto(fileName1); 
			  eobj.setLogo(fileName);
			 eobj.setUserid(ses.getAttribute("userid").toString().trim());
			 if(eobj.Registration() )
			 { 
				 return "Success.jsp?type=CandReg";
			 }
			 else
			 { 
				 return "Failure.jsp?type=CandReg";
			 }
			 } catch (IOException e) {
				 
			 }
		 System.out.println("title"+eobj.getName());
			/* if(eobj.cityAdminRegistration() )
			 {
				 
				 return "Success.jsp?type=Exp";
			 }
			 else
			 { 
				 return "Failure.jsp?type=Exp";
			 }*/
			  return "Success.jsp?type=Doc";
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 System.out.println("err="+e.getMessage());
			 return("Failure.jsp?type=Exp");
		}
		 
	}
	@RequestMapping("RegisterCandidate")
	public ModelAndView RegisterCandidate(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("RegCandidates.jsp");
		mv.addObject("ballotId",request.getParameter("ballotId").trim());
		return mv;
	}
	@RequestMapping("viewCandidate")
	public ModelAndView viewCandidate(HttpSession ses,HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		try 
		{
			
			Candidates ballot=new Candidates();
			ballot.setBallotId(Integer.parseInt(request.getParameter("ballotId").toString().trim()));
			ballot.getCandidatesDetails();
			List<Candidates> lstbal=ballot.getLstBallot();
			mv.addObject("lst",lstbal);
			mv.setViewName("viewCandidate.jsp");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("err in viewbal="+e.getMessage());
		}
		return mv;
	}
	@RequestMapping("viewCandidateAdmin")
	public ModelAndView viewCandidateAdmin(HttpSession ses,HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		try 
		{
			
			Candidates ballot=new Candidates();
			ballot.setBallotId(Integer.parseInt(request.getParameter("ballotId").toString().trim()));
			ballot.getCandidatesDetails();
			List<Candidates> lstbal=ballot.getLstBallot();
			mv.addObject("lst",lstbal);
			mv.setViewName("viewCandidateAdmin.jsp");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("err in viewbal="+e.getMessage());
		}
		return mv;
	}
	@RequestMapping("votingAuth")
	public ModelAndView votingAuth(HttpSession ses,HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		try 
		{
			String key="";
			int ballotId=0;
			ballotId=Integer.parseInt(request.getParameter("ballotId").trim());
			JavaFuns jf=new JavaFuns();
			String qr="select case when userid='"+ses.getAttribute("userid").toString().trim()+"' then concat('"+ses.getAttribute("userid").toString().trim()+"','*',key1) else concat('"+ses.getAttribute("userid").toString().trim()+"','*',key2) end as k  from getballotdetails where ballotId="+ballotId;
			Vector v=jf.getValue(qr, 1);
			key=v.elementAt(0).toString().trim();
			mv.setViewName("VotingAuth.jsp");
		    mv.addObject("userid",ses.getAttribute("userid").toString().trim());
		    mv.addObject("otp",key);
		    mv.addObject("email",ses.getAttribute("email").toString().trim());
		    Mail mail=new Mail();
		    String msg="Dear "+ses.getAttribute("username").toString().trim()+" \n Your Secrete Key for voting is : "+key;
		    System.out.println("otp="+key);
		    try
		    {
		    	if(mail.sendMail(msg,ses.getAttribute("email").toString().trim(), "Secrete Key"))
		    	{
		    		
		    	}
		    }
		    catch (Exception e) {
				// TODO: handle exception
			}
		 
			mv.addObject("ballotId",Integer.parseInt(request.getParameter("ballotId").toString().trim()));
			//mv.addObject("ballotId",Integer.parseInt(request.getParameter("ballotId").toString().trim()));
			 
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("err in viewbal="+e.getMessage());
		}
		return mv;
	}
	@RequestMapping("voting")
	public ModelAndView voting(HttpSession ses,HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		try 
		{
			
			Candidates ballot=new Candidates();
			ballot.setBallotId(Integer.parseInt(request.getParameter("ballotId").toString().trim()));
			ballot.getCandidatesDetails();
			List<Candidates> lstbal=ballot.getLstBallot();
			mv.addObject("lst",lstbal);
			mv.addObject("ballotId",Integer.parseInt(request.getParameter("ballotId").toString().trim()));
			//mv.addObject("ballotId",Integer.parseInt(request.getParameter("ballotId").toString().trim()));
			mv.setViewName("voting.jsp");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("err in viewbal="+e.getMessage());
		}
		return mv;
	}
	@RequestMapping("DeleteCandidate")
	public ModelAndView DeleteCandidate(HttpSession ses,HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		try 
		{
			JavaFuns jf=new JavaFuns();
			if(jf.execute("delete from candidates where cid="+request.getParameter("cid").trim()))
			{}
			Candidates ballot=new Candidates();
			ballot.setBallotId(Integer.parseInt(request.getParameter("ballotId").toString().trim()));
			ballot.getCandidatesDetails();
			List<Candidates> lstbal=ballot.getLstBallot();
			mv.addObject("lst",lstbal);
			mv.setViewName("viewCandidate.jsp");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("err in viewbal="+e.getMessage());
		}
		return mv;
	}
	@RequestMapping("viewMatchingBallot")
	public ModelAndView viewMatchingBallot(HttpSession ses)
	{
		ModelAndView mv=new ModelAndView();
		try 
		{
			
			Ballot ballot=new Ballot();
			ballot.getBallotDetailsScheduled(ses.getAttribute("userid").toString().trim());
			List<Ballot> lstbal=ballot.getLstBallot();
			mv.addObject("lst",lstbal);
			mv.setViewName("viewBallotScheduled.jsp");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("err in viewbal="+e.getMessage());
		}
		return mv;
	}
	@RequestMapping("VoteResult")
	public ModelAndView VoteResult(HttpSession ses,HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		try 
		{
			
			CastVote ballot=new CastVote();
			ballot.setBallotId(Integer.parseInt(request.getParameter("ballotId").trim()));
			ballot.getVotingDetails();
			List<CastVote> lstbal=ballot.getLstBallot();
			mv.addObject("lst",lstbal); 
			mv.setViewName("VotingResult.jsp");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("err in viewbal="+e.getMessage());
		}
		return mv;
	}
	@RequestMapping("viewMatchingBallot1")
	public ModelAndView viewMatchingBallot1(HttpSession ses)
	{
		ModelAndView mv=new ModelAndView();
		try 
		{
			
			Ballot ballot=new Ballot();
			ballot.getBallotDetailsScheduledToday(ses.getAttribute("userid").toString().trim());
			List<Ballot> lstbal=ballot.getLstBallot();
			mv.addObject("lst",lstbal); 
			mv.setViewName("viewBallotScheduled1.jsp");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("err in viewbal="+e.getMessage());
		}
		return mv;
	}
	@RequestMapping("viewBallot")
	public ModelAndView viewBallot(HttpSession ses)
	{
		ModelAndView mv=new ModelAndView();
		try 
		{
			
			Ballot ballot=new Ballot();
			ballot.getBallotDetails(ses.getAttribute("userid").toString().trim());
			List<Ballot> lstbal=ballot.getLstBallot();
			mv.addObject("lst",lstbal);
			mv.setViewName("viewBallot.jsp");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("err in viewbal="+e.getMessage());
		}
		return mv;
	}
	@RequestMapping("viewUsers")
	public ModelAndView viewUsers(HttpSession ses)
	{
		List<Users> lst = new ArrayList<Users>();
		Users obj=new Users();
		obj.setBranch(ses.getAttribute("userid").toString().trim());
		 obj.getEmployee();
		 lst=obj.getLstEmp();
		 
		ModelAndView mv = new ModelAndView();

		mv.setViewName("viewEmployees.jsp");
		mv.addObject("lst", lst);

		return mv;
	}
	 
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request)
	{
		Login obj=new Login();
		ModelAndView mv=new ModelAndView();
		 try
		 {
			 javax.servlet.http.HttpSession ses=request.getSession(true);
			 
			 if(obj.chkAuthentication(request.getParameter("txtuserid").trim(), request.getParameter("txtpass").trim()))
			 {
				 ses.setAttribute("userid", obj.getUserid());
				 System.out.println("userid="+obj.getUserid());
				 System.out.println("userid="+obj.getuType());
				 System.out.println("userid="+obj.getUserName());
				 ses.setAttribute("utype", obj.getuType());
				 ses.setAttribute("username", obj.getUserName());
				 ses.setAttribute("email", obj.getEmail());
				 String otp=RandomString.getAlphaNumericString(4);
					
				    mv.setViewName("OTPAuth.jsp");
				    mv.addObject("userid",obj.getUserid());
				    mv.addObject("otp",otp);
				    mv.addObject("email",obj.getEmail());
				    Mail mail=new Mail();
				    String msg="Dear "+obj.getUserName()+" \n Your one time password is : "+otp;
				    System.out.println("otp="+otp);
				    try
				    {
				    	if(mail.sendMail(msg,obj.getEmail(), "One Time Password : "))
				    	{
				    		
				    	}
				    }
				    catch (Exception e) {
						// TODO: handle exception
					}
				 
				  
			 }
			 else
			 { 
				 mv.setViewName("Failure.jsp?type=Auth");
			 }
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 System.out.println("err="+e.getMessage());
			 mv.setViewName("Failure.jsp?type=Auth");
		}
		 return mv;
		 
	}
	@RequestMapping("/RegUser")
	public String ExpertReg()
	{
		return "RegUser.jsp";
	}
	@RequestMapping("/RegBallot")
	public String RegBallot(Ballot eobj,HttpSession ses)
	{ 
		 try
		 { 
			  
			 if(eobj.Registration())
			 { 
				 return "Success.jsp?type=BallotReg";
			 }
			 else
			 { 
				 return "Failure.jsp?type=BallotReg";
			 }
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 System.out.println("err="+e.getMessage());
			 return("Failure.jsp?type=Emp");
		}
		 
	}
	@RequestMapping("/Registration")
	public String Registration(Users eobj,HttpSession ses)
	{ 
		 try
		 { 
			  
			 if(eobj.Registration())
			 { 
				 return "Success.jsp?type=UserReg";
			 }
			 else
			 { 
				 return "Failure.jsp?type=UserReg";
			 }
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 System.out.println("err="+e.getMessage());
			 return("Failure.jsp?type=Emp");
		}
		 
	}
}

