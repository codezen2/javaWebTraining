<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Registration</title>
<link href="sapient.css" rel="stylesheet" />
<link rel="stylesheet" href="catlog.css">

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
					<td><a href="DeptView.jsp">View Departments</a></td>
					<td><a href="AddEmpFrm.jsp">Add Employee</a></td>
				</tr>
			</table>
		</nav>
	</div>
	<section id="">
		<h2>ADD Employee</h2>

		<form action="add" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="txtid" /></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="txtname" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="txtpass" /></td>
				</tr>
				<tr>
					<td>Salary</td>
					<td><input type="text" name="txtsal" /></td>
				</tr>

				<tr>
					<td>Dept</td>
					<td><select name="txtdept">
							<c:forEach items="${applicationScope.dlist}" var="d">
								<option value="${d.deptId}">${d.deptName}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Upload your image</td>
					<td><input type="file" name="txtfile" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" /></td>
				</tr>
			</table>
		</form>




	</section>
	<%@include file="Footer.jsp"%>
</body>
</html>