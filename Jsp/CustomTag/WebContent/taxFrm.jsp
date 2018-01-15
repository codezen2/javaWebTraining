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
	<hr/>
		<div align="center">
			${initParam.headstr} <a href="${initParam.headstr}">Home</a>
	</div>
	<form action="TaxResult.jsp">
		<table style="margin: 0 auto;" cellpadding="10" bgcolor="wheat"  >
		<tr>
			<td>Employee Name</td>
			<td><input type="text" name="txtname"/></td>
		</tr>
			<tr>
			<td>Employee Income</td>
			<td><input type="number" name="txtincome"/></td>
		</tr>
			<tr>
			<td colspan="2" align="center"><input type="submit" value="Calc Tax"/></td>
		</tr>
		</table>
	</form>
	
	
</body>
</html>