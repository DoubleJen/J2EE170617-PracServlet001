<%--
	JSTL核心標籤
	<c:out> 
	<c:set>
	<c:remove>
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 使用核心標籤庫 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="member" class="tw.brad.Bean.MemberBean170709"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
		 <c:out> 
		 similar to the way <%= %>
	 --%>
	<c:out value="${'Hello World' } " /><br>
	<c:out value="${x }" default="no value" /><br>
	<c:out value="${y }" default="no value" /><br>
	<hr>
	
	<%--
		<c:set>
		Sets the result of an expression evaluation in a 'scope'
		The <c:set> tag is JSTL-friendly version of the setProperty action.
	 --%>
	<c:set var="var1" value="456" scope="page"/>
	Var1: ${var1 }<br>
	
	<c:set var="var2">
		${var1 +100 }
		<% out.print("Math OK!!!"); %>
	</c:set>
	Var2: ${var2 }<br>
	<hr>
	
	<c:set target="${member }" property="id">009</c:set>
	<c:set target="${member }" property="name">John</c:set>
	${member }<br>
	<hr>
	
	<%--
		<c:remove>
		The <c:remove> tag removes a variable from either a specified scope 
		or the first scope where the variable is found (if no scope is specified). 
	 --%>
	<c:remove var="var1"/>
	Var1 removed: ${var1 }<br>
	Var1 removed:
	<c:out value="${var1 }" default="var1 has been removed" />
	
	
</body>
</html>