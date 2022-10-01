package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.masai.bean.Admin;
import com.masai.bean.Employee;
import com.masai.checkdetails.Check;
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
//	******************************Login For Employee************************************	
	
	////////////////////////////  view profile ////////////////////////////
	
	
	public Employee viewProfile(int id) throws EmployeeException{
		
		Employee emp = null;
		
		try (Connection conn = GetConnection.connection()){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM employee WHERE empId = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				int empId = rs.getInt("empId");
				String name = rs.getString("empName");
				String deptId =  rs.getString("did");
				String role = rs.getString("empRole");
				String salary = rs.getString("empSalary");
				String email = rs.getString("empEmail");
				String pass = rs.getString("empPassword");
				
				emp = new Employee(name, salary, role, pass, email, deptId);
				
			}else {
				throw new EmployeeException("No record found");
			}
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		
		return emp;
	}
	
	//////////////////////// Update Profile ///////////////////////////////////////
	
	
	public String updateProfile(int id) {
		
		String message = "Not Updated";
		
		try(Connection conn = GetConnection.connection()) {
			
			PreparedStatement ps = conn.prepareStatement("UPDATE employee SET empPassword = ? , empEmail = ? Where empId = ?");
			ps.setString(1, Check.checkPass());
			ps.setString(2, Check.checkemail());
			ps.setInt(3, id);
			System.out.println("id is ; "+id);
			int x = ps.executeUpdate();
			if(x > 0) {
				message = "Updated successfully!";
			}
			
			
		} catch (Exception e) {
			message = e.getMessage();
		}
		
		
		return message;
	}
	
	/////////////////// Apply for leave //////////////////////////////////////
	
	public String applyForLeave(int id) {
		
		String message = "Failed !!";
		
		try(Connection conn = GetConnection.connection()) {
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM leaveTable WHERE empId = ? AND reason IS null AND permission IS null");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				Scanner s = new Scanner(System.in);
				String dur = Check.checkLeaveDur();
				System.out.println("Enter Reason for leave");
				String reason = s.nextLine();
				
				try(Connection conn2 = GetConnection.connection()) {
					
					PreparedStatement ps2 = conn2.prepareStatement("UPDATE leaveTable SET leaveDura = ? , reason = ? WHERE empId = ?");
					ps2.setInt(1, Integer.parseInt(dur));
					ps2.setString(2, reason);
					ps2.setInt(3, id);
					
					int i = ps2.executeUpdate();
					if(i > 0) {
						message = "Successfully applied for leave !";
					}else {
						message = "Something went wrong";
					}
					
				} catch (SQLException e) {
					System.out.println("error");
					message = e.getMessage();
				}
				
				
			}else {
				message = "You have already applied for leave !";
			}
			
		} catch (SQLException e) {
			message =e.getMessage();
		}
		
		
		
		return message;
	}
	
	
	
	
	
	
	
	
	
}
