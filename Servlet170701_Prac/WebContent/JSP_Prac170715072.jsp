<%--
	JSTL SQL標籤
	<sql:update>
		insert into member(account, passwd, realname) values(?, ?, ?)
		<sql:param>XXXX</sql:param>
		<sql:param>XXXX</sql:param>
		<sql:param>XXXX</sql:param>
	</sql:update>	
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource
		driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://127.0.0.1:3306/doubleprac"
		user="root" password="root"/>
		
	<sql:update var="count">
		insert into member(account, passwd, realname) values(?, ?, ?)
		<sql:param>peter</sql:param>
		<sql:param>6666</sql:param>
		<sql:param>Peter</sql:param>
	</sql:update>	
	${count }
</body>
</html>