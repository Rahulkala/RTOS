<%
	String message = (String)request.getAttribute("message");
    if (message == null) { message = ""; }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>welcome</title>
<meta name="keywords" content="tea and meal, free css templates, green color, white background, CSS, XHTML" />
<meta name="description" content="Tea and Meal - Green Color, White Background, Free CSS Template provided by templatemo.com" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<br />
<div id="templatemo_container">
  <p><br />
  </p>
	   <div id="templatemo_header"><img src="images/text.jpg"/></div> 
<!-- end of header -->
    
    <div id="templatemo_menu">
        <ul>
        	<li><a href="index.html"><b>Home</b></a></li>
            <li class="current"><a href="login.jsp"><b>Login</b></a>
          </li>
          <li><a href="topdishes.html"><b>Top Dishes</b></a></li>
            <li><a href="menu3.jsp"><b>Menu</b></a></li>
            <li><a href="#"><b>About-us</b></a></li>
            <li ><a href="#"><b>Contact US</b></a></li>
        </ul>
</div> <!-- end of menu -->
    
   
<table width="100" height="50" border="0" align="center">
<tr>
<td colspan="10"  style="background-color:">
</td>
</tr>
<tr>
<td width="400" height="200" ;" align="center">
<p>&nbsp;</p>
<p>&nbsp;</p>
<form action="login" method="post">
<p><font color="blue">USERNAME:
  <input type="text" name="user"/>
  </br>
  PASSWORD:  
  <input type="password" name="pwd"/>
  </br>
  <br/>
    <input type="checkbox"name="member"value="arpan"/>
  Remember me</p>
<input type="submit" value="SUBMIT" /><br>
<a href="reg.html">Create Account<br>
<a href="forgotpassword2.html">Forgot password<br>
</a>
</form>
</td>
<td width="100">
</td>
</tr>
</table> 
<h1 align="center"><%= message %></h1>
</body>

<div id="templatemo_footer">
    
    	<a href="index.html">Home</a> <a href="login.jsp">| login |</a> <a href="topdishes.html">Top Dishes</a>| <a href="#">FAQs</a> | <a href="#">Contact Us</a><br />
        Designed by rahul dhruvraj dhaval arpan<span class="templatemo_footer">|&nbsp;</span></div> 
<!-- end of footer -->
<!--  Free CSS Templates by TemplateMo.com  --> 
</div> <!-- end of container -->
</body>
</html>