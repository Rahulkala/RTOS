//for all kinds of data connection

package com.rtos.dao;

import java.sql.*;
import java.util.*;
import com.rtos.db.*;	//for Conn.java
import com.rtos.*;	//for ItemInfo.java

public class ItemDAO implements DAO{

	private Conn con;
	public ItemDAO(Conn con) throws ClassNotFoundException{
	
		this.con=con;
		Class.forName(this.con.getdriver());
	}
	public int newitem(ItemInfo info) throws SQLException{
	
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		try{
		
			PreparedStatement ps=cnn.prepareStatement("insert into item_master values (?,?,?,?)");
			try{
			
				ps.setString(1,info.getName());
				ps.setInt(2,info.getPrice());
				ps.setString(3,info.getCategory());
				ps.setString(4,info.getDescription());
				int i=ps.executeUpdate();
					return i;
			}finally{
			
				ps.close();
			}
		}finally{
		
			cnn.close();
		}
	}
	public int delitem(String itemselected) throws SQLException{
	
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		try{
		
			PreparedStatement ps=cnn.prepareStatement("delete from item_master where item_name=?");
			try{
			
				ps.setString(1,itemselected);
				int i=ps.executeUpdate();
				return i;
			}finally{
			
				ps.close();
			}
		}finally{
		
			cnn.close();
		}
	}
	public int updateitem(String itemselected,String nm,int price,String desc) throws SQLException{
	
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		try{
			String query="";
			if((nm!="")&(price!=0)&(desc!="")){
			
				query="update item_master set item_name='"+nm+"',item_price='"+price+"',description='"+desc+"' where item_name='"+itemselected+"'";
			}
			if((nm!="")&(price==0)&(desc!="")){
			
				query="update item_master set item_name='"+nm+"',description='"+desc+"' where item_name='"+itemselected+"'";
			}
			if((nm=="")&(price!=0)&(desc!="")){
			
				query="update item_master set item_price='"+price+"',description='"+desc+"' where item_name='"+itemselected+"'";
			}
			if((nm!="")&(price!=0)&(desc=="")){
			
				query="update item_master set item_name='"+nm+"',item_price='"+price+"' where item_name='"+itemselected+"'";
			}
			if((nm!="")&(price==0)&(desc=="")){
			
				query="update item_master set item_name='"+nm+"' where item_name='"+itemselected+"'";
			}
			if((nm=="")&(price!=0)&(desc=="")){
			
				query="update item_master set item_price='"+price+"' where item_name='"+itemselected+"'";
			}
			if((nm=="")&(price==0)&(desc!="")){
			
				query="update item_master set description='"+desc+"' where item_name='"+itemselected+"'";
			}
			Statement smt=cnn.createStatement();
			try{
			
				int i=smt.executeUpdate(query);
				return i;
			}finally{
			
				smt.close();
			}
		}finally{
		
			cnn.close();
		}
	}
	public ArrayList getcategory() throws SQLException{
	
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		try{
		
			Statement smt=cnn.createStatement();
			try{
			
				ArrayList l=new ArrayList();
				ResultSet rs=smt.executeQuery("select category from category_master");
				while(rs.next()){
				
					l.add(rs.getString(1));
				}
				return l;
			}finally{
			
				smt.close();
			}
		}finally{
		
			cnn.close();
		}
	}
	public String itemdatalist() throws SQLException{
	
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		String data="";
		try{
		
			Statement smt=cnn.createStatement();
			try{
			
				ResultSet rs=smt.executeQuery("select * from item_master");
				while(rs.next()){
				
					if(rs.getString("category").equals("indian")){
					
						data+=rs.getString("item_name")+","+rs.getString("item_price")+","+1+"|";
					}
					if(rs.getString("category").equals("chinese")){
					
						data+=rs.getString("item_name")+","+rs.getString("item_price")+","+6+"|";
					}
					if(rs.getString("category").equals("Non-Veg")){
					
						data+=rs.getString("item_name")+","+rs.getString("item_price")+","+4+"|";
					}
					if(rs.getString("category").equals("pizza")){
					
						data+=rs.getString("item_name")+","+rs.getString("item_price")+","+2+"|";
					}
					if(rs.getString("category").equals("shakes")){
					
						data+=rs.getString("item_name")+","+rs.getString("item_price")+","+3+"|";
					}
				}
				return data;
			}finally{
			
				smt.close();
			}
		}finally{
		
			cnn.close();
		}
	}
	public HashMap menulist() throws SQLException{
	
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		try{
		
			Statement smt=cnn.createStatement();
			PreparedStatement ps=cnn.prepareStatement("select item_name,item_price,description from item_master where category=?");
			try{
			
				HashMap map=new HashMap();
				HashMap map1=null;
				ResultSet rs=smt.executeQuery("select * from category_master");
				ResultSet rs1;
				while(rs.next()){
				
					ps.setString(1,rs.getString(1));
					rs1=ps.executeQuery();
					if(!rs1.first())
						continue;
					map1=new HashMap();	
					do{
					
						map1.put("<b>"+rs1.getString(1).toUpperCase()+"</b> ("+rs1.getString(3)+")",rs1.getInt(2));
					}while(rs1.next());
					if(map1!=null)
						map.put(rs.getString(1).toUpperCase(),map1);
				}
				return map;
			}finally{

				smt.close();
			}	
		}finally{
		
			cnn.close();
		}
	}
	public int newcategory(CategoryInfo info) throws SQLException{
	
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		try{
		
			PreparedStatement ps=cnn.prepareStatement("insert into category_master values (?)");
			try{
			
				ps.setString(1,info.getName());
				int i=ps.executeUpdate();
					return i;
			}finally{
			
				ps.close();
			}
		}finally{
		
			cnn.close();
		}
	}
}