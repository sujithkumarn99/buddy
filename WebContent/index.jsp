<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<script type="text/javascript">
	history.pushState(null, null, 'index.jsp');
	window.addEventListener('popstate', function(event) {
		history.pushState(null, null, 'index.jsp');
	});
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simply5 Solutions!</title>
<style>
@import url(http://fonts.googleapis.com/css?family=Exo:100,200,400);

@import
	url(http://fonts.googleapis.com/css?family=Source+Sans+Pro:700,400,300)
	;

html, body {
	margin: 0;
	padding: 0;
	background: #fff;
	color: #fff;
	font-family: Arial;
	font-size: 12px;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	`
}

label {
	color: #555;
	display: inline-block;
	margin-left: 18px;
	padding-top: 10px;
	font-size: 18px;
}

.body {
	position: absolute;
	width: auto;
	height: auto;
	background-image: "images/HomeMain.jpg";
	background-size: cover;
	-webkit-filter: blur(15px);
	z-index: 0;
}

.grad {
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, rgba(0, 0
		, 0, 0)), color-stop(100%, rgba(0, 0, 0, 0.65)));
	/* Chrome,Safari4+ */
	z-index: 1;
	opacity: 0.7;
}

.header {
	position: absolute;
	top: 270px;
	left: 333px;
	z-index: 2;
}

.header div {
	float: left;
	color: pink;
	font-family: 'Exo', sans-serif;
	font-size: 54px;
	font-weight: 500;
}

.header div span {
	color: white;
}

.login {
	position: absolute;
	top: 240px;
	left: 789px;
	height: 30px;
	width: 350px;
	padding: 4px;
	z-index: 2;
	font-size: xx-large;
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
}

.login input[type=text] {
	width: 250px;
	height: 30px;
	background: transparent;
	border: 1px solid rgba(255, 255, 255, 0.6);
	border-radius: 2px;
	color: white;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
}

.login input[type=password] {
	width: 250px;
	height: 30px;
	background: transparent;
	border: 1px solid rgba(255, 255, 255, 0.6);
	border-radius: 2px;
	color: white;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
	margin-top: 10px;
}

.login input[type=submit] {
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

.login input[type=submit]:hover {
	opacity: 0.8;
}

.login input[type=submit]:active {
	opacity: 0.6;
}

.Register input[type=submit]:hover {
	opacity: 0.8;
}

.Register input[type=submit]:active {
	opacity: 0.6;
}

.login input[type=text]:focus {
	outline: none;
	border: 1px solid rgba(255, 255, 255, 0.9);
}

.status input[type=radio]:focus {
	outline: none;
	border: 1px solid rgba(255, 255, 255, 0.9);
	height: 300px;
	width: 300px;
}

.login input[type=password]:focus {
	outline: none;
	border: 1px solid rgba(255, 255, 255, 0.9);
}

.login input[type=submit]:focus {
	outline: none;
}

.Register input[type=submit]:focus {
	outline: none;
}

::-webkit-input-placeholder {
	color: rgba(255, 255, 255, 0.6);
}

::-moz-input-placeholder {
	color: rgba(255, 255, 255, 0.6);
}
</style>


<script src="js/prefixfree.min.js"></script>


</head>
<body>
	<img src="images/img.jpg" height="646px" width="100%">
	<div class="header">
		<div>
			Simply5<span>Solutions !</span>
		</div>
	</div>
	<br>
	<div class="login">

		<%
			if (request.getParameter("loginmsg") != null) {
		%>
		<label for="loginmsg"
			style="color: black; font-family: Helvetica Neue, Helvetica, sans-serif">Sorry,email
			or password error</label>
		<%
			}
		%>
		<form action="LoginController" method="post">
			<input type="text" placeholder="username" name="username" required><br>
			<input type="password" placeholder="password" name="password" required><br> 
			<input type="submit" value="Login"><br>
		</form>
	</div>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>


</body>
</html>