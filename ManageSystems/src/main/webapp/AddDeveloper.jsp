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

<%@page import="java.util.*"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<form action="AddDeveloper" method="post">
      




  <div class="container">
      	<h1>Add new Developer</h1>
     	<label for="uname"><b>User name:</b></label>
    	<input type="text" placeholder="Enter Username" name="name" required><br>
    	
     	<label for="uid"><b>User Id:</b></label>
    	<input type="text" placeholder="Enter UserId" name="id" required><br>
    	
     	<label for="pass"><b>Password:</b></label>
     	<input type="password" placeholder="Enter Password" name="psw" required><br>
     		
      	<label for="uname"><b>City:</b></label>
   		<input type="text" placeholder="Enter City" name="city" required><br> 
   		
  
        <label for="Leader"><b>Leader:</b></label>
    	<select name='Leader' style='width:150px'>
    	 <c:forEach items="${list}" var="u"> 
		 <option>${u.getName()}</option>
		 </c:forEach>
		 </select>
		 </br> </br> </br>

    	<button type="submit">Add</button>
    	<a href='ViewAllDeveloper'><p>View All Developers</p></a>;
    	
    	
    	
    	
        
  </div>
  </form>
</body>
</html>