<%@ taglib prefix="c" uri="coretag" %>
<%
	String message = (String)request.getAttribute("message");
    if (message == null) { message = ""; }
%>
<%@ page import="com.rtos.*,java.util.*" %>
<%
	UserInfo info = (UserInfo)session.getAttribute("info");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Confirm Order</title>
<meta name="keywords" content="tea and meal, free css templates, green color, white background, CSS, XHTML" />
<meta name="description" content="Tea and Meal - Green Color, White Background, Free CSS Template provided by templatemo.com" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<br />
<div id="templatemo_container">
  <p><br />
  </p>
	<div id="templatemo_header"><marquee direction="left"  behavior="slide">
	        <br />
      <font face="Geneva, Arial, Helvetica, sans-serif" pointsize="500px" size="5">WELCOME <%= info.getName() %></font></marquee>
	</div> 

	<div id="templatemo_menu">
        <ul></ul>
	</div>	
    <div id="templatemo_top_dishes">

		  <!--<div class="userinfo_box"> -->
    <div id="shift">
	<form action="cart" method="get">
		<table>
		<tr bgcolor="#669900">
			<th>Name</th>
			<th>Quantity</th>
			<th>Price/Quantity</th>
			<th>Total</th>
		</tr>
		<c:forEach items="${food}" var="entry">
		
			<tr>
			<td><c:out value="${entry.name}" /></td>
			<td><input type="text" name="${entry.name}" value="${entry.qty}" size="2" /></td>
			<td>${entry.price}</td>
			<td>${entry.total}</td>
			</tr>
		</c:forEach>
		</table>
		<input type="submit" value="Order" />
		</form>

	  <p><%= message %></p>
      </div>
    	<h1>&nbsp;</h1>
     <!--   </div> -->
      
  </div> <!-- end of top dishes -->
   

<div id="templatemo_footer">
    
    	
        Designed by rahul dhruvraj dhaval arpan<span class="templatemo_footer">|&nbsp;</span></div> 
</div>
</body>
</html>