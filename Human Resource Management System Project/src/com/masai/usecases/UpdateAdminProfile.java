package com.masai.usecases;

import java.util.Scanner;

import com.masai.application.AdminOperations;
import com.masai.application.AdminOrEmployee;
import com.masai.bean.Admin;
import com.masai.checkdetails.Check;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.AdminException;

public class UpdateAdminProfile {

	String password;
	String email;
	
	public UpdateAdminProfile() {
		
	}
	
	public UpdateAdminProfile(String pass,String email) {
		super();
		this.password = pass;
		this.email = email;
	}
	
	public void updateProfile() {
		
		
		Scanner s = new Scanner(System.in);
		
		AdminDaoImpl adi = new AdminDaoImpl(password,email);
		
		System.out.println("Enter The New Name");
		String name =  s.nextLine();
		String email = Check.checkemail();
		String pass = Check.checkPass();
		
		Admin admin = new Admin(name, pass, email);
		
		String res;
		try {
			res = adi.updateProfile(admin);
			System.out.println(res);
			System.out.println("=============================================");
			AdminOrEmployee.choice();
		} catch (AdminException e) {
			System.out.println(e.getMessage());
			System.out.println("=============================================");
			AdminOperations ao = new AdminOperations();
			ao.adminOper();
		}
		
		
		
		
	}
	
	
	
	
	
}
