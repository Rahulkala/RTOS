
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

public class Tablebookingservlet extends HttpServlet{

	Auth newauth; 
	boolean flag=false;
	public void init(){
	
		this.newauth=new Auth((TableDAO)getServletContext().getAttribute("table"));
	}
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		doPost(req,resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		String tnm=req.getParameter("t");
		String dur=req.getParameter("time");
		String nm=req.getParameter("nm");
		String no=req.getParameter("no");
		try{
		
			System.out.println(dur);
			ArrayList unb=new ArrayList();
			HttpSession s=req.getSession(false);
			flag=newauth.booktable(tnm,dur,nm,no);		//to book table
			unb=newauth.gettablelist();			//free table list
			s.setAttribute("tablefree",unb);
			s.setAttribute("ts",newauth.get_status());
			getServletContext().getRequestDispatcher("/managerwrk.jsp").forward(req,resp);
			return;
		}catch(Exception e){
		
			e.printStackTrace();
		}
	}
}