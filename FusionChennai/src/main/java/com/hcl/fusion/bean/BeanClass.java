package com.hcl.fusion.bean;


public class BeanClass{

	private int Id;

	private String userName;

	private String passWord;
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}
	
	public String getUserName() {
		System.out.println("this is the method getUserName()");
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassWord() {
		System.out.println("jska");
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


}
