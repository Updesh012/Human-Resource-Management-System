package com.masai.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.masai.bean.Admin;
import com.masai.bean.Department;
import com.masai.bean.Employee;
import com.masai.bean.Leave;
import com.masai.checkdetails.Check;
import com.masai.exception.AdminException;
import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;
import com.masai.exception.LeaveException;
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
	public String updateProfile(Admin admin) throws AdminException{
		
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
			
			throw new AdminException(e.getMessage());
		}
		
		
		return message;
		
		
		
	}
	
	
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
				message = "Employee Added Successfully... ";
			}
			/////////////////////////Getting employee id from employee table//////////////////////////////
			
			PreparedStatement ps2 = conn.prepareStatement("SELECT empId FROM employee where empPassword = ?");
			ps2.setString(1, emp.getEmpPassword());
			
			ResultSet rs = ps2.executeQuery();
			int id = -1;
			if(rs.next()) {
				int i = rs.getInt("empId");
				id = i;
			}
			
			
			
			//////////////////////inserting empid and empName in leave table//////////////////////////////
			
			PreparedStatement ps3 = conn.prepareStatement("INSERT INTO leaveTable(emplName,empId) values (?,?)");
			ps3.setString(1, emp.getEmpName());
			ps3.setInt(2,id);
			
			ps3.executeUpdate();
			
			
		} catch (SQLException e) {
			
			message = e.getMessage();
			
		}
		
		
		
		return message;
	}
	
	
	
//	***************************add new Department*****************************
	
	public String addDepartment(String deptId,String deptName) {
		
		String message = "Not Added";
		
		try(Connection conn = GetConnection.connection()) {
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO department values(?,?)");
			ps.setInt(1, Integer.parseInt(deptId));
			ps.setString(2, deptName);
			
			int x = ps.executeUpdate();
			if(x > 0) {
				message = "New Department Added";
			}
				
		} catch (Exception e) {
				
			message = e.getMessage();
		}
		
		return message;
	}
	
	
	///////////////////////// update existing department/////////////////////////////////////////
	
	public String updateDepartment( String name) {
		
		String message = "Not Updated";
		boolean flag = true;
		String id = null;
		while(flag) {
			
			System.out.println("Department Id In Which You Want To Update");
			String deptid = Check.checkDeptid();
			id = deptid;
			
			try(Connection conn = GetConnection.connection()) {
				
				PreparedStatement ps = conn.prepareStatement("Select depName from department where depId = ?");
				ps.setInt(1, Integer.parseInt(deptid));
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					flag = false;
				}else {
					System.out.println("No Department Available For This Id");
					
				}
				
			} catch (Exception e) {
				message = e.getMessage();
			}
		}
			
		try(Connection conn =  GetConnection.connection()) {
			
			PreparedStatement ps = conn.prepareStatement("UPDATE department SET depName = ? WHERE depId = ?");
			ps.setString(1, name);
			ps.setInt(2, Integer.parseInt(id));
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Department Name Updated Successfully...";
			}
			
		} catch (Exception e) {
			message = e.getMessage();
		}
			
		return message;
		
	}
	
	/////////////////////////////transfer Employee to existing Department//////////////////////////////
	
	
	public String transferEmployee() {
		Scanner s = new Scanner(System.in);
		String message = "Transfer Failed";
		boolean flag1 = true;
		boolean flag2 = true;
		String empId = null;
		String deptId = null;
		
		while(flag1) {
			
			System.out.println("Enter The Employee Id That You Want To Transfer");
			String em = Check.checkEmpId();
			empId = em;
			try(Connection conn = GetConnection.connection()) {
				
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM employee WHERE empId = ?");
				ps.setInt(1, Integer.parseInt(em));
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					flag1=false;
				}else {
					System.out.println("Employee Not Present With This Id");
					System.out.println("==================================");
				}
				
			} catch (Exception e) {
				message = e.getMessage();
			}
			
			
		}
		
//		*************************checking for department****************************
		
		while(flag2) {
			
			System.out.println("Department Id In Which You Want To Transfer Employee");
			String de = Check.checkDeptid();
			deptId = de;
			try(Connection conn = GetConnection.connection()) {
				
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM department WHERE depId = ?");
				ps.setInt(1, Integer.parseInt(de));
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					flag2 = false;
				}else {
					System.out.println("No Department Available For This Id");
					System.out.println("===================================");
				}
				
			} catch (Exception e) {
				message = e.getMessage();
				
			}
			
		}
			
//		************************transfering the employee*************************
			
		try (Connection conn = GetConnection.connection()){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE employee SET did = ? WHERE empId = ?");
			ps.setInt(1, Integer.parseInt(deptId));
			ps.setInt(2, Integer.parseInt(empId));
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Employee with Id "+empId+" has been tranfered to Department Id "+deptId+"";
				
			}
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		
		return message;
	}

	//////////////////////////// Get all Department///////////////////////////////
	
	public List<Department> getAllDepartments() throws DepartmentException{
		
		List<Department> list = new ArrayList<>();
		
		try(Connection conn = GetConnection.connection()) {
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM department");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("depId");
				String name = rs.getString("depName");
				
				Department dep = new Department(id, name);
				list.add(dep);
				
			}
			
			
		} catch (Exception e) {
		   throw new DepartmentException(e.getMessage());	
		}
		
		if(list.size() == 0) {
			System.out.println("No Department Available.");
		}
		
		
		
		return list;
	}
	
	
	///////////////////////////////// Get All Employees ////////////////////////////////////
	
	public List<Employee> getAllEmployees() throws EmployeeException{
		
		List<Employee> list = new ArrayList<>();
		
		try(Connection conn = GetConnection.connection()) {
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM employee");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("empId");
				String name = rs.getString("empName");
				String sal = rs.getString("empSalary");
				String role = rs.getString("empRole");
				String did = rs.getString("did");
				
				Employee emp = new Employee(id, name, sal, role, did);
				list.add(emp);
			}
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		if(list.size() == 0) {
			System.out.println("No Employee Available");
		}
		
		
		return list;
	}
	
	////////////////////// Getting Leaves Details/////////////////////////////
	
	public List<Leave> getAllLeavesRequest() throws LeaveException{
		
		List<Leave> list = new ArrayList<>();
		
		try (Connection conn = GetConnection.connection()){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM leaveTable WHERE reason IS NOT Null AND permission IS null");
			
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) {
				
				String ln = rs.getString("leaveNum");
				String id = rs.getString("empId");
				String name = rs.getString("emplName");
				String dur = rs.getString("leavedura");
				String reason = rs.getString("reason");
				
				Leave l = new Leave(ln, name, dur, reason, id);
				
				list.add(l);
				
			}
			
		} catch (SQLException e) {
			throw new LeaveException(e.getMessage());
		}
		
			if(list.size() == 0) {
				System.out.println("No Record Found...");
			}
		
		return list;
	}
	
	////////////////////// respond to leave request //////////////////////////
	
	public String respontToLeaveRequest() {
		String message = "";
		List<Leave> list = null;
		try {
			list = getAllLeavesRequest();
		} catch (LeaveException e1) {
			System.out.println(e1.getMessage());
			
		}
		
		if(list.size() == 0) {
			
		}else {
		
		
		boolean flag = true;
		while(flag) {
		String id = Check.checkEmpId();
		
		try(Connection conn = GetConnection.connection()) {
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM leaveTable WHERE empId = ? AND reason IS NOT null AND permission IS null");
			ps.setInt(1, Integer.parseInt(id));
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				flag = false;

				try(Connection conn2 = GetConnection.connection()) {
					
					Scanner s = new Scanner(System.in);
					System.out.println("Enter Response For Employee Leave");
					String mess = s.nextLine();
					PreparedStatement ps2 = conn2.prepareStatement("UPDATE leaveTable SET permission = ? WHERE empid = ?");
					ps2.setString(1, mess);
					ps2.setInt(2, Integer.parseInt(id));
					
					int x = ps2.executeUpdate();
					if(x > 0) {
						message = ("Responded!");
					}else {
						message =("Something went wrong");
					}
					
					
				} catch (SQLException e) {
					message = e.getMessage();
				}
				
			}else {
				System.out.println("No Record Found With This Employee ID");
				System.out.println("=====================================");
			}
			
		} catch (SQLException e) {
			message = (e.getMessage());
		}
		
		
	}	
		
		
		}
		return message;
	}
	
	
	
	
	
	
	
	
	
	
}




