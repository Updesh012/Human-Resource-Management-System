package com.masai.bean;

public class Employee {

	private int empId;
	private String empName;
	private String empSalary;
	private String empRole;
	private String deptId;
	private String empPassword;
	private String empEmail;
	
	public Employee() {
	
	}

	public Employee(int empId, String empName, String empSalary, String empRole, String empPassword,String empEmail,String deptId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empRole = empRole;
		this.deptId = deptId;
		this.empPassword = empPassword;
		this.empEmail = empEmail;
	}
	
	public Employee( String empName, String empSalary, String empRole, String empPassword,String empEmail,String deptId) {
		super();
		
		this.empName = empName;
		this.empSalary = empSalary;
		this.empRole = empRole;
		this.deptId = deptId;
		this.empPassword = empPassword;
		this.empEmail = empEmail;
	}
	
	public Employee(int empId, String empName, String empSalary, String empRole,String deptId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empRole = empRole;
		this.deptId = deptId;
		
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(String empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empRole=" + empRole
				+ ", deptId=" + deptId + ", empPassword=" + empPassword + ", empEmail=" + empEmail + "]";
	}
	
	
	
	
	
}
