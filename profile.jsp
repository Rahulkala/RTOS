<%@ page import="com.rtos.*,java.util.*" %>
<%
	UserInfo info = (UserInfo)session.getAttribute("info");
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
	<div id="templatemo_header"><marquee direction="left"  behavior="slide">
	        <br />
      <font face="Geneva, Arial, Helvetica, sans-serif" pointsize="500px" size="5">WELCOME <%= info.getName() %></font></marquee>
	</div> 
<!-- end of header -->
    
    <div id="templatemo_menu">
        <ul>
        	<li><a href="afterlog.jsp"><b>Home</b></a></li>
            <li><a href="login_menu.jsp"><b>Menu</b></a></li>
          <li><a href="changepwd1.jsp"><b>Change Password</b></a></li>
            <li class="current"><a href="profile.jsp"><b>Change Profile</b></a></li>
            <li><a href="#"><b>Contact-us</b></a></li>
            <li ><a href="logout"><b>Logout</b></a></li>
        </ul>
</div> <!-- end of menu -->
    
    <div id="templatemo_top_dishes">

		  <!--<div class="userinfo_box"> -->
    <div id="shift">
	<form action="changeinfo" method="post">
    <table >
          <tr bgcolor="#669900">
          <td colspan="15">
          <b><font size="+1" > NAME :</font></b></td><td colspan="15"><input type="text" name="nm" value="<%= info.getName() %>" /></td></tr>
           <tr>
           <td  colspan="15">
           <b><font size="+1">ADDRESS :</font></b></td>
           <td><input type="text" name="address" value="  <%= info.getAddress() %>" /></td></tr>
           <tr>
           <td  colspan="15">
           <b><font size="+1">CONTACT NO. :</font></b></td><td><input type="text" name="phone" value="<%= info.getstrPhone() %>" /></td></tr>
      </table>
	  <input type="submit" value="Change" />
	  </form>
      </div>
    	<h1>&nbsp;</h1>
     <!--   </div> -->
      
  </div> <!-- end of top dishes -->
    <div id="templatemo_content">
    	<span class="top"></span>
<div id="templatemo_innter_content">
            
                <div id="templatemo_content_left">
                    <h1>Welcome to o<img src="images/genimage.jpg" alt="image" width="303" height="222" />ur Restaurant,</h1>
                    <p>Greetings..welcome to our online order website..We have a varied range of dishes we offer to our dear customers.</p>
                    <p>we have been serving some lovely delicacies..hopefully you enjoy our services and spend some lovely memories with friends and family munching our food.</p>
                  <div style="clear: both; padding: 30px 0 20px 0;"></div>
                    
                  <div class="cleaner_with_height">&nbsp;</div>
                
                </div> <!-- end of content left -->
                
                <div id="templatemo_content_right">
                    <h1>What's new?</h1>
                  <div class="right_column_section">
	                    <h2>Special meal for you</h2>
                        <p><img src="images/barbeque.jpg" alt="image" width="204" height="165" /></p>
                        <p>Barbecue : our special smocky vegies..marinated with cheese and butter is an ideal party starters..enjoy the evening with our lovely barbecues..!!</p>
                  </div>
                
                </div> <!-- end of content right -->
        		<div class="cleaner">&nbsp;</div>
        </div>   
        <div class="cleaner" style="background: #fff;">&nbsp;</div> 	
    </div>


<div id="templatemo_footer">
    
    	<a href="afterlog.jsp">Home</a> <a href="login_menu.html">| Menu |</a> <a href="#">Order Now</a>| <a href="#">FAQs</a> | <a href="#">Contact Us</a><br />
        Designed by rahul dhruvraj dhaval arpan<span class="templatemo_footer">|&nbsp;</span></div> 
<!-- end of footer -->
<!--  Free CSS Templates by TemplateMo.com  --> 
</div><!-- end of container -->
</body>
</html>