package com.yummyfork.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yummyfork.connection.DatabaseConnection;
import com.yummyfork.connection.QueryUtil;
import com.yummyfork.dto.Food;
import com.yummyfork.dto.FoodCategory;


public class FoodRepository {
	
	DatabaseConnection db=new DatabaseConnection();
	
	public int addFood(Food food)throws SQLException{		//ex
		
		Connection connection=db.getConnection();
				PreparedStatement pst=connection.prepareStatement(QueryUtil.addFood);
			pst.setString(1,food.getFoodName());
			pst.setDouble(2,food.getFoodPrice());
			pst.setInt(3,food.getFoodQuantity());
			pst.setString(4,food.getFoodCategory());
			
//			System.out.println(food.getFoodName()+"\t"+food.getFoodPrice()+"\t"+food.getFoodQuantity()+"\t"+food.getFoodCategory());
//			
//			int rows=pst.executeUpdate();
//			System.out.println(rows);
//			if(rows>0) {
//				System.out.println("Record inserted successfully");
//				System.out.println("*****************************");
//
//			}
//			else {
//				System.out.println("Failed to insert record");
//			}
		
//		}
	return pst.executeUpdate();
	}
	
	public Food getFoodById(int foodId) throws SQLException{		//ex
				
		Connection con=db.getConnection();
		PreparedStatement pst=con.prepareStatement(QueryUtil.getFoodById);
							
			pst.setInt(1, foodId);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				Food f = new Food();
				f.setFoodId(rs.getInt(1));
				f.setFoodName(rs.getString(2));
				f.setFoodPrice(rs.getDouble(3));
				f.setFoodQuantity(rs.getInt(4));
				f.setFoodCategory(rs.getString(5));
				
				return f;
			}
			return null;
	}
	
	public Food getFoodByCategory(String category,String mainCategory) throws SQLException{
		
		Connection con=db.getConnection();
				PreparedStatement pst=con.prepareStatement(QueryUtil.getFoodByCategory);
				
			
			pst.setString(1, category);
			pst.setString(2, mainCategory);
			ResultSet rs=pst.executeQuery();

			while (rs.next()) {
							
//				System.out.println("Food Id: "+rs.getInt("foodid"));
//				System.out.println("Food name: "+rs.getString("foodname"));
//				System.out.println("Food Price: "+rs.getFloat("foodprice"));
//				System.out.println("Food Quantity: "+rs.getInt("foodquantity"));
//				System.out.println("Food category_name: "+rs.getString("foodcategory"));
//				System.out.println("*****************************");
				
				Food f = new Food();
				f.setFoodId(rs.getInt(1));
				f.setFoodName(rs.getString(2));
				f.setFoodPrice(rs.getDouble(3));
				f.setFoodQuantity(rs.getInt(4));
				f.setFoodCategory(rs.getString(5));
				
				return f;
			}
		return null;
	}

	public List<Food> getFoodByName(String foodName) throws SQLException{		//ex
		Connection con=db.getConnection();
		List<Food> foodList=new ArrayList<Food>();
		PreparedStatement pst=con.prepareStatement(QueryUtil.getFoodByName);
		
	
		pst.setString(1,"%"+foodName+"%");
		ResultSet rs=pst.executeQuery();
		
		while(rs.next()) {
			Food f=new Food();
			f.setFoodId(rs.getInt(1));
			f.setFoodName(rs.getString(2));
			f.setFoodPrice(rs.getDouble(3));
			f.setFoodQuantity(rs.getInt(4));
			f.setFoodCategory(rs.getString(5));
			foodList.add(f);
		}
		return foodList;
		
	}
	
	public List<Food> getFoodByCategorySearch(String category,String mainCategory) throws SQLException{		
		Connection con=db.getConnection();
		List<Food> foodList=new ArrayList<Food>();
		PreparedStatement pst=con.prepareStatement(QueryUtil.getFoodByCategory);
		
	
		pst.setString(1,"");
		ResultSet rs=pst.executeQuery();
		
		while(rs.next()) {
			Food f=new Food();
			f.setFoodId(rs.getInt(1));
			f.setFoodName(rs.getString(2));
			f.setFoodPrice(rs.getDouble(3));
			f.setFoodQuantity(rs.getInt(4));
			f.setFoodCategory(rs.getString(5));
			foodList.add(f);
			
			FoodCategory fc=new FoodCategory();
			fc.setFoodCategoryName(rs.getString(1));
			fc.setMainCategory(rs.getString(2));
			
			//foodList.add(fc);
		}
		return foodList;
		
	}
	
	public int updateFood(Food food) throws SQLException {
		Connection con=db.getConnection();
		PreparedStatement pst=con.prepareStatement(QueryUtil.updateFood);
			
			pst.setString(1, food.getFoodName());
			pst.setDouble(2, food.getFoodPrice());
			pst.setInt(3, food.getFoodQuantity());
			pst.setString(4, food.getFoodCategory());
			pst.setInt(5,food.getFoodId());

			return pst.executeUpdate();			
	}
	
	public int deleteFoodById(int foodId) throws SQLException{		//ex
		Connection con=db.getConnection();
				
				PreparedStatement pst=con.prepareStatement(QueryUtil.deleteFoodById);
				pst.setInt(1, foodId);
				
			int rows=pst.executeUpdate();
						
			if(rows>0) {
				System.out.println("Record deleted successfully");
				return 1;

			}
			else {
				System.out.println("Record not deleted");
				return 0;
			}
		
	}

	public List<Food> getAllFood() throws SQLException{		//ex
		Connection con=db.getConnection();
		List<Food> foodList=new ArrayList<Food>();
		PreparedStatement pst=con.prepareStatement(QueryUtil.getAllFood);
		ResultSet rs=pst.executeQuery();
		
		while(rs.next()) {
			Food f=new Food();
			f.setFoodId(rs.getInt(1));
			f.setFoodName(rs.getString(2));
			f.setFoodPrice(rs.getDouble(3));
			f.setFoodQuantity(rs.getInt(4));
			f.setFoodCategory(rs.getString(5));
			foodList.add(f);
		}
		return foodList;
		
	}
}
