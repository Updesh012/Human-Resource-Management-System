package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.bean.Admin;
import com.masai.bean.Employee;
import com.masai.exception.AdminException;
import com.masai.exception.EmployeeException;
import com.masai.utility.GetConnection;

public class EmployeeDaoImpl implements EmployeeDao{
		
//	******************************Login For Employee************************************	
	public Employee loginForEmployee(String pass, String email) throws EmployeeException{
		
		Employee employee = null;
		
		try(Connection conn = GetConnection.connection()) {
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from employee WHERE empPassword like binary  ? AND empEmail = ?");
			
			ps.setString(1, pass);
			ps.setString(2, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("empId");
				String n = rs.getString("empName");
				String p = rs.getString("empPassword");
				String e = rs.getString("empEmail");
				
				
				employee = new Employee(id,n, pass, email);
			}else {
				
				throw new EmployeeException("Invalid Password or Email...");
			}
			
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return employee;
	}
//	******************************Login For Admin************************************	
	
	
	
}
