<%@page import="com.yummyfork.dto.Food"%>
<%@page import="java.util.List"%>
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
	List<Food> foodList=(List<Food>) request.getAttribute("foodList");
	%> 
	<%String role=(String) session.getAttribute("role"); %>
	
	<h2 style="text-align:center">Food List</h2>
	
	<table id="foodListTable" style="margin:auto">
		<tr>
	 		<th class="colwidth">Food Name</th>
			<th class="colwidth">Food Price</th>
			<th class="colwidth">Food Quantity</th>
			<th class="colwidth">Food Category</th>
			
			<th class="operationcolwidth" colspan="3">Operations</th>
			
		</tr>
	
	<% for(Food f:foodList){ %>
	<tr>
	
	<td><%=f.getFoodName() %></td>
	<td><%=f.getFoodPrice() %></td>
	<td><%=f.getFoodQuantity() %></td>
	<td><%=f.getFoodCategory() %></td>
	
	<%if(role.equalsIgnoreCase("Admin")){ %>
	<td class="tdwidth"><a href="AddFoodController?operation=edit&foodId=<%= f.getFoodId() %>">Edit</a></td>
	<td class="tdwidth" id="deleteCol"><a href="AddFoodController?operation=delete&foodId=<%= f.getFoodId() %>">Delete</a></td>
	<%} %>
	<td class="tdwidth addcartbtn"><a href="AddCartController">Add to Cart</a>
	
	
	</tr>
	<% }  %>
	
	</table>
	
	<script>
	let value=document.getElementById("deleteCol").addEventListener("click", function() {
		  confirm("Do you want to delete?");
		  console.log(value);
	});
	</script>
</body>
</html>