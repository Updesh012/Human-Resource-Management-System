package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Employee;
import com.masai.checkdetails.Check;
import com.masai.dao.AdminDaoImpl;

public class Addemployee {

	public static void main(String[] args) {
		
		AdminDaoImpl adi = new AdminDaoImpl();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Employee Name ");
		String name = s.nextLine();
		String salary = Check.checkSalary();
		System.out.println("Enter Employee Role");
		String role = s.nextLine();
		String deptid = Check.checkDeptid();
		String password = Check.checkPassword();
		String email =  Check.checkEmail();
		Employee emp = new Employee(name, salary, role, password, email,deptid);
		String res = adi.addEmployee(emp);
		System.out.println(res);
		
	}
	
	
}
