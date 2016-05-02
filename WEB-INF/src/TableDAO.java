//for all kinds of data connection

package com.rtos.dao;

import java.sql.*;
import java.util.*;
import java.io.*;
import com.rtos.db.*;	//for Conn.java
import com.rtos.*;	//for TableInfo.java

public class TableDAO implements DAO{

	private Conn con;
	public TableDAO(Conn con) throws ClassNotFoundException{
	
		this.con=con;
		Class.forName(this.con.getdriver());
	}
	public ArrayList gettablelist() throws SQLException{		//get free table list
	
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		try{
		
			Statement st=cnn.createStatement();
			try{
			
				ArrayList tl=new ArrayList();
				ResultSet rs=st.executeQuery("select table_name from table_master where status='free' or status1='free'");
				while(rs.next()){
				
					tl.add(rs.getString("table_name"));
				}
				return tl;
			}finally{
			
				st.close();
			}
		}finally{
		
			cnn.close();
		}
	}
	public boolean booktable(String tnm,String dur,String nm,String no) throws SQLException{			//
	
		boolean flag=false;
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		try{
		
			PreparedStatement ps=cnn.prepareStatement("select * from table_master where table_name=?");
			try{
			
				String st="";
				//ps.setString(1,dur);
				ps.setString(1,tnm);
				ResultSet rs=ps.executeQuery();
				rs.next();
				if(rs.getString("status").equals("free")){
				
					st="update table_master set duration=?,status='booked',name=?,no=? where table_name=?";
				}
				else{
				
					st="update table_master set duration1=?,status1='booked',name1=?,no1=? where table_name=?";
				}
				PreparedStatement ps1=cnn.prepareStatement(st);
				ps1.setString(1,dur);
				ps1.setString(2,nm);
				ps1.setString(3,no);
				ps1.setString(4,tnm);
				flag=ps1.execute();
				return flag;
			}finally{
			
				ps.close();
			}
		}finally{
		
			cnn.close();
		}
	}
	public boolean add_table(String name,int nof) throws SQLException{
	
		boolean flag=false;
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		try{
		
			PreparedStatement ps=cnn.prepareStatement("insert into table_master (table_name,nof) values(?,?)");
			try{
			
				ps.setString(1,name);
				ps.setInt(2,nof);
				flag=ps.execute();
				return flag;
			}finally{
			
				ps.close();
			}
		}finally{
		
			cnn.close();
		}
	}
	public int del(String s) throws SQLException{
	
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		int i=0;
		try{
		
			PreparedStatement ps=cnn.prepareStatement("delete from table_master where table_name=?");
			try{
			
				ps.setString(1,s);
				i=ps.executeUpdate();
				return i;
			}finally{
			
				ps.close();
			}
		}finally{
		
			cnn.close();
		}
	}
	public void undobook(String nm,String dur,String cnm) throws SQLException{
	
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		boolean flag=false;
		try{
		
			PreparedStatement ps=cnn.prepareStatement("update table_master set duration='null',name='',no='',status='free' where table_name=? and duration=? and name=?");
			try{
			
				ps.setString(1,nm);
				ps.setString(2,dur);
				ps.setString(3,cnm);
				flag=ps.execute();
				if(!flag){
				
					ps=cnn.prepareStatement("update table_master set duration1='null',name1='',no1='',status1='free' where table_name=? and duration1=? and name1=?");
					ps.setString(1,nm);
					ps.setString(2,dur);
					ps.setString(3,cnm);
					flag=ps.execute();
				}
			}finally{
			
				ps.close();
			}
		}finally{
		
			cnn.close();
		}
	}
	public ArrayList get_status() throws SQLException{
	
		ArrayList ti=new ArrayList();
		TableInfo info;
		String s1;
		int i=0;
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		try{
		
			Statement smt=cnn.createStatement();
			try{
			
				ResultSet rs=smt.executeQuery("select * from table_master");
				while(rs.next()){
				
					info=new TableInfo();
					info.setName(rs.getString(1));
					info.setNof(rs.getInt(2));
					info.setDuration(rs.getString(3));
					String s=rs.getString(4);
					if(s.equals("booked")){
					
						s1="<a href='/website/unbook?name="+rs.getString(1)+"&dur="+rs.getString(3)+"&cnm="+rs.getString(7)+"'>"+s+"</a>";
					}
					else{
					
						s1=s;
					}
					info.setStatus(s1);
					info.setCnm(rs.getString(7));
					info.setDuration1(rs.getString(5));
					info.setNo(rs.getString(8));
					String s2=rs.getString(6);
					if(s2.equals("booked")){
					
						s1="<a href='/website/unbook?name="+rs.getString(1)+"&dur="+rs.getString(5)+"&cnm="+rs.getString(9)+"'>"+s2+"</a>";
					}
					else{
					
						s1=s2;
					}
					info.setCnm1(rs.getString(9));
					info.setNo1(rs.getString(10));
					info.setStatus1(s1);
					ti.add(i++,info);
				}
				return ti;
			}finally{
			
				smt.close();
			}
		}finally{
		
			cnn.close();
		}
	}
}