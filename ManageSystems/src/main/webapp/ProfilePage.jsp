<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="windows-1256">
<title>Personal Page</title>
<link rel="stylesheet" href="Style.css">
</head>
<body>
	<jsp:include page="menu.html" />


	<div class="imgcontainer">
		<img src="Personal.ico" alt="Avatar"text-align:center;
       margin: 24px 0 12px 0;>
	</div>

	<div class="container">
		<b><p>Name: ${FirstName} ${LastName}</p></b> <b><p>Id: ${Id}</p></b> <b><p>City:
				${City}</p></b> <b><p>Type: ${Type}</p></b>
	</div>
</body>
</html>