<%--
	JSTL核心標籤
	<c:forEach>
	<c:forTokens>
	<c:import> 
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] names = {"Brad", "Tony", "Tim", "Mike"};
		pageContext.setAttribute("names", names);
		pageContext.setAttribute("step", 1);
	%>
	<h1>Use forEach<h1>
	
	<table border="1" width="100%">
		<tr>
			<th>INDEX</th>
			<th>NAME</th>
			<th>COUNT</th>
			<th>FIRST</th>
			<th>LAST</th>
		</tr>
		
		<%--
			<c:forEach>
			items 		=> Information to loop over
			var   		=> Name of the variable to expose the current item
			varStatus	=> Name of the variable to expose the loop status
						   varStatus屬性: https://my.oschina.net/xsh1208/blog/179841	
			begin		=> Element to start with (0 = first item, 1 = second item, ...)
			end			=> Element to end with (0 = first item, 1 = second item, ...)
			step		=> Process every step items
		 --%>
		 <c:forEach items="${names }" var="name" varStatus="status"
		 			begin="0" end="3" step="${step }">
		 		<tr>
		 			<td>${status.index }</td>
		 			<td>${name }</td>
		 			<td>${status.count }</td>
		 			<td>${status.first }</td>
		 			<td>${status.last }</td>
		 				<!-- 
		 					status.index => 原陣列索引值 
		 					status.count => 尋訪後從1開始計
		 					status.first => 尋訪後第一筆為true
		 					status.last  => 尋訪後最後一筆為true
	 					-->
		 		</tr>	
		 </c:forEach>
	 </table>
	 <hr>
	 <hr>
	 
	 
	 <%--
	 	<c:forTokens>
	 	has similar attributes as that of the <c:forEach> tag 
	 	except one additional attribute delims.
	 	delims(分隔符) => Characters to use as delimiters	
	  --%>
	 <% 
	 	String line="1,brad,male,0912-123456,2000-01-02,台中市西屯區";
		pageContext.setAttribute("line", line);
     %>
     <h1>Use forTokens<h1>
     
     <c:forTokens items="${line }" delims="," var="field" varStatus="status">
     	${status.count } :  ${field }<br>
     </c:forTokens>
     <hr>
     <hr>
     
     
     <%--
     	<c:import> 
     	provides all functionalities of the <include> action 
     	but also allows for the inclusion of absolute URLs.
      --%>
	 <c:import url="JSP_Prac170709068.jsp" var="data2">
	 	<c:param name="x" value="1"/>
	 	<c:param name="y" value="2"/>
	 </c:import>
	 ${data2 }<br>
	 <c:out value="${data2 }" />
	 <hr>
	 <hr>
	 
	 
	 <c:import url="http://www.tutorialspoint.com" var="tutorial" />
     <!-- import後為原始碼 -->
     <c:out value="${tutorial }" />
     
     <!-- import後原始碼轉型成網頁 -->
     <%
     	String tutorial = (String)pageContext.getAttribute("tutorial");
     	out.print(tutorial);
     %>
	 
	 
	 
</body>
</html>