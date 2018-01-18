<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-16">
<title>Main Page</title>
<link rel="stylesheet" href="sapient.css">
</head>
<body>
	<%@include file="Header.jsp"%>
	<c:if test="${sessionScope.semp==null}">
		<jsp:forward page="LoginFrm.jsp">
			<jsp:param value="Please Login" name="msg" />
		</jsp:forward>
	</c:if>
	<section id="home">
		<h2>Home Page</h2>
		<div>${msg}</div>

		<div>
			<nav>
				<table>
					<tr>
						<td><a href="viewall">View All Employees</a></td>
						<td><a href="DeptView.jsp">View Departments</a></td>
						<td><a href="AddEmpFrm.jsp">Add Employee</a></td>
					</tr>
				</table>
			</nav>

		</div>

	</section>



	<%@include file="Footer.jsp"%>
</body>
</html>