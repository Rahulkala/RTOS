//listener to initailize the connection bean class i.e. Conn.java
package com.rtos.listener;

import javax.servlet.*;
import java.util.*;
import com.rtos.db.*;
import com.rtos.dao.*;

public class Startuplistener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent sce){
	
		ServletContext sc=sce.getServletContext();
		Conn c=new Conn();
		c.setdriver(sc.getInitParameter("driver"));
		c.setconn(sc.getInitParameter("connection"));
		c.setUser(sc.getInitParameter("db-user"));
		c.setPwd(sc.getInitParameter("db-pwd"));
		try{
		
			UserDAO user=new UserDAO(c);
			ItemDAO item=new ItemDAO(c);
			OrderDAO order=new OrderDAO(c);
			TableDAO table=new TableDAO(c);
			HashMap m=item.menulist();
			ArrayList category=item.getcategory();
			ArrayList ti=table.get_status();
			sc.setAttribute("ts",ti);
			sc.setAttribute("user",user);
			sc.setAttribute("table",table);
			sc.setAttribute("item",item);
			sc.setAttribute("order",order);
			sc.setAttribute("category",category);
			sc.setAttribute("menu",m);
		}catch(ClassNotFoundException e){
		
			throw new RuntimeException("Driver Class not Found",e);
		}
		catch(Exception e){
		
			e.printStackTrace();
		}
	}
	public void contextDestroyed(ServletContextEvent sce){
	
	}
}