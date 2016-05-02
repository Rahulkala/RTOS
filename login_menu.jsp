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
<br />
<div id="templatemo_header"><img src="images/text.jpg"/></div> 
<!-- end of header -->
    
    <div id="templatemo_menu">
        <ul>
        	<li><a href="afterlog.jsp"><b>Home</b></a></li>
            <li class="current"><a href="login_menu.jsp"><b>Menu</b></a>
          </li>
          <li><a href="changepwd1.jsp"><b>Change Password</b></a></li>
            <li><a href="profile.jsp"><b>Change Profile</b></a></li>
            <li><a href="#"><b>Contact US</b></a></li>
            <li ><a href="logout"><b>Logout</b></a></li>
        </ul>
</div> <!-- end of menu -->
<script language="javascript">
    function getItem(id)
    {
        var itm = false;
        if(document.getElementById)
            itm = document.getElementById(id);
        else if(document.all)
            itm = document.all[id];
        else if(document.layers)
            itm = document.layers[id];

        return itm;
    }
    function toggleItem(id)
    {
        itm = getItem(id);
      
        if(!itm)
            return false;

        if(itm.style.display == 'none')
            itm.style.display = '';
        else
            itm.style.display = 'none';

        return false;
    }
    </script>
<style>
body
{
	background-color: white;
	background-size:cover;
	background-image:url(images/.jpg);
	width:98%;
	height:100%;
}
#header
{
	text-align: center;
	width:96%;
	margin-left:2%;
	margin-right:2%;
	margin-top:1.5%;
	margin-bottom:1.5%;
}
a:link 
{
	color: #FFFFFF;
	text-decoration: none;
}
a:visited 
{
	color: #FFFFFF;
	text-decoration: none;
}
a:hover 
{
	color: #FFFFFF;
	text-decoration: none;
}
a:active 
{
	color: #FFFFFF;
	text-decoration: none;
}
h2
{	font:Juice ITC;
	text-align: center;
}
table 
{
	width: 90%;	
	margin-left:5%;
	margin-right:5%;
	margin-bottom: 1em;	
	border: 3px solid white;
}
caption 
{
	opacity: 0;
	margin:0;
	height: 0;
}
tr 
{
	background: rgb(251, 174, 44);
}

tr:nth-child(even) 
{
	background: rgb(249,228,130);
}
th 
{
	background: rgb(89,118,31);
	color: white;
	padding: .6em 1em .3em;
	text-align: left;
}

th, td 
{
	vertical-align: middle;
}	
td 
{
	padding: .4em 1em;
}
</style>
</head>
<body>
<div id=header><h1>&nbsp;</h1>
</div><br>
<div>
<table>
	<c:forEach items="${menu}" var="entry">
  <tbody>
  
    <tr>
      <th colspan=4><a href="#" onClick="toggleItem('${entry.key}')">
        <h2>${entry.key}</h2>
      </a></th>
    </tr>
  </tbody>
  <form action="order" method="post"><!--  OrderServlet.java-->  
  <tbody id=${entry.key} style="display:none;">
    <tr>
      <!--<th width="18%" rowspan=2 scope="col">DISH NO.</th>-->
      <th width="45%" rowspan=2 scope="col">&nbsp;&nbsp;&nbsp;ITEM</th>
      <th width="13%" rowspan=2 scope="col">PRICE<br>
      </th>
      <!--<th width="21%" rowspan=2 scope="col">QUANTITY</th>-->
    </tr>
	<form method="">
	<c:forEach items="${entry.value}" var="e1">	
	<tr> </tr>
    <tr>
      <!--<td>1)--><td><input type="checkbox" name="${e1.key}" />&nbsp;&nbsp;&nbsp;${e1.key}</td>
	  
		<td>${e1.value}/-</td>
		
	  
      <!--<td><input type="text" name="" width="2" /><br></td>-->
    </tr>
	</c:forEach>
	</c:forEach>
</table>
</tbody>
<input type="submit" value="SUBMIT" />
</form>
<div id="templatemo_footer">
    
    	<a href="afterlog.jsp">Home</a> | <a href="login_menu.html">Menu</a> | <a href="#">Order Now</a> | <a href="#">FAQs</a> | <a href="#">Contact Us</a><br />
        Designed by rahul dhruvraj dhaval arpan<span class="templatemo_footer">&nbsp;</span></div> 
<!-- end of footer -->
<!--  Free CSS Templates by TemplateMo.com  --> 
</div><!-- end of container -->
</body>
</html>