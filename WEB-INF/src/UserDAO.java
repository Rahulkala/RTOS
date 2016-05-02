//for all kinds of data connection
//userDAO ==> is used for all types of data i.e., item,users,etc.
package com.rtos.dao;

import java.sql.*;
import java.util.*;
import com.rtos.db.*;	//for Conn.java
import com.rtos.*;	//for UserInfo.java

public class UserDAO implements DAO{

	private Conn con;
	public UserDAO(Conn con) throws ClassNotFoundException{
	
		this.con=con;
		Class.forName(this.con.getdriver());
	}
	public int newacc(UserInfo newinfo) throws SQLException{
	
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		try{
		
			PreparedStatement ps=cnn.prepareStatement("insert into customer_master values(?,?,?,?,?,?,?,?,?)");
			try{
			
				ps.setString(1,newinfo.getName());
				ps.setString(2,newinfo.getEmailId());
				ps.setString(3,newinfo.getDob());
				ps.setString(4,newinfo.getAddress());
				ps.setString(5,newinfo.getstrPhone());
				ps.setString(6,newinfo.getPwd());
				ps.setString(7,newinfo.getQue());
				ps.setString(8,newinfo.getAns());
				ps.setString(9,newinfo.getStatus());
				int i=ps.executeUpdate();
					return i;
			}
			finally{
			
				ps.close();
			}
		}
		finally{
		
			cnn.close();
		}
	}
	public int changeinfo(String id,String nm,String add,String no) throws SQLException{
	
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		try{
		
			PreparedStatement ps=cnn.prepareStatement("update customer_master set c_name=?,c_address=?,c_phone=? where c_email=?");
			try{
			
				ps.setString(1,nm);
				ps.setString(2,add);
				ps.setString(3,no);
				ps.setString(4,id);
				int i=ps.executeUpdate();
				return i;
			}finally{
			
				ps.close();
			}
		}finally{
		
			cnn.close();
		}
	}
	public int change(String old,String newpwd) throws SQLException{
	
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		try{
		
			PreparedStatement ps=cnn.prepareStatement("update customer_master set c_pwd=? where c_pwd=?");
			try{
			
				ps.setString(1,newpwd);
				ps.setString(2,old);
				int i=ps.executeUpdate();
				return i;
			}finally{
			
				ps.close();
			}
		}finally{
		
			cnn.close();
		}
	}
	public boolean checkpwd(String id,String pwd) throws SQLException{
	
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		//Connection cnn=DriverManager.getConnection(con.getconn());
		try{
		
			PreparedStatement ps=cnn.prepareStatement("select * from customer_master where c_email=? and c_pwd=?");
			try{
			
				ps.setString(1,id);
				ps.setString(2,pwd);
				ResultSet rs=ps.executeQuery();
				try{
				
					return rs.next();
				}
				finally{
				
					rs.close();
				}
			}
			finally{
			
				ps.close();
			}
		}
		finally{
		
			cnn.close();
		}
	}
	public UserInfo getUserInfo(String id) throws SQLException{
	
		Connection cnn=DriverManager.getConnection(con.getconn(),con.getUser(),con.getPwd());
		//Connection cnn=DriverManager.getConnection(con.getconn());
		try{
		
			PreparedStatement ps=cnn.prepareStatement("select * from customer_master where c_email=?");
			try{
			
				ps.setString(1,id);
				ResultSet rs=ps.executeQuery();
				try{
				
					if(!rs.next()){
					
						return null;
					}
					UserInfo info=new UserInfo();
					info.setName(rs.getString("c_name"));
					info.setAddress(rs.getString("c_address"));
					info.setEmailId(rs.getString("c_email"));
					info.setPhone(rs.getString("c_phone"));
					info.setStatus(rs.getString("status"));
					return info;
				}
				finally{
				
					rs.close();
				}
			}
			finally{
			
				ps.close();
			}
		}
		finally{
		
			cnn.close();
		}
	}
}