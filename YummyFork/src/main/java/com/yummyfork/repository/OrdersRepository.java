package com.yummyfork.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yummyfork.connection.DatabaseConnection;
import com.yummyfork.connection.QueryUtil;
import com.yummyfork.dto.Orders;

public class OrdersRepository {
	
	DatabaseConnection db=new DatabaseConnection();

	public void addOrders(Orders orders)throws SQLException{
		
		try(Connection connection=db.getConnection();
				PreparedStatement pst=connection.prepareStatement(QueryUtil.addOrders);){
			pst.setDouble(1,orders.getTotalBill());
			pst.setInt(2,orders.getCustId());
			pst.setString(3,orders.getStatus());
			//pst.setInt(4,orders.getOrderId());

				
			int rows=pst.executeUpdate();
			System.out.println(rows);
			if(rows>0) {
				System.out.println("Record inserted successfully");
				System.out.println("*****************************");

			}
			else {
				System.out.println("Failed to insert record");
			}
		
		}
	}
	
public boolean getOrderById(int orderId) throws SQLException{
		
		boolean isFound=false;
		
		try(Connection con=db.getConnection();
				PreparedStatement pst=con.prepareStatement(QueryUtil.getOrderById);
				){
			
			pst.setInt(1, orderId);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				isFound=true;
				
				//getFoodInfo(new Food(rs.getString(1),rs.getFloat(2),rs.getInt(3),rs.getString(4)));
					
				System.out.println("Order Id:"+rs.getInt("orderId"));
				System.out.println("Order total bill:"+rs.getDouble("ordertotalbill"));
				System.out.println("Order cust id:"+rs.getInt("ordercustid"));
				System.out.println("Order status:"+rs.getString("status"));

			}
			else {
				System.out.println("Record not found for cart id"+orderId);
			}
			
		}
		
		return isFound;
	}

public void updateOrder(Orders orders) throws SQLException {
	try(Connection con=db.getConnection();
			PreparedStatement pst=con.prepareStatement(QueryUtil.updateOrders);){
		
		pst.setDouble(1, orders.getTotalBill());
		pst.setInt(2, orders.getCustId());
		pst.setString(3, orders.getStatus());
		pst.setInt(4, orders.getOrderId());


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

public void deleteOrderById(int orderId) throws SQLException{
	try(Connection con=db.getConnection();
			//Statement st=con.createStatement();){
			
			PreparedStatement pst=con.prepareStatement(QueryUtil.deleteOrders);){
			pst.setInt(1, orderId);
			
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
	
public void getAllOrders() throws SQLException{
	
	try(Connection con=db.getConnection();
			PreparedStatement pst=con.prepareStatement(QueryUtil.getOrder)){
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			System.out.println("Order id: "+rs.getInt("orderid"));
			System.out.println("Order total bill: "+rs.getInt("ordertotalbill"));
			System.out.println("Order cust id: "+rs.getInt("ordercustid"));
			System.out.println("Order status: "+rs.getString("status"));
			System.out.println("*****************************");
		}
		
	}
}

}
