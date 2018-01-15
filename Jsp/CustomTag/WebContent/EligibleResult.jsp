<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sapient.com" prefix="sap"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DATA</title>
</head>

<body bgcolor="cyan">
	<h2 align="center">Are u Eligible to for Java Fresher</h2>

	<table align="center" cellpadding="10" bgcolor="#e3e3e3">
		<tr>
			<td>Name</td>
			<td>${param.txtname}</td>
		</tr>
		<tr>
			<td>Age</td>
			<td>${param.txtage}</td>
		</tr>
		<tr>
			<td>Qualification</td>
			<td>${param.txtqual}</td>
		</tr>
		<tr>
			<td>Eligible/Not Eligible</td>
			<td><sap:check age="${param.txtage}" var="res">
				${res}</sap:check></td>
		</tr>
	</table>

	<hr />

</body>
</html>