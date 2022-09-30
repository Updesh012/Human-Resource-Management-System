package com.masai.dao;

import com.masai.bean.Employee;
import com.masai.exception.EmployeeException;

public interface EmployeeDao {

	public Employee loginForEmployee(String pass, String email) throws EmployeeException;
	
	
	
	
	
}
