<%@page import="com.techm.util.DbFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee | Refer a buddy</title>

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
	left: 30%;
	float: right;
}

.button {
	display: inline-block;
	border-radius: 4px;
	background-color: #f4511e;
	border: none;
	color: #FFFFFF;
	text-align: center;
	font-size: 28px;
	padding: 10px;
	width: 100px;
	transition: all 0.5s;
	cursor: pointer;
	margin: 5px;
}

.button span {
	cursor: pointer;
	display: inline-block;
	position: relative;
	transition: 0.5s;
}

.button span:after {
	content: '\00bb';
	position: absolute;
	opacity: 0;
	top: 0;
	right: -20px;
	transition: 0.5s;
}

.button:hover span {
	padding-right: 25px;
}

.button:hover span:after {
	opacity: 1;
	right: 0;
}
</style>

<script>
	function validateForm() {
		var mob_no = document.forms["buddyForm"]["buddyMobileNo"].value;
		var expr = /^\d{10}$/; //10 DIGIT MOBILE NO.
		if (mob_no.match(expr)) {
			return true;
		} else {
			alert("Not a valid Phone Number");
			return false;
		}
	}
</script>
</head>
<body bgcolor="#87CEEB">
	<jsp:include page="employeeHomePage.jsp"></jsp:include>
	<%
		if (((String) session.getAttribute("session")).equals("true")) {
	%>
	<%
		session.setAttribute("username", ((String) session.getAttribute("username")));

		}
	%>
	<%!int referralid;%>
	<%
		Connection con = DbFactory.getConnection();
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT referralidgeneration.NEXTVAL FROM dual");

		if (rs != null && rs.next()) {
			referralid = rs.getInt(1);
			rs.close();
		}

		stmt.close();
		con.close();
	%>


	<div class="content">

		<form action="ReferABuddyController" method="post"
			name="buddyForm">
			<h1>
				<p align="center">Refer A Buddy</p>
			</h1>
			<table align="center">
<%String jobcode=request.getParameter("selected");
System.out.print(jobcode);
%>
				<tr>
					<td><h2>Jobcode</h2></td>
					<td><input type="hidden" name="jobCode" value="<%=request.getParameter("selected")%>">
					<label
						for="jobCode"
						style="color: black; font-family: Helvetica Neue, Helvetica, sans-serif">
							<%
								out.print(request.getParameter("selected"));
							%>
					</label></td>
				</tr>


				<tr>
					<td><h2>Referral Id</h2></td>
					<td><input type="hidden" name="referralid" value="<%=referralid %>"> <label
						for="referralid"
						style="color: black; font-family: Helvetica Neue, Helvetica, sans-serif">
					</label> <%
							out.print(referralid);
						%></td>
				</tr>

				<tr>
					<td><h2>Buddy Name</h2></td>
					<td><input type="text" name="buddyName"></td>
				</tr>
				<tr>
					<td><h2>Buddy Mobile no.</h2></td>
					<td><input type="text" name="buddyMobileNo"></td>
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
					<td><h2>Years of Experience</h2></td>
					<td><input type="number" min='1' max='10' name="exp1" /> to <input
						type="number" min='1' max='10' name="exp2" />years</td>
				</tr>
				<tr>

					</select>
					</td>
			</table>
			<p align="center">
			<input type="hidden" name='username' value="<%=session.getAttribute("username") %>">
				<button class="button" type="submit" name="action"
					class="btn btn-info" style="vertical-align: middle">
					<span>Submit</span>
			</p>
		</form>
	</div>
</body>
</html>