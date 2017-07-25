<!-- 
	Member Added <=> Member Query & Delete <=> Member Update
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Driver import-->
<sql:setDataSource
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://127.0.0.1:3306/doubleprac"
	user="root" password="root"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Member</title>
</head>
<body>
	<h1>Member Query Table</h1>
	<hr>
	<br>
	
	<h2><a href="MemberAdded.jsp">Add New Member</a></h2>
	
	<!-- Delete -->
	<c:if test="${!empty param.delid }">
		<sql:update var="delcount">
			delete from member where id = ?
			<sql:param>${param.delid }</sql:param>
		</sql:update>
	</c:if>
	
	<!-- select All Data from SQLtable "member" -->
	<sql:query var="result">select * from member</sql:query>
	
	<!-- put result into table -->
	<table border="1" width="100%">
		<tr>
			<th>ID</th>
			<th>ACCOUNT</th>
			<th>PASSWORD</th>
			<th>REAL NAME</th>
			<th>DELETE</th>
			<th>EDIT</th>
		</tr>
		
		<c:forEach items="${result.rows }" var="row">
			<tr>
				<td>${row.id }</td>
				<td>${row.account }</td>
				<td>${row.passwd }</td>
				<td>${row.realname }</td>
				<td><a href="?delid=${row.id }">Delete</a></td>
				<td><a href="MemberUpdate.jsp?editid=${row.id }">Edit</a></td>
			</tr>
		</c:forEach>
		
	</table>
	
</body>
</html>