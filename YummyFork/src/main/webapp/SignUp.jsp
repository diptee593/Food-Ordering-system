<%@page import="com.yummyfork.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Themes/myStyle.css">
</head>
<body>
	
		<form action="AddCustomerController" method="POST" name="form">
		<div class ="signupcontainer">
		<h1 class="signuplabel" >SignUp</h1>
			<div class="signupform">
			
			
				<div class="signuprole">
			
				<input type="hidden" name="role" value="customer">
				
				
				</div>
				
				<table id="signuptable">
				
				<tr>
				<td class="row1 tlspace">Enter Name:</td>
				<td class="row2 tlspace">Enter Address:</td>
				</tr>
				
				<tr>
				<td class="row1 tispace"> <input type="text" name="name" placeholder="Enter name" required></td>
				<td class="row2 tispace"><input type="text" name="addr" placeholder="Enter password" required></td>
				</tr>
				
				<tr>
				<td class="row1 tlspace">Enter Mobile:</td>
				<td class="row2 tlspace">Enter Email:
				</td>
				</tr>
				
				<tr>
				<td class="row1 tispace"><input type="text" name="mob" placeholder="Enter mobile" required></td>
				<td class="row2 tispace"><input type="email" name="mail" placeholder="Enter email" required></td>
				</tr>
				
				<tr>
				<td class="row1 tlspace">Enter Password:</td>
				<td class="row2 tlspace">Re-enter password:</td>
				</tr>
				
				<tr>
				<td class="row1 tispace"><input type="password" name="pwd" placeholder="Enter password" required></td>
				<td class="row2 tispace"><input type="password" placeholder="Re-enter password" required></td>
				</tr>
				
				</table>
				<input class="register" type="submit" value="Register"><br>
				<div class="signup">Already have an account? <a href="Login.jsp">Login</a></div>
				
				
		
			</div>
		</div>
	
	</form>
	
</body>
</html>