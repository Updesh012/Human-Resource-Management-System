package com.masai.usecases;

import java.util.List;

import com.masai.bean.Department;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.DepartmentException;

public class GetAllDepartments {

	public void getAllDept() {
		
		AdminDao ad = new AdminDaoImpl();
		
		
		try {
			List<Department> list = ad.getAllDepartments();
			
			if(list.size() != 0) {
				
				for(Department d : list) {
					
					System.out.println("Department Id Is          :        "+ d.getDepId());
					System.out.println("Department Name Is        :        "+d.getDepName());
					System.out.println("==================================================");
					
				}
				
				
			}
			
		} catch (DepartmentException e) {
			
			System.out.println(e.getMessage());
			System.out.println("==================================================");
		}
		
	}
	

	
	
	
}
