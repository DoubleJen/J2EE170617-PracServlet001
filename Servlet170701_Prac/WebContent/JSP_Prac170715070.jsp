<%--
	SQL & errorPage in JSP 
 --%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//載入驅動程式
		Class.forName("com.mysql.jdbc.Driver");
	
		//建立連線
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doubleprac", "root", "root");
		
		//建立Statement物件
		Statement stmt = conn.createStatement();
		
		//執行sql語法
		String sql="insert into member(account, passwd, realname) values('daniel', '44456', 'Daniel')";
		stmt.execute(sql);
		
		//故意產生例外導致errorPage
		out.print(10/0);
	%>
</body>
</html>