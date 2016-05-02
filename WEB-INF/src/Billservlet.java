
package com.rtos.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import com.rtos.*;
import com.rtos.db.*;
import com.rtos.dao.*;

public class Billservlet extends HttpServlet{

	Auth orderauth;
	int i,val;
	String s="";
	ArrayList list;
	public void init(){
	
		this.orderauth=new Auth((OrderDAO)getServletContext().getAttribute("order"));
	}
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		doPost(req,resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		PrintWriter out=resp.getWriter();
		OrderInfo info;
		int total=0;
		try{
		
			String nm=req.getParameter("name");
			String add=req.getParameter("address");
			String id=req.getParameter("id");
			list=new ArrayList();
			list=(ArrayList)orderauth.getbill(id);
			if(list==null){
			
				out.println("<h1>No Bill</h1>");
			}
			else{
			
				HttpSession s=req.getSession(false);
				
				total=0;
				for(int j=0;j<list.size();j++){
				
					info=new OrderInfo();
					info=(OrderInfo)list.get(j);
					total+=info.getTotal();
				}
				s.setAttribute("bill",list);
				s.setAttribute("name",nm);
				s.setAttribute("address",add);
				s.setAttribute("total",total);
				getServletContext().getRequestDispatcher("/bill.jsp").forward(req,resp);
				return;
			}
		}catch(Exception e){
		
			e.printStackTrace();
		}
	}	
}