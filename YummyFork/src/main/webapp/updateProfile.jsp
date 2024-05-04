<%@page import="com.yummyfork.dto.Admin"%>
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
	<%
	Customer c = (Customer) request.getAttribute("Cust");
	%>
	<%
	Admin a = (Admin) request.getAttribute("Admin");
	%>
	<%
	String role = (String) session.getAttribute("role");
	%>

	<form action="ProfileController" id="updateprofile" method="post">
		<div class="signupcontainer">
			<h1 class="signuplabel">Update Profile</h1>
			<div class="loginform">
			<table id="signuptable">
				<%
				if (role.equalsIgnoreCase("customer")) {
				%>
				<tr>
					<td class="row1 tispace">
						<input type="hidden" name="operation" value="updateProfile"></td>
					<td class="row2 tispace">
						<input type="hidden" name="email" value="<%=c.getCustEmail()%>"></td>
					<td class="row1 tispace">
						<input type="hidden" name="id" value="<%=c.getCustId()%>"></td>
				</tr>

				<tr>
					<td class="row1 tlspace">Customer Name</td>
					<td class="row2 tlspace">Customer Address</td>
				</tr>
				<tr>
					<td class="row1 tispace"> 
						<input type="text" name="custName" value="<%=c.getCustName()%>">
					</td>
					<td class="row2 tispace">
						<input type="text" name="custAddress" value="<%=c.getCustAddress()%>">
					</td>
				</tr>

				<tr>
					<td class="row1 tlspace">Cust mobile</td>
					
				</tr>

				<tr>
					<td class="row1 tispace">
					<input type="text" name="custMobile" value="<%=c.getCustMobile()%>"></td>
				

				</tr>
				<%
				} else {
				%>
				<tr>
					<td><input type="hidden" name="operation"
						value="updateProfile"></td>
					<td><input type="hidden" name="email"
						value="<%=a.getAdminEmail()%>"></td>
					<td><input type="hidden" name="id"
						value="<%=a.getAdminId()%>"></td>
				</tr>

				<tr>
					<td>Admin Name</td>
					<td>Admin Address</td>
				</tr>
				<tr>
					<td><input type="text" name="custName"
						value="<%=a.getAdminName()%>"></td>
					<td><input type="text" name="custAddress"
						value="<%=a.getAdminAddress()%>"></td>
				</tr>

				<tr>
					<td>Admin mobile</td>

				</tr>

				<tr>
					<td><input type="text" name="custMobile"
						value="<%=a.getAdminMobile()%>"></td>

				</tr>
				<%
				}
				%>
				<tr>
					<td><input class="register" type="submit" value="update"></td>
				</tr>

			</table>
			</div>
		</div>
	</form>
</body>
</html>