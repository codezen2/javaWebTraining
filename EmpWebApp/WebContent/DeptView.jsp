<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-16">
<title>Departments</title>
<link rel="stylesheet" href="catlog.css">
<link rel="stylesheet" href="sapient.css">
<style type="text/css">
section>div {
	width: 50%;
	padding: 20px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<%@include file="Header.jsp"%>
	<c:if test="${sessionScope.semp==null}">
		<jsp:forward page="LoginFrm.jsp">
			<jsp:param value="Please Login" name="msg" />
		</jsp:forward>
	</c:if>
	<div id="home">
		<nav>
			<table>
				<tr>
					<td><a href="viewall">View All Employees</a></td>
					<td><a href="Main.jsp">Home</a></td>
				</tr>
			</table>
		</nav>
	</div>

	<section id="catlog">
		<h2>View Department</h2>

		<div>
			<form action="viewbydept">

				Choose Department <select name="txtdid">
					<c:forEach items="${applicationScope.dlist}" var="d">
						<option value="${d.deptId}">${d.deptName}</option>
					</c:forEach>
				</select> <input type="submit" value="view" />

			</form>
		</div>
	</section>


	<%@include file="Footer.jsp"%>
</body>
</html>