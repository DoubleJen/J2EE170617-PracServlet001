<%--
	<jsp:useBean id="member" class="tw.brad.Bean.MemberBean170709"/>
	<jsp:setProperty name="member" property="name" value="Kevin2" />
	<jsp:getProperty name="member" property="name" />
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="member" class="tw.brad.Bean.MemberBean170709"/>
<jsp:setProperty name="member" property="id" value="005" />
<jsp:setProperty name="member" property="name" value="Kevin2" />
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Welcome,
	<jsp:getProperty name="member" property="name" />

</body>
</html>