<%@ taglib prefix="c" uri="coretag" %>
<%@ taglib prefix="fmt" uri="formattag" %>
<jsp:useBean id="today" class="java.util.Date" scope="page" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>MANAGER</title>
<meta name="keywords" content="" />
<meta name="Overdose " content="" />
<link href="default.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="wrapper">
	<div id="page"><div class="inner_copy"></div>
		<div id="content">
			<!--<div id="logo">
				<h1></h1>			only for image
			</div>-->
			<div class="post">
				<h2 class="title"><a href="manager">Refresh Orders!</a></h2>
				<meta http-equiv='refresh' content=20;url='manager'>
				<input type="hidden" value="<fmt:formatDate value='${today}' pattern='yyyy-MM-dd' />" name="date" />
				<p class="byline"><small><fmt:formatDate value="${today}" pattern="dd/MM/yyyy" /></small></p>
				<div class="entry">
                	
					<c:forEach items="${neworder}" var="item" >
					<a href="/website/bill?id=${item.key.name}&name=${item.key.emailId}&address=${item.key.address}" target="_blank"><table frame="box" bgcolor="">
						<tr><td colspan="2"><p><b>Name : </b>${item.key.emailId}<br /><b>Address : </b>${item.key.address}</p></td></tr>
						<!--<tr><td colspan="2"><p></p></td></tr>-->
						
						<tr align="center"><th>Item Name</th><th>Quantity</th></tr>
						<c:forEach items="${item.value}" var="data" >
						
							<tr align="center"><td>${data.name}</td><td>${data.qty}</td></tr>
						</c:forEach>
						</table><br />
					</a>	
					</c:forEach>
				</div>
			</div>
			
		</div>
		<div id="sidebar1" class="sidebar">
			<ul>
				<li>
					<h2>Tables Booking </h2>
                    <form action="tablebooking" method="post">
					
						<p>Table Name <select name="t">
							<option value="">---none---</option>
							<c:forEach items="${tablefree}" var="table" >
								
								<option>${table}</option>
							</c:forEach>
						</select></p>
						<p>From : <input type="text" name="time" size="9"/></p>
						<p>Name : <input type="text" name="nm" size="11"/></p>
						<p>Ph. No.:<input type="text" name="no" size="8"/></p>
						<p>${bookedmsg}</p>
						<p><input type="submit" value="Book" /></p>
					</form>
				</li>
				<li><h2>Todays Order</h2></li>
				<div id="scroll">
					<li>
						<ul>
							<c:forEach items="${allorder}" var="al" >
							
								<ul><b>${al.key.emailId}</b></ul>
								<c:forEach items="${al.value}" var="item">
								
									<small><li>${item.name} = ${item.qty}</li></small>
								</c:forEach>
								<br />
							</c:forEach>
						</ul>
					</li>
				</div>
			</ul>
		</div>
		<div id="sidebar2" class="sidebar">
			<ul>
				<li>
					<h2><a href="admin_home.html"><strong><b><u>Home</u></b></strong></a></h2>
				</li>
				<li>
					<h2>Table Status</h2>
					<c:forEach items="${ts}" var="table" >
					<p><strong>${table.name} ==> No. of Chairs: ${table.nof}</strong></p>
					<u><p><small>Name(Mob)</u> : <u>Duration</u> : <u>Status</small></p></u>
					<p><small>${table.cnm}(${table.no}) : ${table.duration} : ${table.status}</small></p>
					<p><small>${table.cnm1}(${table.no1}) : ${table.duration1} : ${table.status1}</small></p>
					</c:forEach>
                    <br />
                    <p><b>Add new table</b></p>
					<form action="table" method="post">
					
						<p>Table Name : <input type="text" name="tbn"  size="10"/></p>
						<p>No. of Chairs : <input type="text" name="no" size="9"/></p>
						<p><input type="submit" value="Add" /></p>
						</form>
					<br />
					<p><b>Delete Table</b></p>
					<p>${tablemsg}</p>
					<form action="deltable" method="post">
					
						<p>Table Name <select name="t">
							<option value="">---none---</option>
							<c:forEach items="${ts}" var="table" >
								<option>${table.name}</option>
							</c:forEach>
						</select></p>
						<p><input type="submit" value="Delete" /></p>
					</form>
				</li>
				
				
			</ul>
		</div>
		<div style="clear:both">&nbsp;</div>
	</div>
	<div id="footer"><div class="fleft"></div><div class="fclear"></div></div>
</div>
</body>
</html>