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
<%String role=(String) session.getAttribute("role"); %>
	
		<div class="header">
			<div class="cname">
				<img src="Images/logo.jpg">
				<div class="cname1">YummyFork</div>
			</div>

			<div class="menus">
				<a href="#">Home</a>
			</div>
			
			<%if(role.equalsIgnoreCase("Admin")){ %>
			<div class="menus">
				<a href="AddFood.jsp">Add Foods</a>
			</div>
			<%} %>
			
			<div class="menus">
				<a href="AddFoodController">Available foods</a>
			</div>
			<div class="menus">
				<a href="Search.jsp" class="dropbtn">Search</a>
				</div>
			
			<div class="menus">
				<a href="#">Cart</a>
			</div>
			<div class="dropdown">
				<button class="dropbtn">Profile</button>
				<div class="dropdown-content">
					<a href="ProfileController">My Profile</a> <a href="#">Logout</a>
				</div>
			</div>

		</div>
	
</body>
</html>