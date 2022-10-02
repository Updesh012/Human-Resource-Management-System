package com.masai.bean;

public class Admin {

	private String name;
	private String password;
	private String email;
	
	
	Admin(){
		
	}


	public Admin(String name, String password, String email) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
	}


	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	
	
	
	
	
	
}
