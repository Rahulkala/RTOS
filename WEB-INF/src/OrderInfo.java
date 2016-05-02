
package com.rtos;
import java.io.*;

public class OrderInfo implements Serializable {

	private String name;
	private int qty;
	private int price;
	public int tqty;
	
	public void setName(String name){
	
		this.name=name;
	}
	public String getName(){
	
		return this.name;
	}
	public void setQty(int qty){
	
		this.qty=qty;
	}
	public int getQty(){
	
		return this.qty;
	}
	public void setPrice(int price){
	
		this.price=price;
	}
	public int getPrice(){
	
		return this.price;
	}
	public int getTotal(){
	
		tqty=qty*price;
		return this.tqty;
	}
}