//to store the database connection related strings
package com.rtos.db;

import java.sql.*;

public class Conn{

	String driver;
	String conn;
	String user;
	String dbpwd;
	public void setUser(String user){
	
		this.user=user;
	}
	public String getUser(){
	
		return this.user;
	}
	public void setPwd(String pwd){
	
		this.dbpwd=pwd;
	}
	public String getPwd(){
	
		return this.dbpwd;
	}
	public void setdriver(String d){
	
		this.driver=d;
	}
	public String getdriver(){

		return this.driver;
	}	
	public void setconn(String c){
	
		this.conn=c;
	}
	public String getconn(){
	
		return this.conn;
	}
}