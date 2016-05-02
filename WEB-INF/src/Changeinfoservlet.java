
package com.rtos.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import com.rtos.*;
import com.rtos.db.*;
import com.rtos.dao.*;

public class Changeinfoservlet extends HttpServlet{

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
	
		String nm=req.getParameter("nm");
		String add=req.getParameter("address");
		String no=req.getParameter("phone");
		try{
		
			HttpSession s=req.getSession(false);
			UserInfo info=(UserInfo)s.getAttribute("info");
			i=newauth.changeinfo(info.getEmailId(),nm,add,no);
			info=newauth.getUserInfo(info.getEmailId());
			s.setAttribute("info",info);
			getServletContext().getRequestDispatcher("/afterlog.jsp").forward(req,resp);
			return;
			
		}catch(Exception e){
		
			e.printStackTrace();
		}
	}	
}