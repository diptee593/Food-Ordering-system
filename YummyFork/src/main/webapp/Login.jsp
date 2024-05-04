<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="Themes/myStyle.css">
</head>
<body >
	<form action="LoginController" method="POST" name="form">
		<div class ="container">
		<h1 class="label"  >Login</h1>
			<div class="loginform">
			
				<div class="role">
				<input type="radio" name="role" value="customer" required>
				<label>Customer</label>
				
				<input type="radio" name="role" value="admin" required>
				<label>Admin</label>
				</div>
			
				<div class="uname "> <label for="uname">Enter Email:</label></div>
				<input class="input" type="text" name="uname" placeholder="Enter username" required>
				
				
				<div class="pwd"><label for="pwd"> Enter Password:</label></div>
				<input class="input" type="password" name="pwd" placeholder="Enter password" required><br>
				
				<div class="login-btn">
				<input class="btn"  type="submit" value="Login"> </div>
				
				<div class="signup">Don't have an account? <a href="SignUp.jsp">SignUp</a></div>
		
			</div>
		</div>
	
	</form>
	
	<!--  	<script src="LoginValidation.js"></script>		-->
	
	
</body>
</html>