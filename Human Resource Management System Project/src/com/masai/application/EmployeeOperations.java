package com.masai.application;

import java.util.Scanner;

import com.masai.checkdetails.Check;
import com.masai.usecases.ApplyForLeave;
import com.masai.usecases.EmpViewProfile;
import com.masai.usecases.ResponseFromAdmin;
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
		
		
		
		int choice = (Integer.parseInt(Check.checkChoicesForEmp()));
		
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
		case 4 :{
			
			ResponseFromAdmin rfa = new ResponseFromAdmin(id);
			rfa.response();
			employeeOper();
			break;
		}
		default:
			System.out.println("Please enter valid number");
			employeeOper();
		}
		
		
		
	
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
}
