package com.masai.usecases;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class TransferEmployee {
	
	
	public static void main(String[] args) {
		
		AdminDao ad = new AdminDaoImpl();
		System.out.println(ad.transferEmployee());
		
		
	}
	

}
