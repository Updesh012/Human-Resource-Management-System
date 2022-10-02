package com.masai.usecases;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

public class ResponseFromAdmin {

	int id;
	
	public ResponseFromAdmin() {
	
	}
	public ResponseFromAdmin(int id) {
		super();
		this.id = id;
	}
	
	public void response() {
		
		EmployeeDao ed = new EmployeeDaoImpl();
		String res = ed.leaveResponse(id);
		System.out.println(res);
		System.out.println("==================================================");
	}
	
	
}
