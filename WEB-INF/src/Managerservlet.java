
package com.rtos.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import com.rtos.*;
import com.rtos.db.*;
import com.rtos.dao.*;

public class Managerservlet extends HttpServlet{

	Auth orderauth,newauth;
	int i,val;
	String s="";
	OrderInfo info;
	HashMap map;
	public void init(){
	
		this.orderauth=new Auth((OrderDAO)getServletContext().getAttribute("order"));
		this.newauth=new Auth((TableDAO)getServletContext().getAttribute("table"));
	}
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		doPost(req,resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		try{
		
			i=0;
			ArrayList ti=newauth.get_status();
			HashMap all=orderauth.gettodayorder(req.getParameter("date"));
			map=orderauth.getOrder();
			HttpSession s=req.getSession(false);
			s.setAttribute("neworder",map);
			s.setAttribute("ts",ti);
			s.setAttribute("allorder",all);
			s.setAttribute("tablefree",newauth.gettablelist());
			getServletContext().getRequestDispatcher("/managerwrk.jsp").forward(req,resp);
			return;
		}catch(Exception e){
		
			e.printStackTrace();
		}
	}	
}