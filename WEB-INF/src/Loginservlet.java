
package com.rtos.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import com.rtos.db.*;
import com.rtos.*;
import com.rtos.dao.*;

public class Loginservlet extends HttpServlet{

	private Auth auth;
	public void init(){
	
		this.auth=new Auth((UserDAO)getServletContext().getAttribute("user"));
	}
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
	
		String name=req.getParameter("user");
		String pwd=req.getParameter("pwd");
		String check=req.getParameter("remember");
		UserInfo info=null;
		//String a="a";
		try{
		
			info=auth.authenticate(name,pwd);
		}catch(SQLException e){
		
			e.printStackTrace();
			return;
		}
		if(info==null){
			
			String invalid="INVALID LOGIN";
			req.setAttribute("message",invalid);
			getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
			return;
		}
		if(check!=null){
		
			Cookie cookie=new Cookie("loginId",name);
			cookie.setMaxAge(1 * 24 * 60 * 60);
			resp.addCookie(cookie);
			cookie=new Cookie("pwd",pwd);
			cookie.setMaxAge(1 * 24 * 60 * 60);
			resp.addCookie(cookie);
		}
		HttpSession session=req.getSession(false);
		if(session!=null){
		
			session.invalidate();
		}
		session=req.getSession();
		session.setAttribute("info",info);
		String nm=info.getStatus();
		if(info.getStatus().equals("a")){ // for admin login
		
			getServletContext().getRequestDispatcher("/admin_home.html").forward(req,resp);	
		}
		else{
		
			getServletContext().getRequestDispatcher("/afterlog.jsp").forward(req,resp);
		}	
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
	
		doGet(req,resp);
	}
}