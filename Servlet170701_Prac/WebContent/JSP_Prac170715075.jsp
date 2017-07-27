<%--
	JSTL SQL標籤
	<sql:transaction>將多個SQL指令 group成一個執行的單元區塊
	
	select last_insert_id();
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:setDataSource
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://127.0.0.1:3306/doubleprac"
	user="root" password="root"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
		<sql:transaction>
		The <sql:transaction> tag is used to 
		group the <sql:query> and <sql:update> tags into transactions. 
	 --%>
	 <sql:transaction>
	 
	 	<sql:update var="updatecount">
	 		insert into member(account, passwd, realname) values(?, ?, ?)
	 		<sql:param>amei</sql:param>
	 		<sql:param>123098</sql:param>
	 		<sql:param>AMei Chang</sql:param>
	 	</sql:update>
	 	
	 	<sql:query var="lastid">
	 		select last_insert_id() as newid
	 		<%-- 
	 			LAST_INSERT_ID()
	 			要取得剛insert進去的某筆資料，但偏偏ID是AUTO_INCREMENT屬性流水號，
				這時就可以用LAST_INSERT_ID()這個方法來取得最後一筆流水號，
				但使用上要注意，一定要接在insert語法後面！
	 		 --%>
	 	</sql:query>
	 	
	 </sql:transaction>
	 
	 <c:if test="${updatecount >= 1 }">
	 	LAST ID: ${lastid.rows[0].newid }<br>
	 </c:if>


</body>
</html>