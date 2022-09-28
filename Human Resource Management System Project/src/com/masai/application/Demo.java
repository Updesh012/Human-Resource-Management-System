package com.masai.application;
import java.sql.Connection;

import com.masai.utility.*;

public class Demo {

	
	public static void main(String[] args) {
		
		
		try(Connection conn = GetConnection.connection()) {
			
			if(conn != null) {
				System.out.println("cnnected");
			}else {
				System.out.println(conn);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	
}
