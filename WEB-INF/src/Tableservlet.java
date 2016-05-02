
package com.rtos.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.io.*;
import java.sql.*;
import com.rtos.*;
import com.rtos.db.*;
import com.rtos.dao.*;

public class Tableservlet extends HttpServlet{

	Auth newauth; 
	boolean flag;
	public void init(){
	
		this.newauth=new Auth((TableDAO)getServletContext().getAttribute("table"));
	}
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		doPost(req,resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		String nm;
		int nof;
		nm=req.getParameter("tbn");
		nof=Integer.parseInt(req.getParameter("no"));
		HttpSession s=req.getSession(false);
		ArrayList ti;
		try{
		
			flag=newauth.add_table(nm,nof);
			ti=newauth.get_status();
			s.setAttribute("ts",ti);
			s.setAttribute("tablefree",newauth.gettablelist());
			getServletContext().getRequestDispatcher("/managerwrk.jsp").forward(req,resp);
			return;
		}catch(Exception e){
		
			e.printStackTrace();
		}
	}
}