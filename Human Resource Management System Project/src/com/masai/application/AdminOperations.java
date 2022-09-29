package com.masai.application;

import java.util.Scanner;

import com.masai.bean.Admin;
import com.masai.dao.AdminDaoImpl;

public class AdminOperations {
	
	String pass;
	String email;
	
	public AdminOperations() {
	
	}

	public AdminOperations(String pass, String email) {
		super();
		this.pass = pass;
		this.email = email;
	}
	
	public void adminOper() {
		
		Scanner s = new Scanner(System.in);
		
		AdminDaoImpl adi = new AdminDaoImpl(pass,email);
		
		System.out.println("enter the name");
		String name =  s.nextLine();
		System.out.println("enter the password");
		String pass =  s.nextLine();
		System.out.println("enter the email");
		String email =  s.nextLine();
		
		Admin admin = new Admin(name, pass, email);
		
		String res = adi.updateProfile(admin);
		System.out.println(res);
		AdminOrEmployee.choice();
		
		
	}
	
	
	

}
