<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
<link rel="stylesheet" href="Style.css">
<script type="text/javascript">
	function myFunction() {
		var type = document.getElementById("typeId").value;
		if (type == "developer")
			document.getElementById("leaderId").style.display = "block";
		else
			document.getElementById("leaderId").style.display = "none";

	}
</script>
</head>
<body>
	<jsp:include page="menu.html" />

	<%@page import="java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<form action="AddDeveloper" method="post">





		<div class="container">
			<h1>Add new Employee</h1>


			<label for="uid"><b>User Id:</b></label> <input type="text"
				placeholder="Enter UserId" name="id" required><br> <label
				for="ufirstname"><b>First Name:</b></label> <input type="text"
				placeholder="Enter FirstName" name="firstName" required><br>
			<label for="ulastname"><b>Last Name:</b></label> <input type="text"
				placeholder="Enter Last Name" name="lastName" required><br>
			<label for="upassword"><b>Password:</b></label> <input
				type="Password" placeholder="Enter Password" name="password"
				required><br> <label for="ucity"><b>City:</b></label> <input
				type="text" placeholder="Enter City" name="city" required><br>
			<label for="uType"><b>Type:</b></label> <select id="typeId"
				onchange="myFunction()">
				<option value="manager">manager</option>
				<option value="leader">leader</option>
				<option value="developer">developer</option>
			</select> </br> </br>
			<div id="leaderId">
				<label for="lid"><b>Leader:</b></label> <select name='Leader'>

					<c:forEach items="${list}" var="u">
						<option>${u.getName()}</option>
					</c:forEach>
				</select>
			</div>


			</br> </br>
			<button type="submit">Add</button>
			<a href='ViewAllDeveloper'><p>View All Developers</p></a>;





		</div>
	</form>
</body>
</html>