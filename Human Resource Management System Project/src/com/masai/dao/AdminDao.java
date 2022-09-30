package com.masai.dao;

import com.masai.bean.Admin;
import com.masai.bean.Employee;
import com.masai.exception.AdminException;

public interface AdminDao {

	public String updateProfile(Admin admin);
	
	public Admin loginForAdmin(String pass, String email) throws AdminException;
	
	public String addEmployee(Employee employee);
	
	public String addDepartment(String deptid,String deptName);
	
	public String updateDepartment( String depName);
	
	public String transferEmployee();
	
}
