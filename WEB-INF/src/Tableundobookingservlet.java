
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

public class Tableundobookingservlet extends HttpServlet{

	Auth newauth; 
	boolean flag;
	public void init(){
	
		this.newauth=new Auth((TableDAO)getServletContext().getAttribute("table"));
	}
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		doPost(req,resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		String nm=req.getParameter("name");
		String cnm=req.getParameter("cnm");
		String dur=req.getParameter("dur");
		try{
		
			newauth.undobook(nm,dur,cnm);
			ArrayList ti=newauth.get_status();
			HttpSession s=req.getSession(false);
			s.setAttribute("tablefree",newauth.gettablelist());
			s.setAttribute("ts",ti);
			getServletContext().getRequestDispatcher("/managerwrk.jsp").forward(req,resp);
			return;
		}catch(Exception e){
		
			e.printStackTrace();
		}
	}
}