package com.masai.usecases;

import java.util.Scanner;

import com.masai.checkdetails.Check;
import com.masai.dao.AdminDaoImpl;

public class AddDepartment {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner( System.in);
		String deptid = Check.checkDeptid();
		System.out.println("Enter department Name");
		String deptName = s.nextLine();
		
		AdminDaoImpl adi = new AdminDaoImpl();
		String res = adi.addDepartment(deptid,deptName);
		System.out.println(res);
		
		
		
	}
	

}
