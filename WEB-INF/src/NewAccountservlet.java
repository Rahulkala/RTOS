
package com.rtos.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import com.rtos.db.*;
import com.rtos.*;
import com.rtos.dao.*;

public class NewAccountservlet extends HttpServlet{

	Auth newauth; 
	int i;
	public void init(){
	
		this.newauth=new Auth((UserDAO)getServletContext().getAttribute("user"));
	}
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
	
		doPost(req,resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
	
		String name=req.getParameter("name");
		String dd=req.getParameter("dd");
		String mm=req.getParameter("mm");
		String yy=req.getParameter("yy");
		String dob=yy+"-"+mm+"-"+dd;
		String email=req.getParameter("email");
		String address=req.getParameter("resi_address")+" "+req.getParameter("location")+" "+req.getParameter("state");
		String phone=req.getParameter("phone");
		String pwd=req.getParameter("pwd");
		String conf_pwd=req.getParameter("conf_pwd");
		String que=req.getParameter("question");
		String ans=req.getParameter("ans");
		String status="c";
		if(name==""){
		
			String error="NAME Field Empty";
			req.setAttribute("error",error);
			getServletContext().getRequestDispatcher("/reg.jsp").forward(req,resp);
			return;
		}
		else if(dob==""){
		
			String error="DATE OF BIRTH Field Empty";
			req.setAttribute("error",error);
			getServletContext().getRequestDispatcher("/reg.jsp").forward(req,resp);
			return;
		}
		else if(email==""){
		
			String error="E-MAIL Field Empty";
			req.setAttribute("error",error);
			getServletContext().getRequestDispatcher("/reg.jsp").forward(req,resp);
			return;
		}
		else if(email.indexOf('@')!=email.lastIndexOf('@')){
		
			String error="Error in E-mail ID";
			req.setAttribute("error",error);
			getServletContext().getRequestDispatcher("/reg.jsp").forward(req,resp);
			return;
		}
		else if(phone==""){
		
			String error="PHONE NO Field Empty";
			req.setAttribute("error",error);
			getServletContext().getRequestDispatcher("/reg.jsp").forward(req,resp);
			return;
		}
		else if(pwd==""){
		
			String error="PASSWORD Field Empty";
			req.setAttribute("error",error);
			getServletContext().getRequestDispatcher("/reg.jsp").forward(req,resp);
			return;
		}
		else if(conf_pwd==""){
		
			String error="CONFIRM PASSWORD Field Empty";
			req.setAttribute("error",error);
			getServletContext().getRequestDispatcher("/reg.jsp").forward(req,resp);
			return;
		}
		else if(!pwd.equals(conf_pwd)){
		
			String error="PASSWORD MISS-MATCH";
			req.setAttribute("error",error);
			getServletContext().getRequestDispatcher("/reg.jsp").forward(req,resp);
			return;
		}
		else{
		
			UserInfo newdetails=new UserInfo();
			newdetails.setName(name);
			newdetails.setAddress(address);
			newdetails.setEmailId(email);
			newdetails.setPhone(phone);
			newdetails.setPwd(pwd);
			newdetails.setQue(que);
			newdetails.setAns(ans);
			newdetails.setDob(dob);
			newdetails.setStatus(status);
			try{
			
				i=newauth.correct(newdetails);
			}catch(SQLException e){

				e.printStackTrace();
			}	
			if(i==1){
			
				String account="ACCOUNT CREATED";
				req.setAttribute("message",account);
				getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
				return;
			}
			else{
			
				String error="UNABLE TO CREATE ENTRY TRY AGAIN LATER";
				req.setAttribute("error",error+i);
				getServletContext().getRequestDispatcher("/reg.jsp").forward(req,resp);
				return;
			}
		}
	}
}