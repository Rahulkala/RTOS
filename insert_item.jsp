<%@ taglib prefix="c" uri="coretag" %>
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
  <p><br /><br />
  </p>
<div id="templatemo_header"><img src="images/text.jpg"/></div> 
<!-- end of header -->
    
    <div id="templatemo_menu">
        <ul>
        	<li><a href="admin_home.html"><b>Home</b></a></li>
			<li><a href="insert_category.jsp"><b>Insert Category</b></a></li>
            <li class="current"><a href="insert_item.jsp"><b>Insert Item</b></a></li>
            <li><a href="update_item.jsp"><b>Update Item</b></a></li>
            <li><a href="delete_item.jsp"><b>Delete Item</b></a></li>
            <li><a href="#"><b>Change Password</b></a></li>
            <li><a href="logout"><b>Logout</b></a></li>
        </ul>
</div> <!-- end of menu -->
    
    <div id="templatemo_top_dishes">

    	<h1>Insert New Item</h1>
<form action="item" method="post">
<p><font color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Item Name:
  <label for="userid"><input type="text" name="item_name"/>
  </p><br  />
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Category: &nbsp;&nbsp; <select name=cat>
														<c:forEach items="${category}" var="entry">
															<option value="${entry}">${entry}</option>
														</c:forEach>
														</select><br /><br />
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Price:  
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="price"/><br /><br />
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Description:  
  <input type="text" name="descr"/>
  </br>
  <br/>
   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Insert" /><br>
</form>
<h2>${msg}</h2>
<div id="templatemo_footer">
    
    	<a href="index.html">Home</a> <a href="login.jsp">| login |</a> <a href="topdishes.html">Top Dishes</a>| <a href="#">FAQs</a> | <a href="#">Contact Us</a><br />
        Designed by rahul dhruvraj dhaval arpan<span class="templatemo_footer">|&nbsp;</span></div> 
<!-- end of footer -->
<!--  Free CSS Templates by TemplateMo.com  --> 
</div><!-- end of container -->
</body>
</html>