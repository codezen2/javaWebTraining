<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-16">
<title>Login</title>
<link href="sapient.css" rel="stylesheet" />
<link rel="stylesheet" href="catlog.css">
</head>
<body>
	<%@include file="Header.jsp"%>
	<h2>Login Form</h2>
	<div>
		${msg} ${param.msg }
		<form action="login" method="post">
			<fieldset>
				<pre>
	User Id: <input type="text" name="txtid" />
	Password:<input type="password" name="txtpass" />
			 <input type="submit" value="login" />
				</pre>
			</fieldset>
		</form>
	</div>



	<%@include file="Footer.jsp"%>
</body>
</html>