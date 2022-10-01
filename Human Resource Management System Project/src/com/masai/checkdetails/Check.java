package com.masai.checkdetails;

import java.util.Scanner;

public class Check {

	//////////////////////////////checking password credentails/////////////////////////
	public static String passwordCredentials(String s) {
		
		String  message = null;
		
		if(s.length() < 4) {
			message = "Password length must be greater or equal to 4";
		}else if(s.contains("@") || s.contains("#") || s.contains("$") || s.contains("%") || s.contains("&")) {
			
			message = "Strong Password";
			
		}else {
			message = "Password must contain at least one character from @,#,$,%,& ";
		}
		
		
		return message;
		
	}
	
	/////////////////////////////////check password/////////////////////////////////////////
	
	public static String checkPassword() {
		
	
		
		boolean flag1 = true;
		Scanner sc = new Scanner(System.in);
		String password=null;
		while(flag1) {
			System.out.println("Give Employee Default Password");
			String pass = sc.nextLine();
			password = pass;
			String res = Check.passwordCredentials(pass);
			if(res.equals("Strong Password")) {
				flag1 = false;
			}
			System.out.println(res);
		}
		
		return password;
		
	}
	
	///////////////////////////////////////checking email Credentials////////////////////////////////////////////////////////////
	
	public static String emailCredentials(String e) {
		
		String message = "Strong Email";
		
		if(e.length() < 11) {
			message = "Length of email must be greater than 10 including   @gmail.com";
		}else if(e.contains("!") || e.contains("#") || e.contains("$") || e.contains("%") || e.contains("&")) {
			
			if(e.contains("@gmail.com")) {
				
				message = "Strong Email";
			}else {
				message = "Email must contain   @gmail.com";
			}
			
		}else {
			message = "Email must contain at least one character from !,#,$,%,&";
		}
		
		
		return message;
	}
	
	/////////////////////////// check email////////////////////////////////////////////
	
	public static String checkEmail() {
		
		boolean flag2 = true;
		Scanner sc = new Scanner(System.in);
		String email=null;
		while(flag2) {
			System.out.println("Enter Employee Email");
			String e = sc.nextLine();
			email = e;
			String res = Check.emailCredentials(e);
			if(res.equals("Strong Email")) {
				flag2 = false;
			}
			System.out.println(res);
		
		}
		return email;
		
	}
	
	///////////////////////////////Check Salary Credentials///////////////////////////////////////////
	
	
	public static String checkSalary() {
		
		Scanner s = new Scanner(System.in);
		boolean flag3 = true;
		String salary=null;
		while(flag3) {
		System.out.println("Enter Employee Salary");
		String sal = s.nextLine();
			try {
				Double x = Double.parseDouble(sal);
				salary = x+"";
				flag3 = false;
				
				}catch(Exception e) {
					System.out.println("please enter number only");
				}
		}
		
		return salary;
	}
	
	
	
	////////////////////////////check departmentId//////////////////////////////
	
	public static String checkDeptid() {
		
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		String deptid=null;
		while(flag) {
		System.out.println("Enter department ID");
		String did = s.nextLine();
			try {
				int x = Integer.parseInt(did);
				deptid = x+"";
				flag = false;
				}catch(Exception e) {
					System.out.println("please enter number only");
				}
		}
		
		return deptid;
	}
	
	///////////////////////check employeeId////////////////////////
	
	
	public static String checkEmpId() {
		
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		String deptid=null;
		while(flag) {
		System.out.println("Enter Employee ID");
		String did = s.nextLine();
			try {
				int x = Integer.parseInt(did);
				deptid = x+"";
				flag = false;
				}catch(Exception e) {
					System.out.println("please enter number only");
				}
		}
		
		return deptid;
	}
	////////////////////////check leave duration /////////////////////
	public static String checkLeaveDur() {
		
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		String deptid=null;
		while(flag) {
		System.out.println("Enter Leave duration in days");
		String did = s.nextLine();
			try {
				int x = Integer.parseInt(did);
				deptid = x+"";
				flag = false;
				}catch(Exception e) {
					System.out.println("please enter number only");
				}
		}
		
		return deptid;
	}
	
	///////////////////////// check employee choice /////////////////////////
	
	public static String checkChoicesForEmp() {
		
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		String deptid=null;
		while(flag) {
			System.out.println("Press\n 1. View your profile\n 2. Update your profile \n 3. Apply for leave \n 4. Leave Response from Admin");
		String did = s.nextLine();
			try {
				int x = Integer.parseInt(did);
				deptid = x+"";
				flag = false;
				}catch(Exception e) {
					System.out.println("please enter number only");
				}
		}
		
		return deptid;
	}
	////////////// check admin choice ////////////////////////////////////////
	
	public static String checkChoicesForAdmin() {
		
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		String deptid=null;
		while(flag) {
		System.out.println("Press\n 1. Update your profile \n 2. Add new Employee \n 3. Transfer Employee from one department to another \n 4. Get all the employees Details \n 5. Add new Department \n 6. Update Department \n 7. Show all departments \n 8. Get all leaves details \n 9. Respond to employee leave");
		String did = s.nextLine();
			try {
				int x = Integer.parseInt(did);
				deptid = x+"";
				flag = false;
				}catch(Exception e) {
					System.out.println("please enter number only");
				}
		}
		
		return deptid;
	}
	
	
	/////////////////////// check login Password ///////////////////////
	
	public static String checkPass() {
		
	
		
		boolean flag1 = true;
		Scanner sc = new Scanner(System.in);
		String password=null;
		while(flag1) {
			System.out.println("Enter Password");
			String pass = sc.nextLine();
			password = pass;
			String res = Check.passwordCredentials(pass);
			if(res.equals("Strong Password")) {
				flag1 = false;
			}
			System.out.println(res);
		}
		
		return password;
		
	}
	
	////////////////////// check login email /////////////////////////////
	
	public static String checkemail() {
		
		boolean flag2 = true;
		Scanner sc = new Scanner(System.in);
		String email=null;
		while(flag2) {
			System.out.println("Enter Email");
			String e = sc.nextLine();
			email = e;
			String res = Check.emailCredentials(e);
			if(res.equals("Strong Email")) {
				flag2 = false;
			}
			System.out.println(res);
		
		}
		return email;
		
	}
	
}
