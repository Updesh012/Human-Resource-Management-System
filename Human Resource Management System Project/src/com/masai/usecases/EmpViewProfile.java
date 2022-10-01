package com.masai.usecases;

import com.masai.bean.Employee;
import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.EmployeeException;

public class EmpViewProfile {
	
	int id;
	
	public EmpViewProfile() {
	
	}
	public EmpViewProfile(int id) {
		super();
		this.id = id;
	}
	
	public  void viewProfile() {
		
		EmployeeDao ed = new EmployeeDaoImpl();
		
		try {
			Employee emp = ed.viewProfile(id);
			
			System.out.println("Your Employee Id is :  "+id);
			System.out.println("Your Name  is :        "+emp.getEmpName());
			System.out.println("Your Department is :   "+emp.getDeptId());
			System.out.println("Your Role  is :        "+emp.getEmpRole());
			System.out.println("Your Salary is :       "+emp.getEmpSalary());
			System.out.println("Your Password id :     "+emp.getEmpPassword());
			System.out.println("Your Email is :        "+emp.getEmpEmail());
			
		} catch (EmployeeException e) {
			
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	
	

}
