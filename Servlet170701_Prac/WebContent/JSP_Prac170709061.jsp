<%--
	060=>061
	EL隱含物件pageContext
	透過點運算子之後接上xxx名稱，表示呼叫getXxx()方法
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
	<%
		HttpServletRequest req = (HttpServletRequest)pageContext.getRequest();
	
		String method = req.getMethod();
		String querystring = req.getQueryString();
								//getQueryString() => 如果用post的話，在 URL之後根本就沒有Query String，故傳回null
		String ip = req.getRemoteAddr();
		String user = req.getParameter("user");
		String passwd = req.getParameter("passwd");
	%>
	
	METHOD: <%= method %><br>
	QUERY: <%= querystring %><br>
	IP: <%= ip %><br>
	USER: <%= user %><br> 
	PASSWORD: <%= passwd %>
	<hr>
	<hr>
	
	METHOD: ${pageContext.request.method }<br>
	QUERY: ${pageContext.request.queryString }<br>
	IP: ${pageContext.request.remoteAddr }
</body>
</html>