
package com.rtos.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import com.rtos.*;
import com.rtos.db.*;
import com.rtos.dao.*;

public class Changepwdcustservlet extends HttpServlet{

	Auth newauth;
	int i;
	String s="";
	public void init(){
	
		this.newauth=new Auth((UserDAO)getServletContext().getAttribute("user"));
	}
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		doPost(req,resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		String old=req.getParameter("old");
		String newpwd=req.getParameter("new");
		try{
		
			i=newauth.change(old,newpwd);
		}catch(Exception e){

			e.printStackTrace();
		}		
		if(i==1){
		
			s="Password Changed";
		}
		if(i==0){
		
			s="Incorrect Password for this Login";
		}
		req.setAttribute("message",s);
		getServletContext().getRequestDispatcher("/changepwd1.jsp").forward(req,resp);
		return;
	}	
}