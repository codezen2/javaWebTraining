<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-16">
<style type="text/css">
table div {
	background-color: black;
	position: absolute;
	box-shadow: 5px 5px 5px black;
	border: 2px solid black;
}

.editbtn {
	background: #FFEB3B;
	box-shadow: 3px 3px 3px #a20808;
}
</style>
<title>View All</title>
<link rel="stylesheet" href="catlog.css">
<link rel="stylesheet" href="sapient.css">
<script type="text/javascript">
	function display(id) {
		document.getElementById(id).style.display = 'block';
	}
	function hidePart(id) {
		document.getElementById(id).style.display = 'none';
	}
</script>
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
					<td><a href="Main.jsp">Home</a></td>
					<td><a href="DeptView.jsp">View Departments</a></td>
				</tr>
			</table>
		</nav>
	</div>
	<section id="catlog">
		<h2>Employee List</h2>
		<div align="center">
			<div>${msg}</div>
			<h3>Page:${pgno}</h3>
		</div>
		<table>
			<thead>
				<tr>
					<th>Image</th>
					<th>Emp Id</th>
					<th>Emp Name</th>
					<th>Salary</th>
					<th>Date of Joining</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${emplist}" var="e">
					<tr>
						<td><img src="viewimg?iname=${e.img}" /></td>
						<td>${e.empId}</td>
						<td>${e.empName}</td>
						<td>${e.sal}</td>
						<td>${e.doj}</td>
						<td><input class="editbtn" type="button"
							onclick="display('${e.empId}')" value="Update Salary">
							<div id="${e.empId}" style="display: none;">
								<h5 align="center"
									style="padding: 0px; margin: 8px; background: black; color: white;">Update
									Salary</h5>
								<form action="update">
									<table>
										<tr>
											<td>Emp Id</td>
											<td>${e.empId}</td>
										</tr>
										<tr>
											<td>Sal</td>
											<td><input type="text" name="txtsal" /><br /> <input
												type="hidden" name="hideid" value="${e.empId}" /> <input
												type="hidden" name="pgid" value="${pgno}" /><input
												type="hidden" name="requri"
												value="${pageContext.request.queryString}" /></td>
										</tr>
										<tr>
											<td><input type="button"
												onclick="hidePart('${e.empId}')" value="Cancel" /></td>
											<td><input type="submit" name="Update" /></td>
										</tr>
									</table>

								</form>
							</div></td>
					</tr>

				</c:forEach>
				<tr>
					<td colspan="3"><c:if test="${pgno>1}">
							<a href="viewall?pg=${pgno-1}">Prev</a>
						</c:if></td>
					<td colspan="3" align="right"><c:if
							test="${pgno < applicationScope.esize}">
							<a href="viewall?pg=${pgno+1}">Next</a>
						</c:if></td>

				</tr>
			</tbody>
		</table>


	</section>



	<%@include file="Footer.jsp"%>
</body>
</html>