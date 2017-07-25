<!-- 
	乘法表
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Multiply Table</title>
</head>
<body>
	<h1>乘法表</h1>
	<hr>
	
	<table border='1' width='100%'>
		<%
		for(int k=0; k<3; k++){
		out.print("<tr>");
			for(int j=2; j<=5; j++){
				int newj = j + k*4;
				if((j+k)%2 == 0){out.print("<td bgcolor='yellow'>");}
				else{out.print("<td bgcolor='white'>");}
				for(int i=1; i<=9; i++){
					int r = newj * i;
					out.print(newj + " x " + i + " = " + r +"<br>");
				}
				out.print("</td>");
			}
		out.print("<tr>");
		}
		%>
		
		
	</table>
	

</body>
</html>