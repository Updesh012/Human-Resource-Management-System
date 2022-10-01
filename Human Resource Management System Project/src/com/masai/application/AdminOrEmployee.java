package com.masai.application;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.bean.Admin;
import com.masai.bean.Employee;
import com.masai.checkdetails.Check;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.AdminException;
import com.masai.exception.EmployeeException;

public class AdminOrEmployee {

	public static void choice() {
		
		Scanner s = new Scanner(System.in);
		
		try {
			System.out.println(" Press \n 1.) Login Admin \n 2.) Login Employee \n==================");
			int value = s.nextInt();
			s.nextLine();
			
			switch(value) {
			
			case 1 : 
			{
				
				String pass = Check.checkPass();
				String email = Check.checkemail();
				
				try {
					
					AdminDao adi = new AdminDaoImpl();
					Admin admin = adi.loginForAdmin(pass, email);
					
					System.out.println(" Welcome  --> "+admin.getName());
					System.out.println("================================");
					AdminOperations ao = new AdminOperations(pass,email);
					ao.adminOper();
					
				} catch (AdminException e) {
					System.out.println(e.getMessage());
					System.out.println("=================================");
					choice();
				}
			}	
				
				break;
			case 2 :
			{	
				
				
				String pass = Check.checkPass();
				String email = Check.checkemail();
				try {
					
					EmployeeDao ed = new EmployeeDaoImpl();
					Employee employee = ed.loginForEmployee(pass, email);
					
					
					System.out.println("Welcome --> "+employee.getEmpName() +"   Id is -->  "+employee.getEmpId());
					System.out.println("========================================================================");
					EmployeeOperations eo = new EmployeeOperations(employee.getEmpId(), pass, email);
					eo.employeeOper();
					
				} catch (EmployeeException e) {
					System.out.println(e.getMessage());
					choice();
					
				}
			}	
				break;
			default :
				System.out.println("Please Press Valid Number");
				System.out.println("=========================");
				choice();
				break;
			}
			
			
			
		} catch (Exception e) {
			System.out.println("Please Enter Only Number");
			System.out.println("=========================");
			choice();
		}
		
		
	
	
	}
}
