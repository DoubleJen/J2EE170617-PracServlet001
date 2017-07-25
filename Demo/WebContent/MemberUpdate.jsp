<!-- 
	Member Added <=> Member Query & Delete <=> Member Update
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="tw.dou.servlet.BCrypt" %>

<%
	String passwd = (String)pageContext.getAttribute("passwd");
	String salt = BCrypt.gensalt();
	String hashpasswd = BCrypt.hashpw(passwd, salt);
	request.setAttribute("hashpasswd", hashpasswd);
%>
	
<!-- Test ID is null or not, if null then return-->
<c:if test="${empty param.editid and empty param.id }">
	<c:redirect url="MemberQueryDel.jsp"/>
</c:if>

<!-- Driver import-->
<sql:setDataSource
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://127.0.0.1:3306/doubleprac"
	user="root" password="root"/>

<!-- Update member Data and return-->
<c:if test="${!empty param.id }">
	<sql:update var="updatecount">
		update member set account=?, passwd=?, realname=? where id=?
		<sql:param>${param.account }</sql:param>
		<sql:param>${hashpasswd }</sql:param>
		<sql:param>${param.realname }</sql:param>
		<sql:param>${param.id }</sql:param>
	</sql:update>
	<c:redirect url="MemberQueryDel.jsp"/>
</c:if>

<!-- select Data from SQLtable "member" -->
<sql:query var="result">
	select * from member where id=?
	<sql:param>${param.editid }</sql:param>
</sql:query>	


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Member Update</title>
</head>
<body>
	<h1>Member Update</h1>
	<hr>

	<form>
		<input type="hidden" name="id" value="${result.rows[0].id }" /><br>
		ACCOUNT: <input type="text" name="account" value="${result.rows[0].account }" /><br>
		PASSWORD: <input type="password" name="passwd" value="${result.rows[0].passwd }" /><br>
		REAL NAME: <input type="text" name="realname" value="${result.rows[0].realname }" /><br>
		<input type="submit" value="UPDATE">
	</form>
</body>
</html>