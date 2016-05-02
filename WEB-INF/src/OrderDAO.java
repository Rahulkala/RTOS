//for all kinds of data connection 

package com.rtos.dao;

import java.sql.*;
import java.util.*;
import java.io.*;
import com.rtos.db.*;	//for Conn.java
import com.rtos.*;	//for OrderInfo.java

public class OrderDAO implements DAO{

	private Conn con;
	public OrderDAO(Conn con) throws ClassNotFoundException{
	
		this.con=con;
		Class.forName(this.con.getdriver());
	}
	public HashMap gettodayorder(String date) throws SQLException,IOException,ClassNotFoundException{
	
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		java.sql.Date d=new java.sql.Date(System.currentTimeMillis());
		HashMap map=new HashMap();
		ArrayList list=new ArrayList();
		try{
		
			PreparedStatement ps=cnn.prepareStatement("select * from customer_order_master where date=?");
			try{
			
				ps.setDate(1,d);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
				
					UserInfo info=new UserInfo();
					info.setEmailId(rs.getString("customer_name"));
					Blob b=(Blob)rs.getBlob("orderlist");
					InputStream is=b.getBinaryStream();
					ObjectInputStream ois = new ObjectInputStream(is);
					list=(ArrayList)ois.readObject();
					map.put(info,list);
				}
				return map;
			}finally{
			
				ps.close();
			}
		}finally{
		
			cnn.close();
		}
	}
	public ArrayList getprice(ArrayList list) throws SQLException{
	
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		try{
		
			PreparedStatement ps=cnn.prepareStatement("select item_price from item_master where item_name=?");
			try{
			
				for(int i=0;i<list.size();i++){
				
					OrderInfo info=(OrderInfo)list.get(i);
					ps.setString(1,info.getName());
					ResultSet rs=ps.executeQuery();
					rs.next();
					info.setPrice(rs.getInt("item_price"));
					list.set(i,info);
				}
				return list;
			}finally{
			
				ps.close();
			}
		}finally{
		
			cnn.close();
		}
	}
	public boolean cust_order(String id,String c_name,java.sql.Date date,Blob corder,float bill,String address) throws SQLException{
	
		boolean flag;
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		try{
		
			PreparedStatement ps=cnn.prepareStatement("insert customer_order_master values(?,?,?,?,?,?,?)");
			try{
			
				ps.setString(1,id);
				ps.setString(2,c_name);
				ps.setDate(3,date);
				ps.setBlob(4,corder);
				ps.setFloat(5,bill);
				ps.setString(6,"n");
				ps.setString(7,address);
				flag=ps.execute();
				return flag;
			}finally{
			
				ps.close();
			}
		}finally{
		
			cnn.close();
		}
	}
	public ArrayList getbill(String id) throws SQLException,IOException,ClassNotFoundException{
	
		ArrayList list=new ArrayList();
		int i=0;
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		try{
		
			PreparedStatement ps=cnn.prepareStatement("select orderlist from customer_order_master where orderid=? and status='n'");
			PreparedStatement ps1=cnn.prepareStatement("update customer_order_master set status='y' where orderid=?");
			try{
			
				ps.setString(1,id);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
				
					Blob b=(Blob)rs.getBlob("orderlist");
					InputStream is=b.getBinaryStream();
					ObjectInputStream ois = new ObjectInputStream(is);
					list=(ArrayList)ois.readObject();
				}
				ps1.setString(1,id);
				ps1.executeUpdate();
				return list;
			}finally{
			
				ps.close();
			}
		}finally{
		
			cnn.close();
		}
	}
	public HashMap getOrder() throws SQLException,IOException,ClassNotFoundException{
	
		HashMap map= new HashMap();
		ArrayList rs1=new ArrayList();
		UserInfo info;
		int i=0;
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		try{
		
			Statement st=cnn.createStatement();
			try{
			
				ResultSet rs=st.executeQuery("select * from customer_order_master where status='n'");
				while(rs.next()){
				
					//array.add((Blob)rs.getBlob("orderlist
					Blob b=(Blob)rs.getBlob("orderlist");
					InputStream is=b.getBinaryStream();
					ObjectInputStream ois = new ObjectInputStream(is);
					rs1=(ArrayList)ois.readObject();
					info=new UserInfo();
					info.setEmailId(rs.getString("customer_name"));
					info.setAddress(rs.getString("address"));
					info.setName(rs.getString("orderid"));
					map.put(info,rs1);
					i++;
				}
				return map;
			}finally{
			
				st.close();
			}
		}finally{
		
			cnn.close();
		}
	}
	public ArrayList itemorderlist(Enumeration e) throws SQLException{	//adding OrderInfo in the ArrayList and blob stores each OrderInfo with n seperate by comma(,)
	
		ArrayList m = new ArrayList();
		String s;
		ResultSet rs;
		OrderInfo info;
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		try{
		
			PreparedStatement ps=cnn.prepareStatement("select item_price from item_master where item_name=?");
			try{
			
				while(e.hasMoreElements()){
				
					info=new OrderInfo();
					s=(String)e.nextElement();
					info.setName(s);
					info.setQty(1);
					ps.setString(1,s);
					rs=ps.executeQuery();
					rs.next();
					info.setPrice(rs.getInt(1));
					m.add(info);
				}
				return m;
			}finally{
			
			}
		}finally{
		
			cnn.close();
		}
	}
}