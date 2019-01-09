<%@page import="com.techm.util.DbFactory"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spoc | Add New Job</title>
<style>
.Register input[type=submit] {
	width: 260px;
	height: 35px;
	background: #fff;
	border: 1px solid #fff;
	cursor: pointer;
	border-radius: 2px;
	color: #a18d6c; 
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 6px;
	margin-top: 10px;
}

.Register input[type=submit]:hover {
	opacity: 0.8;
}

.Register input[type=submit]:active {
	opacity: 0.6;
}

.Register input[type=submit]:focus {
	outline: none;
}

.content form {
	font: Arial, Helvetica, sans-serif;
	padding: 10px 0;
	width: 80%;
	left:30%;
	float: right;
	margin-top:100px;
}

</style>
</head>
<body bgcolor="#87CEEB">
	<jsp:include page="spocHomePage.jsp"></jsp:include>
	<%
		if (((String) session.getAttribute("session")).equals("true")) {
	%>
	
	<%
		session.setAttribute("username", ((String) session.getAttribute("username")));
		}
	%>
	
	<%!int jobcode; %>
	
	<% 
	Connection con=DbFactory.getConnection();
	Statement stmt= con.createStatement();

    ResultSet rs = stmt.executeQuery("SELECT jobidgeneration.NEXTVAL FROM dual");

    if ( rs!=null && rs.next() ) {
    jobcode = rs.getInt(1);
    rs.close();
    }

    stmt.close(); 
    con.close();
	
	%>
	<div class="content" >
	
	<form action="AddNewJobController" method="post" style="float:top ">
		<h1>
			<p align="center">Add Job Details</p>
		</h1>
		<table align="center">
		<tr>
				<td><h2>Jobcode</h2></td>
				<td><input type="hidden" name="jobCode" value="<%=jobcode %>">
				<label for="jobCode"
			style="color: black; font-family: Helvetica Neue, Helvetica, sans-serif">
			<%out.print(jobcode);
			%></label></td>
			</tr>
			
				<tr>
				<td><h2>Spoc Name</h2></td>
				<td><input type="hidden" name="spocName" value="<%=session.getAttribute("fname")+" "+session.getAttribute("lname") %>">
				<label for="spocName"
			style="color: black; font-family: Helvetica Neue, Helvetica, sans-serif">
			<%out.print(session.getAttribute("fname")+" "+session.getAttribute("lname"));
			%></label></td>
			</tr>
				<tr>
				<td><h2>Spoc Email</h2></td>
				<td><input type="hidden" name="spocEmail" value="<%=session.getAttribute("username") %>">
				<label for="spocEmail"
			style="color: black; font-family: Helvetica Neue, Helvetica, sans-serif">
			<%out.print(session.getAttribute("username"));
			%></label></td>
			</tr>
			<tr>
				<td><h2>Skill</h2></td>
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
				<td><input type="number" min='1' max='10' name="exp1"/> to <input type="number" min='1' max='10' name="exp2"/>years</td>
			</tr>
			<tr>
				<td><h2>LOCATION</h2></td>
				<td><select name="location" style="width: 149px; height: 34px">
						<option value="" selected>---------- select -----------</option>
						<option value="Bangalore">Bangalore</option>
						<option value="Hyderabad">Hyderabad</option>
						<option value="Pune">Pune</option>
						<option value="Mumbai">Mumbai</option>
						<option value="Chennai">Chennai</option>
				</select></td>
		</table>
		<p align="center">
			
			<button type="submit" class="btn btn-info" name="action">SUBMIT</button>
		</p>
	</form>
	</div>
</body>
</html>