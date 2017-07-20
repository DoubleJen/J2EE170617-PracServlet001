<%--
	<jsp:include page="">
	請求另一個JSP頁面處理，並包含進來
	
	使用<jsp:include page="">的網頁與被<jsp:include page="">包括的網頁，將各自產生一個獨立的Servlet。
	可在執行時期，依條件動態地調整想要包括進來的JSP頁面
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Brad Big Company</h1>
	<hr>
	
	<jsp:include page="JSP_Prac170709048.jsp">
		<jsp:param value="123" name="x"/>
		<jsp:param value="456" name="y"/>
	</jsp:include>
	
</body>
</html>