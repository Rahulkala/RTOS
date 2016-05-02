
package com.rtos.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import com.rtos.*;
import com.rtos.db.*;
import com.rtos.dao.*;

public class NewCategoryservlet extends HttpServlet{

	Auth newauth; 
	int i;
	public void init(){
	
		this.newauth=new Auth((ItemDAO)getServletContext().getAttribute("item"));
	}
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		doPost(req,resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		String name;
		int discount;
		name=req.getParameter("category_name");
		CategoryInfo newdetails =new CategoryInfo();
		newdetails.setName(name);
		try{
		
			i=newauth.new_category(newdetails);
		}catch(SQLException e){
		
			e.printStackTrace();
		}
		if(i==1){
		
			req.setAttribute("msg","Category Added");
			try{
			
				ArrayList rs=newauth.category_list();
				getServletContext().setAttribute("category",rs);
			}catch(Exception e){

				e.printStackTrace();
			}			
			getServletContext().getRequestDispatcher("/insert_category.jsp").forward(req,resp);
			return;
		}
	}
}