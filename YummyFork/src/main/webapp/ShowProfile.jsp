<%@page import="com.yummyfork.dto.Admin"%>
<%@page import="com.yummyfork.dto.User"%>
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
	<%Admin a=(Admin)request.getAttribute("Admin"); %>
	<% Customer c=(Customer)request.getAttribute("Cust"); %>
	<%String role=(String) session.getAttribute("role"); %>
	
	<h2 style="text-align:center">Profile</h2>
	
	<table border="1" id="foodListTable" style="margin:auto">
	<tr>
	
	<th class="colwidth">Customer Name</th>
	<th class="colwidth">Customer Address</th>
	<th class="colwidth">Customer Mobile</th>
	<th class="colwidth">Customer Email</th>
	<th class="colwidth">Update</th>
	</tr>
	
	<%if(role.equalsIgnoreCase("customer")){  %>
	<tr>
	
	<td><%=c.getCustName() %></td>
	<td><%=c.getCustAddress() %></td>
	<td><%=c.getCustMobile()%></td>
	<td><%=c.getCustEmail() %></td>
	<td><a href="ProfileController?operation=editProfile&email=<%=c.getCustEmail() %>">Update</a></td>
	</tr>
	<%} 
	
	
	else if(role.equalsIgnoreCase("admin")){  %>
		<tr>
	
	<td><%=a.getAdminName() %></td>
	<td><%=a.getAdminAddress() %></td>
	<td><%=a.getAdminMobile()%></td>
	<td><%=a.getAdminEmail() %></td>
	
	<%System.out.println(a.getAdminId()+a.getAdminName() +a.getAdminAddress()+a.getAdminMobile()+a.getAdminEmail()); %>
	<td class="tdwidth"><a href="ProfileController?operation=editProfile&email=<%=a.getAdminEmail() %>">Update</a></td>
	</tr>
	<%} %>
	</table>
</body>
</html>