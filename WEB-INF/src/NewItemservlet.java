
package com.rtos.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import com.rtos.*;
import com.rtos.db.*;
import com.rtos.dao.*;

public class NewItemservlet extends HttpServlet{

	Auth newauth; 
	int i;
	public void init(){
	
		this.newauth=new Auth((ItemDAO)getServletContext().getAttribute("item"));
	}
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		doPost(req,resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		String name,cat,desc;
		int price;
		name=req.getParameter("item_name");
		cat=req.getParameter("cat");
		price=Integer.parseInt(req.getParameter("price"));
		desc=req.getParameter("descr");
		ItemInfo newdetails =new ItemInfo();
		newdetails.setName(name);
		newdetails.setPrice(price);
		newdetails.setCategory(cat);
		newdetails.setDescription(desc);
		try{
		
			i=newauth.new_item(newdetails);
		}catch(SQLException e){
		
			e.printStackTrace();
		}
		if(i==1){
		
			req.setAttribute("msg","Item Added");
			try{
			
				HashMap rs=newauth.item_list();
				getServletContext().setAttribute("menu",rs);
			}catch(Exception e){

				e.printStackTrace();
			}			
			getServletContext().getRequestDispatcher("/insert_item.jsp").forward(req,resp);
			return;
		}
	}
}