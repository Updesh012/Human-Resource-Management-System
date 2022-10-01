package com.masai.application;

import java.util.Scanner;

import com.masai.usecases.ApplyForLeave;
import com.masai.usecases.EmpViewProfile;
import com.masai.usecases.UpdateEmpProfile;

public class EmployeeOperations {

	static int id;
	static String password;
	static String email;
	
	public EmployeeOperations() {
	
	}
	
	
	public EmployeeOperations(int id, String password, String email) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
	}
	
	public static void employeeOper() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Press\n 1. View your profile\n 2. Update your profile \n 3. Apply for leave");
		int choice = s.nextInt();
		
		switch (choice) {
		case 1: {
			EmpViewProfile evp = new EmpViewProfile(id);
			evp.viewProfile();
			employeeOper();
			break;
		}
		case 2 :{
			UpdateEmpProfile uep = new UpdateEmpProfile(id);
			uep.updateProfile();
			employeeOper();
			break;
		}
		case 3 :{
			
			ApplyForLeave afl = new ApplyForLeave(id);
			afl.forLeave();
			employeeOper();
			break;
		}
		default:
//			throw new IllegalArgumentException("Unexpected value: " + key);
		}
		
		
		
	
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
}
