<%-- 
	042 produce Error => 043 isErrorPage
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- import屬性 -->   
<%@ page import="java.util.*, java.sql.*" %>
	<!-- import屬性 => 可在同一個import屬性中，使用逗號分隔數個import內容 -->
<%@ page import="java.io.*" %>	

<!-- session buffer autoFlust屬性 -->
<%@ page session="true" buffer="8kb" autoFlush="true" %>
	<!-- session屬性 => 設定是否在轉譯後的Servlet原始碼中建立HttpSession物件，預設為true -->
	<!-- buffer屬性 => 設定至客戶端的輸出串流緩衝區大小，預設為8kb -->
	<!-- autoFlust屬性 => 設定輸出串流是否自動出清，預設為true。設定為false時，如果滿了卻還沒呼叫flush()，將產生例外 -->

<!-- info屬性 -->
<%@ page info="這是JSP info屬性測試" %>
	<!-- info屬性 => 設定目前JSP頁面的基本資訊 ，使用getServletInfo()取得-->

<!-- errorPage屬性 -->
<%@ page errorPage="JSP_Prac170709043.jsp" %>
	<!-- errorPage屬性 => JSP執行錯誤產生例外時，該轉發的頁面(瀏覽器顯示)。 -->	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= getServletInfo() %>
	<br>
	<%
		int a=10, b=0;
		out.print(a/b);
	%>
</body>
</html>