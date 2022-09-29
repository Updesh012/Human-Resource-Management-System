package com.masai.checkdetails;

public class Check {

	public static String checkPass(String s) {
		
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
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static String checkEmail(String e) {
		
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
	
	
	
	
}
