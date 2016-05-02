
package com.rtos.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Logoutservlet extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
	
		doPost(req,resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
	
		HttpSession session=req.getSession(false);
		if(session!=null){
			
			if(session.getAttribute("info")!=null){
			
				session.invalidate();
				getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
				return;
			}
		}
	}
}