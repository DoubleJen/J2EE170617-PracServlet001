<%--
	JSTL SQL標籤
	<sql:setDataSource driver="" url="" user="" password=""/>
	<sql:query>
		select * from member where account=?
		<sql:param>XXXX</sql:param>
	</sql:query> 
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
	<!-- 載入驅動程式 -->
	<sql:setDataSource 
		driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://127.0.0.1:3306/doubleprac"
		user="root" password="root"/>
		
	<!-- sql語法1 -->
	<sql:query var="result1" sql="select * from member" />
	<c:forEach items="${result1.rows }" var="row1">
							  <!-- rows=>屬性 -->
		${row1.id } : ${row1.account } : ${row1.passwd } : ${row1.realname }<br>
	</c:forEach>
	<hr>
	<hr>
	
	
	<!-- sql語法2 -->
	<sql:query var="result2">
		select * from member
	</sql:query>	
	<c:forEach items="${result2.rows }" var="row2">
							  <!-- rows=>屬性 -->
		${row2.id } : ${row2.account } : ${row2.passwd } : ${row2.realname }<br>
	</c:forEach>
	<hr>
	<hr>
	
	
	<!-- 帶參數sql語法 -->
	<sql:query var="result3">
		select * from member where account=?
		<sql:param>double</sql:param>
	</sql:query>
	<c:forEach items="${result3.rows }" var="row3">
							  <!-- rows=>屬性 -->
		${row3.id } : ${row3.account } : ${row3.passwd } : ${row3.realname }<br>
	</c:forEach>
	<hr>
	<hr>
	
	<!-- rows類似陣列物件 -->		
	${result1.rows[0].account }	
</body>
</html>