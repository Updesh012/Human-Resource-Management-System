package com.masai.application;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.bean.Admin;
import com.masai.bean.Employee;
import com.masai.dao.AdminDaoImpl;
import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.AdminException;
import com.masai.exception.EmployeeException;

public class AdminOrEmployee {

	public static void choice() {
		
		Scanner s = new Scanner(System.in);
		
		try {
			System.out.println("Type \n1 for Login as Admin \n2 for Login as Employee");
			int value = s.nextInt();
			s.nextLine();
			
			switch(value) {
			
			case 1 : 
			{
				System.out.println("admin");
				
				System.out.println("Enter your password");
				String pass = s.nextLine();
				System.out.println("Enter your email");
				String email = s.nextLine();
				
				try {
					
					AdminDaoImpl adi = new AdminDaoImpl();
					Admin admin = adi.loginForAdmin(pass, email);
					
					System.out.println("Welcome "+admin.getName());
					AdminOperations ao = new AdminOperations(pass,email);
					ao.adminOper();
					
				} catch (AdminException e) {
					System.out.println(e.getMessage());
					
				}
			}	
				
				break;
			case 2 :
				
				System.out.println("Employee");
				
				System.out.println("Enter your password");
				String pass = s.nextLine();
				System.out.println("Enter your email");
				String email = s.nextLine();
				
				try {
					
					EmployeeDao ed = new EmployeeDaoImpl();
					Employee employee = ed.loginForEmployee(pass, email);
					
					
					System.out.println("Welcome "+employee.getEmpName());
					EmployeeOperations eo = new EmployeeOperations();
					eo.employeeOper();
					
				} catch (EmployeeException e) {
					System.out.println(e.getMessage());
					
				}
				
				break;
			default :
				System.out.println("Please enter valid number");
				break;
			}
			
			
			
		} catch (Exception e) {
			System.out.println("Please enter Number");
		}
		
		
	
	
	}
}
