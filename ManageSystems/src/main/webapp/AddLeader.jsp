<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menu.html"/>
<form action="AddLeader" method="post">

  <div class="container">
      	<h1>Add new leader</h1>
     	<label for="uname"><b>User name:</b></label>
    	<input type="text" placeholder="Enter Username" name="name" required><br>
    	
     	<label for="uid"><b>User Id:</b></label>
    	<input type="text" placeholder="Enter UserId" name="id" required><br>
    	
     	<label for="pass"><b>Password:</b></label>
     	<input type="password" placeholder="Enter Password" name="psw" required><br>
     		
      	<label for="uname"><b>City:</b></label>
   		<input type="text" placeholder="Enter City" name="city" required><br>    
   		
    	<button type="submit">Add</button>
    	<a href='ViewAllLeader'><p>View All Leaders</p></a>;
    
  </div>
  </form>
</body>
</html>