<%--
	JSTL核心標籤
	<c:catch> exception
	<c:if> no else if
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
		exception
		The <c:catch> tag catches any Throwable 
		that occurs in its body and optionally exposes it.
	 --%>
	 <c:catch var="errorMesg">
	 	<%
	 		String num = request.getParameter("num");
	 		int n = Integer.parseInt(num);
	 		out.print(n);
	 	%>
	 </c:catch>
	 Hello, OK<br>
	 The exception is: ${errorMesg }
	 <hr>
	 
	 <%--
	 	<c:if>
	 	JSTL 無else if
	  --%>
	 <c:if test='${param.name == "admin" }' >
	 	I am Admin :D
	 </c:if>
	 <c:if test='${param.name != "admin" }' var="result">
	 	I am User :X
	 </c:if>
	=> ${result }		 
</body>
</html>