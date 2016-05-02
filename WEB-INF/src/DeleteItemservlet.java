
package com.rtos.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import com.rtos.*;
import com.rtos.db.*;
import com.rtos.dao.*;

public class DeleteItemservlet extends HttpServlet{

	Auth newauth; 
	ArrayList m=new ArrayList();
	int i;
	String s="";
	public void init(){
	
		this.newauth=new Auth((ItemDAO)getServletContext().getAttribute("item"));
	}
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		doPost(req,resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		String itemselected=req.getParameter("prod");
		try{
		
			if(itemselected==""){
			
				s="No Item Selected";
				req.setAttribute("message",s);
				getServletContext().getRequestDispatcher("/delete_item.jsp").forward(req,resp);
				return;
			}
			else{
			
				int i=newauth.delitem(itemselected);
				if(i==1){
				
					s="Item Deleted";
				}
				if(i==0){
				
					s="No Item Deleted";
				}
				HashMap m=newauth.item_list();
				getServletContext().setAttribute("menu",m);
				req.setAttribute("message",s);
				getServletContext().getRequestDispatcher("/delete_item.jsp").forward(req,resp);
				return;
			}	
		}catch(Exception e){
		
			e.printStackTrace();
		}
	}	
}