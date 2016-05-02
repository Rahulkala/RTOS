
package com.rtos;

public class UserInfo {
 
	private String name;
    private String address;
    private String emailId;
	private String phone;
	private String pwd;
	private String que;
	private String ans;
	private String dob;
	private String status;

	public void setStatus(String status){
	
		this.status=status;
	}
	public String getStatus(){
	
		return this.status;
	}
	public void setPhone(String phone){
	
		this.phone=phone;
	}
	public String getstrPhone(){
	
		return this.phone;
	}
	public int getPhone(){
	
		return Integer.parseInt(this.phone);
	}
    public String getName() {
    
		return this.name;
    }
    public void setName(String n) {
        
		this.name = n;
    }
    public String getAddress() {
        
		return this.address;
    }
    public void setAddress(String adrs) {
        
		this.address = adrs;
    }
    public String getEmailId() {
        
		return this.emailId;
    }
    public void setEmailId(String e) {
        
		this.emailId = e;
    }
	public String getPwd() {
    
		return this.pwd;
    }
    public void setPwd(String n) {
        
		this.pwd = n;
    }
	public String getDob() {
    
		return this.dob;
    }
    public void setDob(String n) {
        
		this.dob = n;
    }
	public String getQue() {
    
		return this.que;
    }
    public void setQue(String n) {
        
		this.que = n;
    }
	public String getAns() {
    
		return this.ans;
    }
    public void setAns(String n) {
        
		this.ans = n;
    }
}