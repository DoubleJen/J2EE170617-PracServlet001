<%--
	國際化(i18n) v.s. 語系
	
	JSTL格式標籤
	<fmt:setBundle/> & <fmt:message/>
	<fmt:setTimeZone/> & <fmt:formatDate/>
	<fmt:formatNumber/>
 --%>

<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		國際化(Internationalization, i18n) v.s. 語系
		https://kknews.cc/zh-tw/education/43eyvv.html
	-->
	<%
		Locale locale = request.getLocale();
	%>
	Locale: <%= locale.getCountry() %><br>			<!-- 返回國家/地區碼的英文大寫，或 ISO 3166 2-letter 格式的區域 -->
	Locale: <%= locale.getDisplayCountry() %><br>	<!-- 返回要顯示給用戶的國家名稱 -->
	Locale: <%= locale.getLanguage() %><br>			<!-- 返回語言碼的英文小寫，或ISO 639 格式的區域 -->
	Locale: <%= locale.getDisplayLanguage() %><br>  <!-- 返回要給用戶看的語言名稱 -->
	Locale: <%= locale.getISO3Country() %><br>		<!-- 返回國家名稱的3字母縮寫 -->
	Locale: <%= locale.getISO3Language() %><br>		<!-- 返回語言名稱的3字母縮寫 -->
	<hr>
	<hr>
	
	
	<%--
		<fmt:setBundle/> & <fmt:message/>
		The <fmt:setBundle> tag is used to load a resource bundle 
		and stores it in the named scoped variable 
		or the bundle configuration variable.
		
		The <fmt:message> tag maps key to localized message 
		and performs parametric replacement.
	 --%>
	<fmt:setBundle basename="res"/>
	<fmt:message key="Hello"/>, <fmt:message key="World"/>
	<br>
	<fmt:message key="CompanyName"/>
	<hr>
	<hr>
	
	
	<%--
		時區 & 日期時間
		<fmt:setTimeZone/> & <fmt:formatDate/>
	 --%>
	<%
		Date now = new Date();
		out.print("NOW IS: " + now);
		pageContext.setAttribute("now", now);
	%>
	<br>
	
	亞洲台北1:
	<fmt:setTimeZone value="Asia/Taipei"/>
	<fmt:formatDate value="${now }" type="both" dateStyle="long" timeStyle="short"/>
	<br>
	亞洲台北2:
	<fmt:setTimeZone value="Asia/Taipei"/>
	<fmt:formatDate value="${now }" type="date" dateStyle="short"/>
	<br>
	亞洲台北3:
	<fmt:setTimeZone value="Asia/Taipei"/>
	<fmt:formatDate value="${now }" type="time" timeStyle="medium"/>
	<br>
	
	坎帕拉:
	<fmt:setTimeZone value="Africa/Kampala"/>
	<fmt:formatDate value="${now }" type="both" dateStyle="short" timeStyle="long"/>
	<br>
	<hr>
	<hr>
	
	
	<%--
		數字
	 --%>
	預　　設: <fmt:formatNumber value="${123456.789 }" /><br>
	無千分位: <fmt:formatNumber value="${123456.789 }" groupingUsed="false"/><br>
	最大四位整數: <fmt:formatNumber value="${123456.789 }" maxIntegerDigits="4"/><br>		
	最小八位整數&無千分位: <fmt:formatNumber value="${123456.789 }" minIntegerDigits="8" groupingUsed="false"/><br>
	小數點最多一位: <fmt:formatNumber value="${123456.789 }" maxFractionDigits="1"/><br>	
	<hr>
	<hr>
	
	
	<%--
		貨幣
	 --%>
	美金: <fmt:formatNumber value="${123456.78 }" type="currency" currencyCode="USD"/><br>	
</body>
</html>