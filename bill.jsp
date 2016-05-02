<%@ taglib prefix="c" uri="coretag" %>
<html>
<title>Bill</title>
<head>
	<script type="text/javascript" language="javascript"> 

function Print(elementId) 
{ 
var printContent = document.getElementById(elementId); 
var windowUrl = 'about:blank'; 
var uniqueName = new Date(); 
var windowName = 'Print' + uniqueName.getTime(); 
var printWindow = window.open(windowUrl, windowName, 'left=50000,top=50000,width=0,height=0'); 

printWindow.document.write(printContent.innerHTML); 
printWindow.document.close(); 
printWindow.focus(); 
printWindow.print(); 
printWindow.close(); 
} 



</script> 
</head>
<body>
<div id="table">
   <div align="center" class="style9"><strong><strong class="style1">
      <label for="CUSTOMER NAME">
      RESTAURANT 24 7
    </strong></div>
   
   
   <label for="date"><div align="center">
     <p><span class="style9"><strong>ADDRESS:R.C DUTT ROAD ,NEAR ALKAPURI,VADODARA<br>    
       PH NO:9999999999 <br>
       EMAIL:RESTAURANT247@GMAIL.COM</strong></span><br>
       ********************************************************************************************************<BR>
       
      <script>
var mydate=new Date()
var year=mydate.getYear()
if (year < 1000) year+=1900
var day=mydate.getDay()
var month=mydate.getMonth()
var daym=mydate.getDate()
if (daym<10) daym="0"+daym
var dayarray=new Array("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
var montharray=new Array("January","February","March","April","May","June","July","August","September","October","Novem ber","December")
document.write("<i>Bill Generated on :"+montharray[month]+" "+daym+", "+year+"</i>")
</script>

   </div>
    
   </label>
   <p align="center">Customer Name : <i>${name}</i></p>
   <p align="center">Customer Address : <i>${address}</i></p>
   <table width="826" height="273" align="center" border="1">
  <tr>
    <th width="307"><div align="center" class="style12">ITEM NAME</div></td>
    <th width="134"><div align="center" class="style12">RATE</div></td>
    <th width="130"><div align="center" class="style12">QUANTITY</div></td>
    <th width="151"><div align="center" class="style12">AMOUNT RS.</div></td>
  </tr>
	<c:forEach items="${bill}" var="item">
	  <tr>
		<td><div align="center">${item.name}</div></td>
		<td><div align="center">${item.price}</div></td>
		<td><div align="center">${item.qty}</div></td>
		<td><div align="center">${item.total}</div></td>
	  </tr>
	</c:forEach>  
  <tr>
    <td></td><td></td><td></td><td height="42" colspan="4"><div align="center"><strong class="style12">TOTAL:<image src="images/rs.gif" height="10px"/>${total}</strong></p>
      </div></td>
  </tr>
</table>
</div>
<p align="center"><a href="javascript:Print('table');"><img src="images/printer.png" width="100" /></a></p>
</body>
</html>