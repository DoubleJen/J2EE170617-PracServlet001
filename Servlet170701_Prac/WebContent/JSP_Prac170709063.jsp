<%--
	EL隱含物件(屬性範圍相關)
	pageScope、requestScope、sessionScope、applicationScope
	=>僅代表作用範圍
	=>不等同於JSP隱含物件pageContext、request、session、application 
	
	自訂EL函式
 --%>
<%@page import="tw.brad.Bean.Bradutil170709"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//setAttribute in Scope
		//1. page
		pageContext.setAttribute("name", "<h3>Brad Big Company</h3>");
	
		//2. request
		request.setAttribute("name", "request");
		
		//3. session
		session.setAttribute("name", "session");
		
		//4. application
		application.setAttribute("name", "app");
	%>
	
	PAGE: ${pageScope.name }<br>
	REQUEST: ${requestScope.name }<br>
	SESSION: ${sessionScope.name }<br>
	APPLICATION: ${applicationScope.name }<br>
	<hr>
	<hr>
	
	<!--
		自訂EL函式
			1. 撰寫public類別
			2. 想要呼叫的方法須為public static
	 -->
	1.m1(): <%= Bradutil170709.m1("TONY") %><br>
	2.m1(): ${Bradutil170709.m1(param.name)}<br>
	

</body>
</html>