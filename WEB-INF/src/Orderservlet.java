
package com.rtos.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import com.rtos.*;
import com.rtos.db.*;
import com.rtos.dao.*;

public class Orderservlet extends HttpServlet{

	Auth newauth; 
	ArrayList m=new ArrayList();
	String s;
	public void init(){
	
		this.newauth=new Auth((OrderDAO)getServletContext().getAttribute("order"));
	}
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		doPost(req,resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		Enumeration e=req.getParameterNames();
		try{
		
			m=newauth.itemorderlist(e);
			HttpSession s=req.getSession(true);
			s.setAttribute("food",m);
		}catch(Exception ex){
		
			ex.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/cust_orderpage.jsp").forward(req,resp);
		return;
	}	
}