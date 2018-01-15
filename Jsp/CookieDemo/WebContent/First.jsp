<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>First page</h1>
<hr/>
${cookie.cname.value } and role is ${cookie.crole.value }
<hr/>
<a href="Second.jsp">second</a>
<hr/>
<table cellpadding="10">
    <% for(Cookie c: request.getCookies()){
    	  out.println("<tr><td>" + c.getName() +"</td>");
    	  out.println("<td>" + c.getValue() +"</td></tr>");
    }
    
    %>

</table>


</body>
</html>