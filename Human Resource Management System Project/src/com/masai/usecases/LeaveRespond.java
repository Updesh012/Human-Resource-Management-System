package com.masai.usecases;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class LeaveRespond {
	
	public void leaveRespond() {
		
		AdminDao ad = new AdminDaoImpl();
		ad.respontToLeaveRequest();
		
	}

}