package com.yummyfork.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yummyfork.connection.DatabaseConnection;
import com.yummyfork.connection.QueryUtil;
import com.yummyfork.dto.Customer;
import com.yummyfork.dto.Food;
import com.yummyfork.dto.User;

public class UserRepository {
	
	DatabaseConnection db=new DatabaseConnection();

	public int addUser(User user)throws SQLException{
		
		try(Connection connection=db.getConnection();
				PreparedStatement pst=connection.prepareStatement(QueryUtil.addUser);){
			pst.setString(1, user.getRole());
			pst.setString(2,user.getUname());
			pst.setString(3,user.getUpwd());

				
			int rows=pst.executeUpdate();
			System.out.println(rows);
			if(rows>0) {
				System.out.println(" Admin Record inserted successfully");
				System.out.println("*****************************");
				return 1;
			}
			else {
				System.out.println("Failed to insert record");
				return 0;
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public List<User> getUserDetails(String username) throws SQLException{		
		Connection con=db.getConnection();
		List<User> userList=new ArrayList<User>();
		PreparedStatement pst=con.prepareStatement(QueryUtil.getUserByEmail);
		
	
		pst.setString(1,username);
		ResultSet rs=pst.executeQuery();
		
		while(rs.next()) {
			User u=new User();
			u.setRole(rs.getString(1));
//			u.setUname(rs.getString(2));
//			u.setUpwd(rs.getString(3));
			userList.add(u);
		}
		return userList;
		
	}
public int getUserByUsername(User user) throws SQLException{
			
		Connection con=db.getConnection();
		PreparedStatement pst=con.prepareStatement(QueryUtil.getUserByEmail);
				
			
			pst.setString(1, user.getUname());
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
								
				//getFoodInfo(new Food(rs.getString(1),rs.getFloat(2),rs.getInt(3),rs.getString(4)));
//				System.out.println("Role:"+rs.getString("role"));	
//				System.out.println("Username:"+rs.getString("username"));
//				System.out.println("Password:"+rs.getString("password"));
				
				return 1;

			}
			else {
				System.out.println("Record not found for username"+user.getUname());
				return 0;
			}
		}

public void updateUser(User user) throws SQLException {
	try(Connection con=db.getConnection();
			PreparedStatement pst=con.prepareStatement(QueryUtil.updateUser);){
		
		
		pst.setString(1, user.getUpwd());
		pst.setString(2, user.getUname());
	
		System.out.println(" password "+user.getUpwd()+" username "+user.getUname());
		int rows=pst.executeUpdate();
		
		if(rows>0) {
			System.out.println(" User Record updated successfully");
			System.out.println("*****************************");
		}
		else {
			System.out.println("Failed to update record");
			
		}
	}
}

public void deleteUserByUsername(String username) throws SQLException{
	try(Connection con=db.getConnection();
			//Statement st=con.createStatement();){
			
			PreparedStatement pst=con.prepareStatement(QueryUtil.deleteUser);){
			pst.setString(1, username);
			
		int rows=pst.executeUpdate();
		//int rows=st.executeUpdate(QueryUtil.deleteFoodById(foodId));
		
		if(rows>0) {
			System.out.println(" User Record deleted successfully");
			System.out.println("*****************************");

		}
		else {
			System.out.println("Record not deleted");
		}
	}
}

//public int userValidity(String username,String pwd) throws SQLException{
//	
//	try(Connection con=db.getConnection();
//			PreparedStatement pst=con.prepareStatement(QueryUtil.isUserValid)){
//		
//		pst.setString(1,username);
//		pst.setString(2, pwd);
//		
//		ResultSet rs=pst.executeQuery();
//		
//		if(rs.next()) {
//			System.out.println("valid");
//			return 1;
//		}
//		else {
//			System.out.println("Invalid");
//
//			return 0;
//		}
//		
//	}
//}

public int userValidity(User u) throws SQLException{
	// TODO Auto-generated method stub
	try(Connection con=db.getConnection();
			PreparedStatement pst=con.prepareStatement(QueryUtil.isUserValid)){
		
		pst.setString(1,u.getRole());
		pst.setString(2,u.getUname());
		pst.setString(3, u.getUpwd());
		
		ResultSet rs=pst.executeQuery();
		
		if(rs.next()) {
			System.out.println("valid");
			return 1;
		}
		else {
			System.out.println("Invalid");

			return 0;
		}
	}

	}

public User getUserByEmail(String mail) throws SQLException{		//ex
	
	Connection con=db.getConnection();
	PreparedStatement pst=con.prepareStatement(QueryUtil.getUserByEmail);
			
		
		pst.setString(1, mail);
		ResultSet rs=pst.executeQuery();

		while (rs.next()) {
							
//			System.out.println("cust Id: "+rs.getInt(1));
//			System.out.println("cust name: "+rs.getString(2));
//			System.out.println("cust address: "+rs.getString(3));
//			System.out.println("cust mobile: "+rs.getLong(4));
//			System.out.println("cust email: "+rs.getString(5));
//			System.out.println("*****************************");
			
			User u=new User();
			u.setRole(rs.getString(1));
			u.setUname(rs.getString(2));
			u.setUpwd(rs.getString(3));
			
			return u;
		}
	
	return null;
	
}


}
