
package com.rtos.servlet.mobile;

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

public class Mobileitemservlet extends HttpServlet{

	Auth newauth;
	OrderInfo info;
	String s="";
	public void init(){
	
		this.newauth=new Auth((OrderDAO)getServletContext().getAttribute("order"));
	}
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		doPost(req,resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		try{
		
			ArrayList list=new ArrayList();
			String item=req.getParameter("ITEM");
			String data[]=item.split("[,|]");
			for(int i=1;i<data.length;i=i+2){
			
				info=new OrderInfo();
				info.setName(data[i]);
				info.setQty(Integer.parseInt(data[i+1]));
				list.add(info);
			}
			list=newauth.getprice(list);
			ByteArrayOutputStream ba=new ByteArrayOutputStream();
			ObjectOutputStream o=new ObjectOutputStream(ba);
			o.writeObject(list);
			byte[] order=ba.toByteArray();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			java.sql.Date d=new java.sql.Date(System.currentTimeMillis());
			float bill=0;
			for(int j=0;j<list.size();j++){
			
				bill+=((OrderInfo)list.get(j)).getTotal();
			}
			boolean flag=newauth.cust_order(System.currentTimeMillis()+"",data[0],d,new SerialBlob(order),bill,data[0]);
			System.out.println();
		}catch(Exception e){
		
			e.printStackTrace();
		}
	}	
}