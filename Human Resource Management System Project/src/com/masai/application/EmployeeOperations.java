package com.masai.application;
import com.masai.checkdetails.Check;
import com.masai.usecases.ApplyForLeave;
import com.masai.usecases.EmpViewProfile;
import com.masai.usecases.ResponseFromAdmin;
import com.masai.usecases.UpdateEmpProfile;


public class EmployeeOperations {

	 static int id;
	
	
	public EmployeeOperations() {
	
	}
	
	
	public EmployeeOperations(int id) {
		super();
		this.id = id;
	
	}
	
	public static void employeeOper() {
		
		
		
		int choice = (Integer.parseInt(Check.checkChoicesForEmp()));
		
		switch (choice) {
		case 1: {
			EmpViewProfile evp = new EmpViewProfile(id);
			evp.viewProfile();
			employeeOper();
			break;
		}
		case 2 :{
			UpdateEmpProfile uep = new UpdateEmpProfile(id);
			uep.updateProfile();
			employeeOper();
			break;
		}
		case 3 :{
			
			ApplyForLeave afl = new ApplyForLeave(id);
			afl.forLeave();
			employeeOper();
			break;
		}
		case 4 :{
			
			ResponseFromAdmin rfa = new ResponseFromAdmin(id);
			rfa.response();
			employeeOper();
			break;
		}
		case 5:{
			AdminOrEmployee.choice();
			break;
		}
		case 6:{
			return;
			
		}
		default:
			System.out.println("Please Press Valid Number");
			System.out.println("==========================");
			employeeOper();
		}
		
		
		
	
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
}
