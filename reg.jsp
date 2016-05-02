<%
	String message = (String)request.getAttribute("error");
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
${hello}
<br />
<div id="templatemo_container">
  <p><br />
  </p><div id="templatemo_header"><img src="images/text.jpg"/></div> 
    <div id="templatemo_menu">
        <ul>
        	<li><a href="index.html"><b>Home</b></a></li>
            <li><a href="login.jsp"><b>Login</b></a>
          </li>
          <li><a href="topdishes.html"><b>Top Dishes</b></a></li>
            <li><a href="menu3.html"><b>Menu</b></a></li>
            <li><a href="#"><b>About-us</b></a></li>
            <li ><a href="#"><b>Contact US</b></a></li>
        </ul>
</div> 
<!-- end of header -->
     <style type="text/css">
        .area
        {
            color: #333399;
        }
        .selectDropdown
        {
            background: #333399;
            color:;
        }
        #terms
        {
            font-family: Verdana, Arial, Helvetica, sans-serif;
            font-size: 11px;
            font-weight: bold;
            color: ;
            padding-bottom: 1px;
        }
        #terms:hover
        {
            font-family: Verdana, Arial, Helvetica, sans-serif;
            font-size: 11px;
            font-weight: bold;
            color: #B70100;
            padding-bottom: 1px;
        }
        .steplink
        {
            font-family: Verdana, Arial, Helvetica, sans-serif;
            font-size: 10px;
            font-weight: bold;
            color: #B70100;
            text-decoration: underline;
        }
        .stepLinkGrey
        {
            color: #ff6f6f; /* #e6b9b8;*/
            font-family: Verdana, Arial, Helvetica, sans-serif;
            font-size: 10px;
            font-weight: normal;
            text-decoration: underline;
        }
        .step
        {
            font-family: Verdana, Arial, Helvetica, sans-serif;
            font-size: 11px;
            font-weight: italic;
            color: #B70100; /* background-color:#FCD452; */
        }
        .customerRegistration
        {
            font-family: Verdana, Arial, Helvetica, sans-serif;
            font-size: 15px;
            font-weight: bold;
            color:;
        }
        .addressTitle
        {
            font-family: Verdana, Arial, Helvetica, sans-serif;
            font-size: 19px;
            font-weight: bold;
            color:; /* background-color:#FCD452; */
        }
        .tableStyle
        {
            border-style: none; /* 	background-color:#FCD452; */
        }
        .captions
        {
            font-family: Tahoma, Verdana, Arial;
            font-size: 13px;
            font-weight:bold;
            color: #000000;
            height: 30px; /*   background-color:#FCD452; */
        }
        
        
       
      
       
    </style>
  

    
</head>
<body background="images/coffee3.jpg"width="100%" height="150">

            
                    <table width="750"  border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                              <td valign="bottom" align="left">
                                &nbsp;<span class="customerRegistration"><font size="20" color="#FFFFFF"></font></span>
                                <br />
                                <br />
                            </td>
                        </tr>
                    </table> 
                    <table border="0" cellspacing="0" cellpadding="0" width="95%" align="center" class="tableStyle">
                                                <tr>
                                                    <td width="1%" class="captions">&nbsp;
                                                        
                                                    </td><%= message %>	                          
                                                    <td align="left" class="addressTitle" colspan="2">
	<legend>
                                                        Customer Details:</legend>
                                                    </td> 
			
                                                    
                                               </tr><tr>
                                                    <td colspan="6" class="captions1">
                                                        <hr style="color: #6633FF" size="2" />
                                                    </td>
                                                </tr><form action="reg" method="POST"> 
                            <tr>
                                                    <td width="1%" class="captions">
                                                        
                                                    </td>
                                                    <td class="captions" align="left" width="10%">	  <font color="black">
                                                        Full name: <span class="area">*</span>
                                                    </td>
                                                    <td align="left"  class="captions">
                                                        <input type='text' name='name'  id='name' maxlength="50" /><br>
                                                    </td>
                                                    <td class="captions"><input type="text" name="status" /></td>
          <td class="captions">
                                                    </td>
                                                    <td class="captions">
                                                    </td>
                                </tr>
<tr>
                                                    <td width="1%" class="captions">
                                                        
                                                    </td>
                                                    <td class="captions" align="left" width="10%">	  <font color="black">
                                                        Date Of Birth:<span class="area">*</span>
                                                    </td>
                                                    <td align="left"  class="captions">
                                                       <select name="dd">
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                    <option>4</option>
                                                    <option>5</option>
                                                    <option>6</option>
                                                    <option>7</option>
                                                    <option>8</option>
                                                    <option>9</option>
                                                    <option>10</option>
                                                    <option>11</option>
                                                    <option>12</option>
                                                   
                                                    <option>13</option>
                                                    <option>14</option>
                                                    <option>15</option>
                                                    <option>16</option>
                                                    <option>17</option>
                                                    <option>18</option>
                                                    <option>19</option>
                                                    <option>20</option>
                                                    <option>21</option>
                                                    <option>22</option>
                                                    <option>23</option>
                                                    <option>24</option>
                                                    <option>25</option>
                                                    <option>26</option>
                                                    <option>27</option>
                                                    <option>28</option>
                                                    <option>29</option>
                                                    <option>30</option>
                                                    <option>31</option>
                                                    </select> 
                                                       <select name="mm"> 
                                                      
                                                    <option>Jan</option>
                                                    <option>Feb</option>
                                                    <option>Mar</option>
                                                    <option>Apr</option>
                                                    <option>May</option>
                                                    <option>Jun</option>
                                                    <option>Jul</option>
                                                    <option>Aug</option>
                                                    <option>Sep</option>
                                                    <option>Oct</option>
                                                    <option>Nov</option>
                                                    <option>Dec</option>
                                                    </select>  
                                                      <select name="yy">
                                                       <option>1995</option>
                                                       <option>1996</option>
                                                       <option>1997</option>
                                                       <option>1998</option>
                                                       <option>1999</option>
                                                       <option>2000</option>
                                                       <option>2001</option>
                                                       <option>2002</option>
                                                       <option>2003</option>
                                                       <option>2004</option>
                                                       <option>2005</option>
                                                       <option>2006</option>
                                                       <option>2007</option>
                                                       <option>2008</option>
                                                       <option>2009</option>
                                                       <option>2010</option>
                                                       <option>2011</option>
                                                       <option>2012</option>
                                                       </select>
                                                     
                                                    </td>
                                                    <td align="left" class="captions">
                                                    
                                                    </td>
                                                    <td class="captions">
                                                    </td>
                                                    <td class="captions">
                                                    </td>
                                </tr>
                                               <tr>
                                                    <td width="1%" class="captions">&nbsp;
                                                        
                                                    </td>
                                                    <td class="captions" align="left" width="10%">
                                                        Email Address: <span class="area">*</span>
                                                    </td>
                                                    <td align="left" class="captions">
                                                        <input type='text' name='email'  id='name' maxlength="50" /><br>
                                                    </td>
                                                    <td class="captions">
                                                    </td>
                                                    <td class="captions">
                                                    </td>
                                                    <td class="captions">
                                                    </td>
                                                </tr>
			<tr>
			
                                                    <td width="1%" class="captions">&nbsp;
                                                        
                                                    </td>
                                                    <td class="captions" align="left" width="10%">
                                                        Residential Address: <span class="area">*</span>
                                                    </td>
                                                    <td align="left" class="captions">
			 
             <textarea name="resi_address" maxlength=50 rows=3 cols=16></textarea><br>
                                                    </td>
			 <td class="captions" align="left" width="10%">
                                                       
                                                    </td>
			<td >
                                                        <br>
			</td>
                                                   </tr>   <tr>
                                                    <td >
                                                        
                                                    </td>
                                                    <td class="captions" align="left" width="20%">
                                                        Your State: <span class="area">*</span>
                                                    </td>
                                                    <td align="left" class="captions">
                                                        <input type='text' name='state' maxlength="50" /><br>
                                                    </td>
			<td class="captions" align="left" width="20%">
Your City:<span class="area">*</span></td>
<td><select name="location"  value="" >
<option selected="selected"  >-Select-</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#000000"><i>-Top Metropolitan Cities-</i></font></option>
<option>Ahmedabad</option> 
<option>Bengaluru/Bangalore</option>
<option>Chandigarh</option>
<option>Chennai</option>
<option>Delhi</option>
<option>Gurgaon</option>
<option>Hyderabad/Secunderabad</option>
<option>Kolkatta</option>
<option>Mumbai</option>
<option>Noida</option>
<option>Pune</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Andhra Pradesh-</i></font></option>
<option>Anantapur</option>
<option>Guntakal</option>
<option>Guntur</option>
<option>Hyderabad/Secunderabad</option>
<option>kakinada</option>
<option>kurnool</option>
<option>Nellore</option>
<option>Nizamabad</option>
<option>Rajahmundry</option>
<option>Tirupati</option>
<option>Vijayawada</option>
<option>Visakhapatnam</option>
<option>Warangal</option>
<option>Andra Pradesh-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Arunachal Pradesh-</i></font></option>
<option>Itanagar</option>
<option>Arunachal Pradesh-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Assam-</i></font></option>
<option>Guwahati</option>
<option>Silchar</option>
<option>Assam-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Bihar-</i></font></option>
<option>Bhagalpur</option>
<option>Patna</option>
<option>Bihar-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Chhattisgarh-</i></font></option>
<option>Bhillai</option>
<option>Bilaspur</option>
<option>Raipur</option>
<option>Chhattisgarh-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Goa-</i></font></option>
<option>Panjim/Panaji</option>
<option>Vasco Da Gama</option>
<option>Goa-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Gujarat-</i></font></option>
<option>Ahmedabad</option>
<option>Anand</option>
<option>Ankleshwar</option>
<option>Bharuch</option>
<option>Bhavnagar</option>
<option>Bhuj</option>
<option>Gandhinagar</option>
<option>Gir</option>
<option>Jamnagar</option>
<option>Kandla</option>
<option>Porbandar</option>
<option>Rajkot</option>
<option>Surat</option>
<option>Vadodara/Baroda</option>
<option>Valsad</option>
<option>Vapi</option>
<option>Gujarat-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Haryana-</i></font></option>
<option>Ambala</option>
<option>Chandigarh</option>
<option>Faridabad</option>
<option>Gurgaon</option>
<option>Hisar</option>
<option>Karnal</option>
<option>Kurukshetra</option>
<option>Panipat</option>
<option>Rohtak</option>
<option>Haryana-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Himachal Pradesh-</i></font></option>
<option>Dalhousie</option>
<option>Dharmasala</option>
<option>Kulu/Manali</option>
<option>Shimla</option>
<option>Himachal Pradesh-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Jammu and Kashmir-</i></font></option>
<option>Jammu</option>
<option>Srinagar</option>
<option>Jammu and Kashmir-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Jharkhand-</i></font></option>
<option>Bokaro</option>
<option>Dhanbad</option>
<option>Jamshedpur</option>
<option>Ranchi</option>
<option>Jharkhand-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Karnataka-</i></font></option>
<option>Bengaluru/Bangalore</option>
<option>Belgaum</option>
<option>Bellary</option>
<option>Bidar</option>
<option>Dharwad</option>
<option>Gulbarga</option>
<option>Hubli</option>
<option>Kolar</option>
<option>Mangalore</option>
<option>Mysoru/Mysore</option>
<option>Karnataka-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Kerala-</i></font></option>
<option>Calicut</option>
<option>Cochin</option>
<option>Ernakulam</option>
<option>Kannur</option>
<option>Kochi</option>
<option>Kollam</option>
<option>Kottayam</option>
<option>Kozhikode</option>
<option>Palakkad</option>
<option>Palghat</option>
<option>Thrissur</option>
<option>Trivandrum</option>
<option>Kerela-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Madhya Pradesh-</i></font></option>
<option>Bhopal</option>
<option>Gwalior</option>
<option>Indore</option>
<option>Jabalpur</option>
<option>Ujjain</option>
<option>Madhya Pradesh-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Maharashtra-</i></font></option>
<option>Ahmednagar</option>
<option>Aurangabad</option>
<option>Jalgaon</option>
<option>Kolhapur</option>
<option>Mumbai</option>
<option>Mumbai Suburbs</option>
<option>Nagpur</option>
<option>Nasik</option>
<option>Navi Mumbai</option>
<option>Pune</option>
<option>Solapur</option>
<option>Maharashtra-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Manipur-</i></font></option>
<option>Imphal</option>
<option>Manipur-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Meghalaya-</i></font></option>
<option>Shillong</option>
<option>Meghalaya-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Mizoram-</i></font></option>
<option>Aizawal</option>
<option>Mizoram-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Nagaland-</i></font></option>
<option>Dimapur</option>
<option>Nagaland-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Orissa-</i></font></option>
<option>Bhubaneshwar</option>
<option>Cuttak</option>
<option>Paradeep</option>
<option>Puri</option>
<option>Rourkela</option>
<option>Orissa-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Punjab-</i></font></option>
<option>Amritsar</option>
<option>Bathinda</option>
<option>Chandigarh</option>
<option>Jalandhar</option>
<option>Ludhiana</option>
<option>Mohali</option>
<option>Pathankot</option>
<option>Patiala</option>
<option>Punjab-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Rajasthan-</i></font></option>
<option>Ajmer</option>
<option>Jaipur</option>
<option>Jaisalmer</option>
<option>Jodhpur</option>
<option>Kota</option>
<option>Udaipur</option>
<option>Rajasthan-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Sikkim-</i></font></option>
<option>Gangtok</option>
<option>Sikkim-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Tamil Nadu-</i></font></option>
<option>Chennai</option>
<option>Coimbatore</option>
<option>Cuddalore</option>
<option>Erode</option>
<option>Hosur</option>
<option>Madurai</option>
<option>Nagerkoil</option>
<option>Ooty</option>
<option>Salem</option>
<option>Thanjavur</option>
<option>Tirunalveli</option>
<option>Trichy</option>
<option>Tuticorin</option>
<option>Vellore</option>
<option>Tamil Nadu-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Tripura-</i></font></option>
<option>Agartala</option>
<option>Tripura-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Union Territories-</i></font></option>
<option>Chandigarh</option>
<option>Dadra & Nagar Haveli-Silvassa</option>
<option>Daman & Diu</option>
<option>Delhi</option>
<option>Pondichery</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Uttar Pradesh-</i></font></option>
<option>Agra</option>
<option>Aligarh</option>
<option>Allahabad</option>
<option>Bareilly</option>
<option>Faizabad</option>
<option>Ghaziabad</option>
<option>Gorakhpur</option>
<option>Kanpur</option>
<option>Lucknow</option>
<option>Mathura</option>
<option>Meerut</option>
<option>Moradabad</option>
<option>Noida</option>
<option>Varanasi/Banaras</option>
<option>Uttar Pradesh-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Uttaranchal-</i></font></option>
<option>Dehradun</option>
<option>Roorkee</option>
<option>Uttaranchal-Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-West Bengal-</i></font></option>
<option>Asansol</option>
<option>Durgapur</option>
<option>Haldia</option>
<option>Kharagpur</option>
<option>Kolkatta</option>
<option>Siliguri</option>
<option>West Bengal - Other</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#FFFFFF"><i>-Other-</i></font></option></td>
                                                    
                                                </tr> 
                                                        
			</td></tr><tr>
                                                    <td width="1%" class="captions"> 
                                                        &nbsp;
                                                    </td>   
                                                    <td class="captions" align="left"> 
                                                        Phone No.<span class="area">*</span> 
                                                    </td><td class="captions"> 
                                                        <input type='text' name='phone' maxlength="13" /><br> 
			</td> 
			<td class="captions" align="left"><font color="black"> 
                                                        Office Phone No. 
                                                    </td><td class="captions"> 
                                                        <input type='text' name='off_phone' maxlength="13" /><br> 
			</td> 
                                                </tr> 
  <tr>   
                                                    <td width="1%" class="captions"> 
                                                        &nbsp; 
                                                    </td> 
                                                    <td class="captions" align="left"><font color="black"> 
                                                    Password:<span class="area">*</span> 
                                                    </td><td class="captions"> 
                                                        <input type="password" name="pwd" maxlength="15" /><br> 
			</td> 
			
                                                </tr>
<tr>
                                                    <td width="1%" class="captions"> 
                                                        &nbsp; 
                                                    </td> 
                                                    <td class="captions" align="left"><font color="black"> 
                                                    Confirm Password:<span class="area">*</span> 
                                                    </td><td class="captions"> 
                                                        <input type="password" name="conf_pwd" maxlength="15" /><br> 
			</td> 
<tr> 
<td>&nbsp;</td> 
<td class="captions" width="20%" ><font color="black">
Select your secret question:<span class="area">*</span></td>
<td><select name="question">
<option selected="selected"  >-Select-</option>
<option disabled="disabled" style="background-color:#3E3E3E"><font color="#000000"><i>-select-</i></font></option>
<option>what is your petname?</option>
<option>your classteacher's name?</option>
</option></td>
                                                    
                                                </tr> 
<tr> 
                                                    <td width="1%" class="captions">&nbsp; 
                                                        
                                                    </td> 
                                                    <td class="captions" align="left" width="10%"> 
                                                      Your answer: <span class="area">*</span> 
                                                    </td> 
                                                    <td align="left" class="captions"> 
                                                        <input type="text" name="ans" maxlength="50" /><br> 
                                                    </td> 
                                                    <td class="captions">
                                                    </td>
                                                    <td class="captions">
                                                    </td>
                                                    <td class="captions">
                                                    </td></tr>
                                                </tr>
		<tr>
  <td width="1%" class="captions"> 
                                                        &nbsp;
                                                    </td>
                                                    <td class="captions" align="left">
                                                   <span class="area"></span>
                                                    </td><td class="captions">
                                                        <input type="submit" value="Submit" name='name'  id='name' maxlength="15" /> &nbsp; &nbsp; &nbsp;  &nbsp;<input type="reset" value="Reset"><br>
			</td> 
</tr> 
</form>
 

                                                
                                                <tr>
                                                    <td colspan="6" class="captions1">
                                                        <hr style="color: #cd3c3c" size="1" />
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="captions" colspan="6" align="left" style="height: 4px;"> 
                                                        <span class="area">&nbsp;* </span>Marked fields are mandatory.
                                                        <br />
                                                        <br />
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;Limited delivery Area Only.<br />
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Please call our HomeDelivery call centre at <b>9999999999</b> for any 
                                                        assistance or query.</td>
                                                </tr>
                                                
                                                <tr>
                                                    <td align="left" class="captions" colspan="6" style="height: 4px;">
                                                        <hr size="1" style="color: #cd3c3c" />
                                                       </td>
                                                </tr>
                                                
                                                  </td>
                                    </tr>
                                </table>
                               
                
           
   
                
           
   

<div id="templatemo_footer">
    
    	<a href="index.html">Home</a> <a href="login.jsp">| login |</a> <a href="topdishes.html">Top Dishes</a>| <a href="#">FAQs</a> | <a href="#">Contact Us</a><br />
        Designed by rahul dhruvraj dhaval arpan<span class="templatemo_footer">|&nbsp;</span></div> 
<!-- end of footer -->
<!--  Free CSS Templates by TemplateMo.com  --> 
</div><!-- end of container -->
</body>
</html>