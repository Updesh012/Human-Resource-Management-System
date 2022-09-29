package com.masai.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.bean.Admin;
import com.masai.bean.Employee;
import com.masai.exception.AdminException;
import com.masai.utility.GetConnection;


public class AdminDaoImpl implements AdminDao{

	String pass;
	String email;
	
	public AdminDaoImpl() {
		
	}
	
	public AdminDaoImpl(String pass, String email) {
		super();
		this.pass = pass;
		this.email = email;
	}



//******************************Update their profile************************************	
	@Override
	public String updateProfile(Admin admin) {
		
		String message = "Not Updated";
		
		try(Connection conn = GetConnection.connection()) {
			
			PreparedStatement ps = conn.prepareStatement
					("UPDATE admin SET name = ?,password = ?,email = ? WHERE password =? AND email = ? ");
			
			ps.setString(1, admin.getName());
			ps.setString(2, admin.getPassword());
			ps.setString(3, admin.getEmail());
			ps.setString(4, pass);
			ps.setString(5, email);
			
			int i = ps.executeUpdate();
			
			if(i > 0) {
				message = "Updated Successfully";
			}
			
		} catch (SQLException e) {
			
			message = e.getMessage();
		}
		
		
		return message;
	}
	
//	******************************Update their profile************************************
	
//	******************************Login For Admin************************************	
	public Admin loginForAdmin(String pass, String email) throws AdminException{
		
		Admin admin = null;
		
		try(Connection conn = GetConnection.connection()) {
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from Admin WHERE password like binary  ? AND email = ?");
			
			ps.setString(1, pass);
			ps.setString(2, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String n = rs.getString("name");
				String p = rs.getString("password");
				String e = rs.getString("email");
				
				admin = new Admin(n,p,e);
			}else {
				
				throw new AdminException("Invalid Password or Email...");
			}
			
			
		} catch (SQLException e) {
			throw new AdminException(e.getMessage());
		}
		
		return admin;
	}
//	******************************Login For Admin************************************	
	
	
//	***************************add new Employee*****************************
	
	public String addEmployee(Employee emp) {
		
		String message = "Not Insetered";
		
		try(Connection conn = GetConnection.connection()) {
			
			PreparedStatement ps = conn.prepareStatement
					("INSERT INTO employee(empName,empSalary,empRole,empPassword,empEmail,did) values(?,?,?,?,?,?)" );
			ps.setString(1, emp.getEmpName());
			ps.setDouble(2, Double.parseDouble(emp.getEmpSalary()));
			ps.setString(3, emp.getEmpRole());
			ps.setString(4, emp.getEmpPassword());
			ps.setString(5, emp.getEmpEmail());
			ps.setInt(6, Integer.parseInt(emp.getDeptId()));
			
			int x = ps.executeUpdate();
			if(x > 0) {
				message = "Employee Successfully Inserted";
			}
			
		} catch (SQLException e) {
			
			message = e.getMessage();
			
		}
		
		
		
		return message;
	}
	
	
	
//	***************************add new Employee*****************************
	
}
