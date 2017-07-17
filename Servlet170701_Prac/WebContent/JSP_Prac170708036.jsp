<%-- 
	指示元素<%@ 指示類型 屬性="值" %>
	JSP常用三種指示類型: page、include、taglib
--%>

<%--
	運算式元素<%= Java運算式 or 變數 %>，
	裡面不用加上分號， 結果將直接輸出為網頁一部分。
	Java運算式 or 變數會直接被轉譯為out.prin()內的東西，所以無須加上分號
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Brad Big Company</h1>
	<%
		int a=10, b=3;
		int lottery = (int)(Math.random()*49+1);
		out.print(lottery);
	%>
	<hr>
	<%= lottery %>
	
	<br>
	<hr>
	<%=
		Calendar.getInstance().get(Calendar.YEAR)
	%>
		<%--使用Calendar的getInstance()取得一個Calendar的實例 --%>
		<%--如果現在您想知道現在是西元幾年，則可以使用get()方法並指定常數 --%>
	
</body>
</html>