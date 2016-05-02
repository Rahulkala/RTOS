
package com.rtos.servlet.mobile;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import com.rtos.*;
import com.rtos.db.*;
import com.rtos.dao.*;

public class Mobileservlet extends HttpServlet{

	Auth newauth;
	int i,val;
	String s="";
	public void init(){
	
		this.newauth=new Auth((ItemDAO)getServletContext().getAttribute("item"));
	}
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		doPost(req,resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		try{
		
			String data=newauth.itemdatalist();
			PrintWriter out=resp.getWriter();
			out.println(data);
		}catch(Exception e){
		
			e.printStackTrace();
		}
	}	
}