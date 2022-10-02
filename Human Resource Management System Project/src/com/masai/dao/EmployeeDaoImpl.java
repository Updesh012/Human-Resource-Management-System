package com.masai.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.masai.bean.Employee;
import com.masai.checkdetails.Check;
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
				
				
				
				employee = new Employee(id,n, pass, email);
			}else {
				
				throw new EmployeeException(" Invalid Password Or Email...");
				
			}
			
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return employee;
	}

	
	////////////////////////////  view profile ////////////////////////////
	
	
	public Employee viewProfile(int id) throws EmployeeException{
		
		Employee emp = null;
		
		try (Connection conn = GetConnection.connection()){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM employee WHERE empId = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				
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
			ps.setString(2, Check.checkemail());
			ps.setString(1, Check.checkPass());
			ps.setInt(3, id);
			
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
				System.out.println("Enter Reason For Leave");
				String reason = s.nextLine();
				
				try(Connection conn2 = GetConnection.connection()) {
					
					PreparedStatement ps2 = conn2.prepareStatement("UPDATE leaveTable SET leaveDura = ? , reason = ? WHERE empId = ?");
					ps2.setInt(1, Integer.parseInt(dur));
					ps2.setString(2, reason);
					ps2.setInt(3, id);
					
					int i = ps2.executeUpdate();
					if(i > 0) {
						message = "Successfully Applied For Leave !";
					}else {
						message = "Something Went Wrong";
					}
					
				} catch (SQLException e) {
					
					message = e.getMessage();
				}
				
				
			}else {
				message = "You Have Already Applied For Leave !";
			}
			
		} catch (SQLException e) {
			message =e.getMessage();
		}
		
		
		
		return message;
	}
	
	
	////////////////////////// Leave Response from admin ///////////////////////////////////
	
	public String leaveResponse(int id) {
		
		String message = "Not Responded Yet!";
		
		try (Connection conn = GetConnection.connection()){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM leaveTable WHERE empId = ? AND reason IS NOT null AND permission IS NOT null");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				try(Connection conn2 = GetConnection.connection()) {
					
					PreparedStatement ps2 = conn2.prepareStatement("SELECT permission FROM leaveTable WHERE empId = ?");
					ps2.setInt(1, id);
					
					ResultSet rs2 = ps2.executeQuery();
					
					if(rs2.next()) {
						String response = rs2.getString("permission");
						message = response;
//						********************setting again duration,reason,permission is null **************
						try(Connection conn3 = GetConnection.connection()) {
							
							PreparedStatement ps3 = conn3.prepareStatement("UPDATE leaveTable SET reason = null, permission = null,leavedura = null WHERE empId = ?");
							ps3.setInt(1, id);
							
							 ps3.executeUpdate();
							
							
						} catch (SQLException e) {
							message = e.getMessage();
						}
						
						
						
						
//						********************setting again duration,reason,permission is null **************
					}else {
						System.out.println("something went wrong");
					}
					
				} catch (SQLException e) {
					message = e.getMessage();
				}
				
				
			}
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		
		return message;
	}
	
	
	
	
	
	
	
	
}
