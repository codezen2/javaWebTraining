<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sapient.com" prefix="sap" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sapient</title>
</head>
<body>
<sap:display>Sapient Technologies</sap:display>
<form action="EligibleResult.jsp">
		<table align="center" cellpadding="10" bgcolor="#e3e3e3">
			<tr>
				<td>Name</td>
				<td><input type="text" name="txtname" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="txtage" /></td>
			</tr>
			<tr>
				<td>Qualification</td>
				<td><select id="txtqual" name="txtqual">
						<option value="">--select qual--</option>
						<option value="mca">mca</option>
						<option value="bca">bca</option>
						<option value="bsc">bsc</option>
						<option value="pg">pg</option>
						<option value="btech">btech</option>
						<option value="be">be</option>
				</select></td>
			</tr>
			<tr>
				<td>Result</td>
				<td><span id="span1"></span></td>
			</tr>
			<tr>
				<td><input type="submit" value="check" /></td>
			</tr>
		</table>

	</form>

</body>
</html>