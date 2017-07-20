<%--
	<jsp:include page="">
	請求另一個JSP頁面處理，並包含進來
	
	使用<jsp:include page="">的網頁與被<jsp:include page="">包括的網頁，將各自產生一個獨立的Servlet。
	可在執行時期，依條件動態地調整想要包括進來的JSP頁面
 --%>

<%
	String x = request.getParameter("x");
	String y = request.getParameter("y");
	
	out.println("Hello, World: " + x + " : " + y);
%>