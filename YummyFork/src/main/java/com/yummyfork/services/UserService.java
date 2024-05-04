package com.yummyfork.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yummyfork.dto.Customer;
import com.yummyfork.dto.Food;
import com.yummyfork.dto.User;
import com.yummyfork.repository.UserRepository;


public class UserService {
	
	UserRepository ur;


	public UserService(UserRepository ar) {
		super();
		this.ur = ur;
	}
	public UserService() {
		ur=new UserRepository();
	}
	public int addUser(User u) {
		try {
			
			int flag=ur.getUserByUsername(u);
			if(flag>0) {
				return 0;
			}
			else {
				ur.addUser(u);
				return 1;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	


}
