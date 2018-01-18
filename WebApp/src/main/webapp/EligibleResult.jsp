<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  dummy uri represents as as refrence to jstl apssi-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DATA</title>
<style type="text/css">
.pass
{
color:blue;
}
.fail
{
color:red;
}

</style>
</head>
<body bgcolor="cyan">
	<c:if test="${(param.txtage>=20 && param.txtage<=22) &&( param.txtqual=='be' || param.txtqual=='btech')}">
			<c:set var="result" value="<span class='pass'>Eligible for java fresher.</span>" />
	</c:if>
	<c:if test="${(param.txtage<20 || param.txtage>22) || (param.txtqual!='be' && param.txtqual!='btech')}">
			<c:set var="result" value="<span class='fail'>Not Eligible for java fresher.</span>" />
	</c:if>
	<h1 align="center">Eligbile Results</h1>

	<hr />
	<h2 align="center">Are u Eligible to for Java Fresher</h2>
	<div align="center">
		${initParam.headstr} <a href="${initParam.headstr}">Home</a>
	</div>
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
				<td>Result</td>
				<td>${pageScope.result}</td>
			</tr>
			<tr>
				<td>Result using result directly</td>
				<td>${result}</td>
			</tr>
		</table>

	<hr />

</body>
</html>