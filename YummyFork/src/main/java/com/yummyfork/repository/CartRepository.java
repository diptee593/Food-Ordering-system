package com.yummyfork.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yummyfork.connection.DatabaseConnection;
import com.yummyfork.connection.QueryUtil;
import com.yummyfork.dto.Cart;

public class CartRepository {
	
	DatabaseConnection db=new DatabaseConnection();

	public int addCart(Cart cart)throws SQLException{
		
		Connection connection=db.getConnection();
				PreparedStatement pst=connection.prepareStatement(QueryUtil.addCart);
			pst.setInt(1,cart.getCartQuantity());
			pst.setInt(2,cart.getCartFoodId());
			pst.setInt(3,cart.getCartCustId());
				
			return pst.executeUpdate();		
		}
	
	
	public boolean getCartByCartId(int cartId) throws SQLException{
		
		boolean isFound=false;
		
		try(Connection con=db.getConnection();
				PreparedStatement pst=con.prepareStatement(QueryUtil.getCartByCartId);
				){
			
			pst.setInt(1, cartId);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				isFound=true;
				
				//getFoodInfo(new Food(rs.getString(1),rs.getFloat(2),rs.getInt(3),rs.getString(4)));
					
				System.out.println("Cart Id:"+rs.getInt("cartId"));
				System.out.println("Cart Quantity:"+rs.getInt("cartquantity"));
				System.out.println("Cart Food Id:"+rs.getInt("cartfoodid"));
				System.out.println("Cart Cust Id:"+rs.getInt("cartcustid"));

			}
			else {
				System.out.println("Record not found for cart id"+cartId);
			}
			
		}
		
		return isFound;
	}
	
	public void updateCart(Cart cart) throws SQLException {
		try(Connection con=db.getConnection();
				PreparedStatement pst=con.prepareStatement(QueryUtil.updateCart);){
			
			pst.setInt(1, cart.getCartQuantity());
			pst.setInt(2, cart.getCartFoodId());
			pst.setInt(3, cart.getCartCustId());
			pst.setInt(4, cart.getCartId());


			int rows=pst.executeUpdate();
			
			if(rows>0) {
				System.out.println("Record updated successfully");
				System.out.println("*****************************");
			}
			else {
				System.out.println("Failed to update record");
			}
		}
	}
	
	public void deleteCartById(int cartId) throws SQLException{
		try(Connection con=db.getConnection();
				//Statement st=con.createStatement();){
				
				PreparedStatement pst=con.prepareStatement(QueryUtil.deleteCart);){
				pst.setInt(1, cartId);
				
			int rows=pst.executeUpdate();
			//int rows=st.executeUpdate(QueryUtil.deleteFoodById(foodId));
			
			if(rows>0) {
				System.out.println("Record deleted successfully");
				System.out.println("*****************************");

			}
			else {
				System.out.println("Record not deleted");
			}
		}
	}
	
	public void getAllCart() throws SQLException{
		
		try(Connection con=db.getConnection();
				PreparedStatement pst=con.prepareStatement(QueryUtil.getCart)){
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println("Cart id: "+rs.getInt("cartid"));
				System.out.println("Cart quantity: "+rs.getInt("cartquantity"));
				System.out.println("Cart food id: "+rs.getInt("cartfoodid"));
				System.out.println("Cart cust id: "+rs.getInt("cartcustid"));
				System.out.println("*****************************");
			}
			
		}
	}
	

}
