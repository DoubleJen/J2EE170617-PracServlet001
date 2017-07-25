<!-- 
	洗牌 & 發牌
 -->

<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//洗牌
	boolean[] check = new boolean[52];	//0-51=>false
	int[] poker = new int[52];			//0-51=>0
	int temp;
	for(int i=0; i<52; i++){
		do{
			temp = (int)(Math.random()*52);
		}while(check[temp]);
		
		poker[i] = temp;
		check[temp] = true;
	}
	
	//發牌=>四位玩家=>每家依序拿13張
	int[][] player = new int[4][13];
	for(int i=0; i<poker.length; i++){
		player[i%4][i/4] = poker[i];
	}
	
	//花色&號碼
	String[] suits = {"&spades;", "&hearts;", "&diams;", "&clubs;"};
	String[] values= {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Poker</title>
</head>
<body>
	<h1>洗牌 & 發牌</h1>
	<hr>

	<table border='1' width='100%'>
		<%
			for(int[] cards : player){
				out.print("<tr>");
					Arrays.sort(cards);
					out.print("<td>");
					out.print("玩家");
					out.print("</td>");
					
					for(int card: cards){
						out.print("<td>");
							if((card/13) == 1){
								out.print("<span style='color:red'>"+suits[card/13] + values[card%13] + " " + "</span>");
							}
							else{
								out.print(suits[card/13] + values[card%13] + " ");
							}
							
						out.print("</td>");
					}
				out.print("</tr>");
			}
		%>
	</table>
</body>
</html>