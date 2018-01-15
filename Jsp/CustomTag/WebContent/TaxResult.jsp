<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sapient.com" prefix="sap"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sap:display>TAX CALCULATION</sap:display>
	<table style="margin: 0 auto;" cellpadding="10" bgcolor="wheat">
		<tr>
			<td>Employee Name</td>
			<td>${param.txtname}</td>
		</tr>
		<tr>
			<td>Employee Income</td>
			<td><span style="color: grey;">Rs. </span>${param.txtincome}</td>
		</tr>
		<tr>
			<td>Employee Tax</td>
			<td><span style="color: grey;">Rs. </span>
			<sap:tax var="res" income="${param.txtincome}">${res}</sap:tax>			
			</td>
		</tr>
	</table>
</body>
</html>