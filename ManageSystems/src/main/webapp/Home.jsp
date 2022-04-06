<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="task" class="com.oriented.tasks.TaskBean">
	</jsp:useBean>
	<jsp:setProperty property="*" name="task" />
	
	<%
	task.getTask(request, response);
	%>

</body>
</html>