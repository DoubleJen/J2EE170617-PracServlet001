<%--
	053=>054
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="tw.brad.Bean.*" %>    
<%
 	MemberBean170709 member2 = new MemberBean170709("002", "Tony");
	application.setAttribute("member", member2);
	
	member2.setId("003");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Welcome, <%= member2 %>
	<%
		member2.m1();
	%>
</body>
</html>