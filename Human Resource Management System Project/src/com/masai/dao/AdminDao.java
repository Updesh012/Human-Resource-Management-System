package com.masai.dao;

import java.util.List;

import com.masai.bean.Admin;
import com.masai.bean.Department;
import com.masai.bean.Employee;
import com.masai.bean.Leave;
import com.masai.exception.AdminException;
import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;
import com.masai.exception.LeaveException;

public interface AdminDao {

	public String updateProfile(Admin admin) throws AdminException;
	
	public Admin loginForAdmin(String pass, String email) throws AdminException;
	
	public String addEmployee(Employee employee);
	
	public String addDepartment(String deptid,String deptName);
	
	public String updateDepartment( String depName);
	
	public String transferEmployee();
	
	public List<Department> getAllDepartments() throws DepartmentException;
	
	public List<Employee> getAllEmployees() throws EmployeeException;
	
	public List<Leave> getAllLeavesRequest() throws LeaveException;
	
	public String respontToLeaveRequest();
	
}
