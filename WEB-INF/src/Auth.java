// to create a connection with the database and to handle the request
package com.rtos.db;

import java.sql.*;
import com.rtos.db.*;
import com.rtos.*;
import java.io.*;
import com.rtos.dao.*;
import java.util.*;

public class Auth{

	private DAO dao;
	public Auth(DAO dao){
	
		this.dao=dao;
	}
	public ArrayList getprice(ArrayList list) throws SQLException{
	
		return ((OrderDAO)dao).getprice(list);
	}
	public ArrayList getbill(String id) throws SQLException,IOException,ClassNotFoundException{
	
		return ((OrderDAO)dao).getbill(id);
	}
	public HashMap gettodayorder(String date) throws SQLException,IOException,ClassNotFoundException{
	
		return ((OrderDAO)dao).gettodayorder(date);
	}
	public void undobook(String nm,String dur,String cnm) throws SQLException{
	
		((TableDAO)dao).undobook(nm,dur,cnm);
	}
	public boolean booktable(String tnm,String dur,String nm,String no) throws SQLException{
	
		return ((TableDAO)dao).booktable(tnm,dur,nm,no);
	}
	public ArrayList gettablelist() throws SQLException{
	
		return ((TableDAO)dao).gettablelist();
	}
	public int del(String t) throws SQLException{
	
		return ((TableDAO)dao).del(t);
	}
	public boolean add_table(String nm,int nof) throws SQLException{
	
		return ((TableDAO)dao).add_table(nm,nof);
	}
	public ArrayList get_status() throws SQLException{
	
		return ((TableDAO)dao).get_status();
	}
	public int correct(UserInfo newinfo) throws SQLException{
	
		return ((UserDAO)dao).newacc(newinfo);
	}
	public int new_category(CategoryInfo newinfo) throws SQLException{
	
		return ((ItemDAO)dao).newcategory(newinfo);
	}
	public ArrayList category_list() throws SQLException{
	
		return ((ItemDAO)dao).getcategory();
	}
	public String itemdatalist() throws SQLException{
	
		return ((ItemDAO)dao).itemdatalist();
	}
	public boolean cust_order(String id,String c_name,java.sql.Date date,Blob corder,float bill,String address) throws SQLException{
	
		return ((OrderDAO)dao).cust_order(id,c_name,date,corder,bill,address);
	}
	public HashMap item_list() throws SQLException{
	
		return ((ItemDAO)dao).menulist();
	}
	public int delitem(String itemselected) throws SQLException{
	
		return ((ItemDAO)dao).delitem(itemselected);
	}
	public int changeinfo(String id,String nm,String add,String no) throws SQLException{
	
		return ((UserDAO)dao).changeinfo(id,nm,add,no);
	}
	public HashMap getOrder() throws SQLException,IOException,ClassNotFoundException{
	
		return ((OrderDAO)dao).getOrder();
	}
	public int change(String old,String newpwd) throws SQLException{ 			//to change user password
	
		return ((UserDAO)dao).change(old,newpwd);
	}
	public int updateitem(String itemselected,String nm,int price,String desc) throws SQLException{
	
		return ((ItemDAO)dao).updateitem(itemselected,nm,price,desc);
	}
	public ArrayList itemorderlist(Enumeration e) throws SQLException{
	
		return ((OrderDAO)dao).itemorderlist(e);
	}
	public int new_item(ItemInfo newinfo) throws SQLException{
	
		return ((ItemDAO)dao).newitem(newinfo);
	}
	public UserInfo authenticate(String id,String pwd) throws SQLException{
	
		if(!((UserDAO)dao).checkpwd(id,pwd)){
		
			return null;
		}
		return ((UserDAO)dao).getUserInfo(id);
	}
	public UserInfo getUserInfo(String id) throws SQLException{
	
		return ((UserDAO)dao).getUserInfo(id);
	}
}