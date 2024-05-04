package com.yummyfork.connection;

public class QueryUtil {
		
	public static String addFood="INSERT INTO FOOD(FOODNAME,FOODPRICE,FOODQUANTITY,FOODCATEGORY) VALUES(?,?,?,?)";
	
	public static String updateFood="UPDATE FOOD SET FOODNAME=?,FOODPRICE=?,FOODQUANTITY=?,FOODCATEGORY=? WHERE FOODID =?";
	
	public static String deleteFoodById= "DELETE FROM FOOD WHERE FOODID= ?";
	
	public static String getFoodById="SELECT * FROM FOOD WHERE FOODID =?";
		
	public static String getFoodByName="SELECT * FROM FOOD WHERE FOODNAME LIKE ? ";
	
	public static String getFoodByCategory="SELECT * FROM FOOD WHERE FOODCATEGORY=?" ;
	
//	public static String getFoodByCategory="select food.foodname,food.foodprice,food.foodquantity,food.foodcategory,foodcategory.maincategory from\r\n"
//			+ "food inner join foodcategory on food.foodcategory=foodcategory.foodcatename \r\n"
//			+ "where food.foodcategory=? and foodcategory.maincategory=?";

	public static String getAllFood="SELECT * FROM FOOD" ;
	
	
	public static String addCustomer="INSERT INTO CUSTOMER(CUSTNAME,CUSTADDRESS,CUSTMOBILE,CUSTEMAIL) VALUES(?,?,?,?)";
	
	public static String updateCustomer="UPDATE CUSTOMER SET CUSTNAME=?,CUSTADDRESS=?,CUSTMOBILE=? WHERE CUSTEMAIL=?";
	
	public static String deleteCustomerById="DELETE FROM CUSTOMER WHERE CUSTID=?";
	
	public static String getCustomerById="SELECT * FROM CUSTOMER WHERE CUSTID=?";
	
	public static String getCustomerByEmail="SELECT * FROM CUSTOMER WHERE CUSTEMAIL=?";

	
	//public static String getCustomerByName="SELECT * FROM CUSTOMER WHERE CUSTNAME=?";
	
	public static String getAllCustomer="SELECT * FROM CUSTOMER";
	
	
	public static String addFoodCategory="INSERT INTO FOODCATEGORY VALUES(?,?)";
	
	public static String updateFoodCategory="UPDATE FOODCATEGORY SET MAINCATEGORY=? WHERE FOODCATENAME=?";
	
	public static String deleteFoodCategory="DELETE FROM FOODCATEGORY WHERE FOODCATENAME=?";
	
	public static String getFoodCategoryByName="SELECT * FROM FOODCATEGORY WHERE FOODCATENAME=?";
	
	public static String getFoodCategory="SELECT * FROM FOODCATEGORY";
	
	
	public static String addCart="INSERT INTO CART(CARTQUANTITY,CARTFOODID,CARTCUSTID) VALUES(?,?,?)";
	
	public static String updateCart="UPDATE CART SET CARTQUANTITY=?,CARTFOODID=?,CARTCUSTID=? WHERE CARTID=?";
	
	public static String deleteCart="DELETE FROM CART WHERE CARTID=?";
	
	public static String getCartByCartId="SELECT * FROM CART WHERE CARTID=?";
	
	public static String getCart="SELECT * FROM CART";
	
	
	public static String addOrders="INSERT INTO ORDERS(ORDERTOTALBILL,ORDERCUSTID,STATUS) VALUES(?,?,?)";
	
	public static String updateOrders="UPDATE ORDERS SET ORDERTOTALBILL=?,ORDERCUSTID=?,STATUS=? WHERE ORDERID=?";
	
	public static String deleteOrders="DELETE FROM ORDERS WHERE ORDERID=?";
	
	public static String getOrderById="SELECT * FROM ORDERS WHERE ORDERID=?";
	
	public static String getOrder="SELECT * FROM ORDERS";
	
	
	public static String addUser="INSERT INTO USER VALUES (?,?,?)";
	
	public static String updateUser="UPDATE USER SET PASSWORD=? WHERE USERNAME=?";
	
	public static String deleteUser="DELETE FROM USER WHERE USERNAME=?";
	
	public static String  getUserByEmail="SELECT * FROM USER WHERE USERNAME=?";
	
	public static String isUserValid="SELECT * FROM USER WHERE ROLE=? AND USERNAME=? AND PASSWORD=?";
	
	
	public static String addAdmin="INSERT INTO ADMIN(ADMINNAME,ADMINADDRESS,ADMINMOBILE,ADMINEMAIL) VALUES(?,?,?,?)";
	
	public static String updateAdmin="UPDATE ADMIN SET ADMINNAME=?,ADMINADDRESS=?,ADMINMOBILE=? WHERE ADMINEMAIL=?";
	
	public static String deleteAdminById="DELETE FROM ADMIN WHERE ADMINID=?";
	
	public static String getAdminById="SELECT * FROM ADMIN WHERE ADMINID=?";
	
	public static String getAdminByEmail="SELECT * FROM ADMIN WHERE ADMINEMAIL=?";

}
