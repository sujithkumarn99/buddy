<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee|Home</title>
</head>
<style>


.shadowblockmenu-v{
font: bold 14px Germand;
width: 250px; /* width of menu */
}

.shadowblockmenu-v ul{
border: 1px solid #eee;
padding: 0;
margin: 0;
list-style: none;
}

.shadowblockmenu-v ul li{
margin:0;
padding:0;
}

.shadowblockmenu-v ul li a{
display:block;
text-transform: uppercase;
color: #494949;
padding: 20px 25px;
text-decoration: none;
border-bottom: 1px solid #cacaca;
border-right: 1px solid #cacaca; /*right border between menu items*/
-moz-box-shadow: inset 7px 0 10px rgba(114,114,114, 0.6); /* Add inset shadow to each menu item. First 3 values in (114,114,114, 0.5) specifies rgb values, last specifies opacity */
-webkit-box-shadow: inset 7px 0 10px rgba(114,114,114, 0.6);
box-shadow: inset 7px 0 10px rgba(114,114,114, 0.6);
text-shadow: 0 -1px 1px #cfcfcf; /* CSS text shadow to give text some depth */
-moz-transition: all 0.2s ease-in-out; /* Enable CSS transition between property changes */
-webkit-transition: all 0.2s ease-in-out;
-o-transition: all 0.2s ease-in-out;
-ms-transition: all 0.2s ease-in-out;
transition: all 0.2s ease-in-out;
}

.shadowblockmenu-v ul li a:hover, .shadowblockmenu-v ul li a.selected{
color: black;
-moz-box-shadow: inset 7px 0 10px rgba(216,89,39, 0.5), inset 0 0 15px rgba(216,89,39, 0.6), inset 0 0 20px rgba(216,89,39, 0.8); /* Add 3 inset shadows to each menu item  */
-webkit-box-shadow: inset 7px 0 10px rgba(216,89,39, 0.5), inset 0 0 15px rgba(216,89,39, 0.6), inset 0 0 20px rgba(216,89,39, 0.8);
box-shadow: inset 7px 0 10px rgba(216,89,39, 0.5), inset 0 0 15px rgba(216,89,39, 0.6), inset 0 0 20px rgba(216,89,39, 0.8);
}

</style>
<body bgcolor="cyan">

<%
		if (((String) session.getAttribute("session")).equals("true")) {
	%>
	<%
					session.setAttribute("username",((String) session.getAttribute("username")));
					
						}
				%>
<h1 align="center">welcome Employee !!!</h1>
<h2 align="center"><%out.print(session.getAttribute("fname")+" "+session.getAttribute("lname")); %></h>

<div class="shadowblockmenu-v">
<ul>
<li><a href="employeeHomePage.jsp">HOME</a></li><br>
<li><a href="ViewAvailableJobsController">REFER A BUDDY</a></li><br>
<li><a href="CheckReferralStatus">Check Referral Status</a></li><br>
<li><a href="rewardPoints.jsp">Reward Points</a></li><br>
<li><a href="aboutus.jsp">ABOUT US</a></li><br>
<li><a href="cont.jsp">CONTACT US</a></li><br>
<li><a href="LogoutController">LOGOUT</a></li>
</ul>
</div>

</body>
</html>