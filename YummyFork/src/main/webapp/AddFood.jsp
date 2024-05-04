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
		
		<form action="AddFoodController" method="POST" name="form">
		<div class ="signupcontainer">
		<h1 class="signuplabel" >Add Food</h1>
			<div class="loginform">
		
				<table id="signuptable">
				<tr>
				<td class="row2 tispace"><input type="hidden" name="operation" value="addFood"></td>
				</tr>
				
				<tr>
				<td class="row1 tlspace">Food Name:</td>
				<td class="row2 tlspace">Food Price: </td>
				</tr>
				
				<tr>
				<td class="row1 tispace"> <input type="text" name="name" required></td>
				<td class="row2 tispace"><input type="text" name="price" required></td>
				
				</tr>
				
				<tr>
				<td class="row1 tlspace">Food Quantity:</td>
				<td class="row2 tlspace">Food Category:</td>
				</tr>
				
				<tr>
				<td class="row1 tispace"><input type="text" name="quantity" required></td>
				<td class="row2 tispace"><input type="text" name="category" required></td>
				</tr>
				
				</table>
				<input class="register" type="submit" value="Add"><br>	
				
		
			</div>
		</div>
	
	</form>
	
</body>
</html>