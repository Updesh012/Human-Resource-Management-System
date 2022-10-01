package com.masai.usecases;

import java.util.List;

import com.masai.bean.Employee;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.EmployeeException;

public class GetAllEmployee {

	public void allEmp() {
		
		AdminDao ad = new AdminDaoImpl();
		
		try {
			List<Employee> list = ad.getAllEmployees();
			
			for(Employee e : list) {
				
				System.out.println("Employee Id is :  "+e.getEmpId());
				System.out.println("Employee name is :  "+e.getEmpName());
				System.out.println("Employee working in Deparment :  "+e.getDeptId());
				System.out.println("Employee Salary is :  "+e.getEmpSalary());
				System.out.println("Employee role is :  "+e.getEmpRole());
				System.out.println("========================================================");
				
			}
			
		} catch (EmployeeException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		
		
	}
	
	
	
}
