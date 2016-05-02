
package com.rtos.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import com.rtos.*;
import com.rtos.db.*;
import com.rtos.dao.*;

public class UpdateItemservlet extends HttpServlet{

	Auth newauth; 
	ArrayList m=new ArrayList();
	int i;
	String s;
	public void init(){
	
		this.newauth=new Auth((ItemDAO)getServletContext().getAttribute("item"));
	}
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		doPost(req,resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		String itemselected=req.getParameter("prod");
		String nm=req.getParameter("item_name");
		String p=req.getParameter("item_price");
		String desc=req.getParameter("item_desc");
		int price=0;
		if(p!=null)
			price=Integer.parseInt(req.getParameter("item_price"));
		System.out.println("values "+itemselected+","+nm+","+price);
		try{
		
			String message="";
			if(nm==""&&price==0&&desc==""){
			
				message="No Parameter to update item";
				req.setAttribute("message",message);
				getServletContext().getRequestDispatcher("/update_item.jsp").forward(req,resp);
				return;
			}
			int i=newauth.updateitem(itemselected,nm,price,desc);
			if(i==0){
			
				message="No Item Is Updated";
			}
			if(i==1){
			
				message="Item Updated";
			}
			HashMap m=newauth.item_list();
			getServletContext().setAttribute("menu",m);
			req.setAttribute("message",message);
			getServletContext().getRequestDispatcher("/update_item.jsp").forward(req,resp);
			return;
		}catch(Exception e){
		
			e.printStackTrace();
		}
	}	
}