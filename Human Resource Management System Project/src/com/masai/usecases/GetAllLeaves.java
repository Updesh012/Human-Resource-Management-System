package com.masai.usecases;

import java.util.List;

import com.masai.bean.Leave;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.LeaveException;

public class GetAllLeaves {

	
	public void getAllLeaves() {
		AdminDao ad = new AdminDaoImpl();
	
		try {
			List<Leave> list = ad.getAllLeavesRequest();
			
			for(Leave l : list) {
				System.out.println("Leave Number is :  "+l.getLeaveNum());
				System.out.println("Employee Id is :  "+l.getEmpId());
				System.out.println("Employee Name is :  "+l.getName());
				System.out.println("Leave Duration in days :  "+l.getDuration());
				System.out.println("Leave Reason :  "+l.getReason());
				System.out.println("=================================================");
			}
			
		} catch (LeaveException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
}
