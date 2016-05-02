
package com.rtos;

public class CategoryInfo{

	private String name;
	private int discount;
	
	public void setName(String name){
	
		this.name=name;
	}
	public String getName(){
	
		return this.name;
	}
	public void setDiscount(int discount){
	
		this.discount=discount;
	}
	public int getDiscount(){
	
		return this.discount;
	}
}