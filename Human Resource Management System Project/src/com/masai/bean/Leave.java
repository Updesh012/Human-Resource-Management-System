package com.masai.bean;

public class Leave {

	private String leaveNum;
	private String Name;
	private String duration;
	private String reason;
	private String permission;
	private String empId;
	
	public Leave() {
		// TODO Auto-generated constructor stub
	}

	public Leave(String leaveNum, String name, String duration, String reason, String permission, String empId) {
		super();
		this.leaveNum = leaveNum;
		Name = name;
		this.duration = duration;
		this.reason = reason;
		this.permission = permission;
		this.empId = empId;
	}
	

	public Leave(String leaveNum, String name, String duration, String reason,  String empId) {
		super();
		this.leaveNum = leaveNum;
		Name = name;
		this.duration = duration;
		this.reason = reason;
		
		this.empId = empId;
	}

	public String getLeaveNum() {
		return leaveNum;
	}

	public void setLeaveNum(String leaveNum) {
		this.leaveNum = leaveNum;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	
	
	
	
}
