package com.yummyfork.services;

import java.sql.SQLException;

import com.yummyfork.dto.Admin;
import com.yummyfork.dto.Customer;
import com.yummyfork.dto.User;
import com.yummyfork.repository.AdminRepository;

public class AdminService {

	AdminRepository ar;
	
	public AdminService(AdminRepository ar) {
		super();
		this.ar = ar;
	}
	
	public AdminService() {
		ar=new AdminRepository();
	}
	
//	public int addAdmin(Admin admin) {
//		try {
//			int flag=ar.getAdminByEmail(admin);
//			if(flag>0) {
//				return 0;
//			}
//			else {
//				ar.addAdmin(admin);
//				return 1;
//			}
//		}
//		catch(SQLException e) {
//			e.printStackTrace();
//			return 0;
//		}
//	}
	public Admin getUserByMail(String mail) {
		try {
			return ar.getAdminByEmail(mail);
		}catch(Exception e) {
			System.out.println("in catch block");
			e.printStackTrace();
			return null;
		}
	}
	public int updateAdmin(Admin admin) {
		try {
			return ar.updateAdmin(admin);
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
