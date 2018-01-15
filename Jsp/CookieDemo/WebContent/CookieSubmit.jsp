<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name = request.getParameter("txtname");
 String role = request.getParameter("txtrole");
 Cookie c1 = new Cookie("cname", name);
 c1.setMaxAge(10* 60);
 Cookie c2 = new Cookie("crole", role);
 response.addCookie(c1);
 response.addCookie(c2);
 %>
 <a href="First.jsp">Go first</a>
 <a href="Second.jsp">Go second</a>
</body>
</html>