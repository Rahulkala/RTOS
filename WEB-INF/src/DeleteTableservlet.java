
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

public class DeleteTableservlet extends HttpServlet{

	Auth newauth; 
	int i=0;
	String msg="No Table Selected";
	public void init(){
	
		this.newauth=new Auth((TableDAO)getServletContext().getAttribute("table"));
	}
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		doPost(req,resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		String t=req.getParameter("t");
		ArrayList ti;
		HttpSession s=req.getSession(false);
		try{
		
			if(t!=null){
		
				i=newauth.del(t);
				ti=newauth.get_status();
				s.setAttribute("ts",ti);
				if(i!=0){
				
					msg="Table Deleted";
				}
				else{
				
					msg="Table Not Deleted";
				}
			}
			s.setAttribute("tablefree",newauth.gettablelist());
			s.setAttribute("tablemsg",msg);
			getServletContext().getRequestDispatcher("/managerwrk.jsp").forward(req,resp);
			return;
		}catch(Exception e){

			e.printStackTrace();
		}		
	}
}