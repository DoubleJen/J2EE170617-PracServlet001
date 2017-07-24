<!-- 
	Member Added07401 <=> Member Query & Delete 073 <=> Member Update 074
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %>	
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Member Added</title>
</head>
<body>
	<h1>Member Added</h1>
	<hr>

	<form action="Servlet_Prac17071507401" method="post">
		ACCOUNT: <input type="text" name="account" placeholder="new account" /><br>
		PASSWORD: <input type="password" name="passwd" placeholder="new password" /><br>
		REAL NAME: <input type="text" name="realname" placeholder="new realname" /><br>
		<input type="submit" value="ADDED">
	</form>
</body>
</html>