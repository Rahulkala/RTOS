
package com.rtos;

public class ItemInfo{

	private String name;
	private String category,desc;
	private int price;
	
	public void setName(String name){
	
		this.name=name;
	}
	public String getName(){
	
		return this.name;
	}
	public void setCategory(String category){
	
		this.category=category;
	}
	public String getCategory(){
	
		return this.category;
	}
	public void setPrice(int price){
	
		this.price=price;
	}
	public int getPrice(){
	
		return this.price;
	}
	public void setDescription(String desc){
	
		this.desc=desc;
	}
	public String getDescription(){
	
		return this.desc;
	}
}