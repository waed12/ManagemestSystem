<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Login</title>
<link rel="stylesheet" href="Style.css">
</head>
<body>
	<form action="LoginServ" method="post">
		<div class="imgcontainer">
			<img src="management.jpg" alt="Avatar" class="avatar">
		</div>
		<div class="container">
			<label for="userName"><b>Username</b></label> <input type="text"
				placeholder="Enter Username" name="userName"><br> <label
				for="password"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password"><br>
				 <p><span style="color:red">${error}</span></p>
			<button type="submit">Login</button>

		</div>
	</form>
</body>
</html>