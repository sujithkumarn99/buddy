<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*,java.util.*,com.techm.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Requests</title>
</head>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

.shadowblockmenu-v {
	font: bold 14px Germand;
	width: 250px; /* width of menu */
}

.shadowblockmenu-v ul {
	border: 1px solid #eee;
	padding: 0;
	margin: 0;
	list-style: none;
}

.shadowblockmenu-v ul li {
	margin: 0;
	padding: 0;
}

.shadowblockmenu-v ul li a {
	display: block;
	text-transform: uppercase;
	color: #494949;
	padding: 20px 25px;
	text-decoration: none;
	border-bottom: 1px solid #cacaca;
	border-right: 1px solid #cacaca; /*right border between menu items*/
	-moz-box-shadow: inset 7px 0 10px rgba(114, 114, 114, 0.6);
	/* Add inset shadow to each menu item. First 3 values in (114,114,114, 0.5) specifies rgb values, last specifies opacity */
	-webkit-box-shadow: inset 7px 0 10px rgba(114, 114, 114, 0.6);
	box-shadow: inset 7px 0 10px rgba(114, 114, 114, 0.6);
	text-shadow: 0 -1px 1px #cfcfcf;
	/* CSS text shadow to give text some depth */
	-moz-transition: all 0.2s ease-in-out;
	/* Enable CSS transition between property changes */
	-webkit-transition: all 0.2s ease-in-out;
	-o-transition: all 0.2s ease-in-out;
	-ms-transition: all 0.2s ease-in-out;
	transition: all 0.2s ease-in-out;
}

.shadowblockmenu-v ul li a:hover, .shadowblockmenu-v ul li a.selected {
	color: black;
	-moz-box-shadow: inset 7px 0 10px rgba(216, 89, 39, 0.5), inset 0 0 15px
		rgba(216, 89, 39, 0.6), inset 0 0 20px rgba(216, 89, 39, 0.8);
	/* Add 3 inset shadows to each menu item  */
	-webkit-box-shadow: inset 7px 0 10px rgba(216, 89, 39, 0.5), inset 0 0
		15px rgba(216, 89, 39, 0.6), inset 0 0 20px rgba(216, 89, 39, 0.8);
	box-shadow: inset 7px 0 10px rgba(216, 89, 39, 0.5), inset 0 0 15px
		rgba(216, 89, 39, 0.6), inset 0 0 20px rgba(216, 89, 39, 0.8);
}
</style>


<script>
	function validateForm() {
		var exp1 = document.updateJob.exp1.value;
		var exp2 = document.updateJob.exp2.value;

		if (exp1<exp2) {
			return true;
		} else {
			alert("Enter valid experience");
			return false;
		}
	}
	</script>
	</head>

<body bgcolor="#87CEEB">
	<%
		if (((String) session.getAttribute("session")).equals("true")) {

			session.setAttribute("username", ((String) session.getAttribute("username")));
			session.setAttribute("session", "true");
		}
	%>

	<jsp:include page="spocHomePage.jsp"></jsp:include>
	<%
	Job j= (Job)session.getAttribute("jobDetails");
	%>
		<form action="SpocUpdateJobsController" method="post" name='updateJob' on="validateForm()">
		<h3 align="center">Update Jobs ::</h3>
		<table align="center">
		<tr>
				<td><h2>Jobcode</h2></td>
				<td><label for="jobCode"
			style="color: black; font-family: Helvetica Neue, Helvetica, sans-serif">
			<%out.print(j.getJobcode());
			%></label></td>
			
			</tr>
			
				<tr>
				<td><h2>Spoc Name</h2></td>
				<td><label for="spocName"
			style="color: black; font-family: Helvetica Neue, Helvetica, sans-serif">
			<%out.print(j.getSpocName());
			%></label></td>
			</tr>
				<tr>
				<td><h2>Spoc Email</h2></td>
				<td><label for="spocEmail"
			style="color: black; font-family: Helvetica Neue, Helvetica, sans-serif">
			<%out.print(j.getMailId());
			%></label></td>
			</tr>
			<tr>
				<td><h2>Skill</h2></td>
				<td><label for="skill"
			style="color: black; font-family: Helvetica Neue, Helvetica, sans-serif">
			<%out.print(j.getSkill());
			%></label></td>
				<td><select name="skill" style="width: 150px; height: 34px">
						<option value="" selected>---------- select ---------</option>
						<option value="JAVA">JAVA</option>
						<option value=".NET">.NET</option>
						<option value="SAP">SAP</option>
						<option value="Qlikview">Qlikview</option>

				</select></td>
			</tr>
			<tr>
				<td><h2>YEARS of EXPERIENCE</h2></td>
				<td><label for="exp"
			style="color: black; font-family: Helvetica Neue, Helvetica, sans-serif">
			<%out.print(j.getExp());
			%></label></td>
			<td><input type="number" min='1' max='10' name="exp1" required/> to <input type="number" min='1' max='10' name="exp2"/>years</td>
			</tr>
			<tr>
				<td><h2>LOCATION</h2></td>
				<td><label for="location"
			style="color: black; font-family: Helvetica Neue, Helvetica, sans-serif">
			<%out.print(j.getLocation());
			%></label></td>
			<td><select name="location" style="width: 149px; height: 34px">
						<option value="" selected>---------- select -----------</option>
						<option value="Bangalore">Bangalore</option>
						<option value="Hyderabad">Hyderabad</option>
						<option value="Pune">Pune</option>
						<option value="Mumbai">Mumbai</option>
						<option value="Chennai">Chennai</option>
				</select></td>
			</tr>
		</table>
		<p align="center">
			<input type="hidden" name="jobCode" value="<%=j.getJobcode()%>">
		<button class="button" style="vertical-align:middle"  type="submit"><span>Update</span></button>
		
		</center>

	</form>
</body>
</html>