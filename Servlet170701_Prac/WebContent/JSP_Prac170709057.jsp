<%--
	XML格式標籤
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- JSP指示元素 import 語法
	<%@ page import="tw.brad.Bean.MemberBean170709"%>
 --%>
<jsp:directive.page import="tw.brad.Bean.MemberBean170709"/>


<%
	MemberBean170709 member = new MemberBean170709();
	member.setId("008"); 
	member.setName("Daniel");
%>	 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- JSP宣告元素 宣告語法
	<%! int i; String name; %>
 --%>
	<jsp:declaration>
		int i; String name;
	</jsp:declaration>
	
	
<%-- JSP Scriptlet元素 邏輯語法
	<% i=10; name="Brad"; %>
 --%>	
	<jsp:scriptlet>
		i=10; name="Brad";
	</jsp:scriptlet>
	
	
<%-- JSP運算式元素 輸出語法
	<%= member %>
 --%>		
	<jsp:expression>
		member
	</jsp:expression>
	<hr>
	
	
<%-- JSP 網頁文字
	我是Brad！I am Brad!
 --%>	
	<jsp:text>		
		我是Brad！I am Brad!
	</jsp:text>
	
</body>
</html>