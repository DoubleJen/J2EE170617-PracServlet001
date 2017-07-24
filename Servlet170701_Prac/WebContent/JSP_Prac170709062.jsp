<%-- 
	使用EL取得屬性值 
	EL運算子
--%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isELIgnored="false" %>
	<!-- isELIgnored屬性 => 預設為false，如果設定為true，則不轉譯EL -->

<%
	String[] names = {"Brad", "Tony", "Double"};
	request.setAttribute("usernames", names);
	
	LinkedList<String> list = new LinkedList<>();
	list.add("AAA");
	list.add("BBB");
	list.add("CCC");
	request.setAttribute("list", list);
	
 	HashMap<String, String> map = new HashMap<>();
 	map.put("name", "Tim");
 	map.put("account", "tim");
 	map.put("passwd", "123456");
 	request.setAttribute("map", map);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 使用EL取得屬性值 -->	
	USERNAMES: ${usernames[0] }<br>
	LIST: ${list[param.i] }<br>
	ACCOUNT: ${map["account"] }<br>
	<hr>
	<hr>

<!-- EL運算子 -->	
	A: ${10 + 3 / 7 }<br>
	B: ${(param.i=="1")? "YES" : "NO"}<br> 
	C: ${1 > 3 }<br>
	D: ${"a" < "b" }<br>
		<!-- ASCII編碼中，"a"為97，"b"為98 -->
	E: ${"12" > 3 }	
	 
	
		
	
	
</body>
</html>