
package com.rtos.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.rowset.serial.*;
import java.util.*;
import java.text.*;
import java.io.*;
import java.sql.*;
import com.rtos.*;
import com.rtos.db.*;
import com.rtos.dao.*;

public class Cartservlet extends HttpServlet{

	Auth newauth; 
	ArrayList m;
	OrderInfo info;
	int i,j=0;
	Blob b;
	public void init(){
	
		this.newauth=new Auth((OrderDAO)getServletContext().getAttribute("order"));
	}
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		doPost(req,resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		try{
		
			Map m1=req.getParameterMap();
			OrderInfo info;
			HttpSession s=req.getSession(false);
			m=(ArrayList)s.getAttribute("food");
			float bill=0;
			int j=0;
			ListIterator li=m.listIterator();
			while(li.hasNext()){
			
				info=(OrderInfo)li.next();
				String[] qty=(String[])m1.get(info.getName());
				int q=Integer.parseInt(qty[0]);
				if(q==1){
				
					bill+=info.getTotal();
				}
				if(q<1){
				
					li.remove();
				}
				if(q>1){
				
					info.setQty(q);
					bill+=info.getTotal();
					li.set(info);
				}
			}
			if(m.size()<1){
			
				getServletContext().getRequestDispatcher("/login_menu.jsp").forward(req,resp);
				return;
			}
			String sId=null;
			String msg="Error";
			Cookie[] cookies = req.getCookies();
            if (cookies != null)
            {
                for (Cookie cook : cookies)
                {
                    if ("JSESSIONID".equalsIgnoreCase(cook.getName()))
                    {
                        sId = cook.getValue();
                        break;
                    }
                }
            }
			ByteArrayOutputStream ba=new ByteArrayOutputStream();
			ObjectOutputStream o=new ObjectOutputStream(ba);
			o.writeObject(m);
			byte[] data=ba.toByteArray();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			java.sql.Date d=new java.sql.Date(System.currentTimeMillis());
			boolean flag=newauth.cust_order(sId+""+j++,((UserInfo)s.getAttribute("info")).getEmailId(),d,new SerialBlob(data),bill,((UserInfo)s.getAttribute("info")).getAddress());
			if(flag)
				msg="Order Saved";
			req.setAttribute("message",msg);	
			getServletContext().getRequestDispatcher("/final_orderpage.jsp").forward(req,resp);
			return;
		}catch(Exception ex){

			ex.printStackTrace();
		}
	}
}