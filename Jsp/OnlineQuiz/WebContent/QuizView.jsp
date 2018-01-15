<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="quiz.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<%@include file="Header.jsp" %>
<section>
<h2>Play Quiz</h2>
<div>
<form action="quiz" method="post">
${question.qdesc}<br/><br/>
<input type="radio" name = "ques" value="${question.opta}"/>${question.opta}<br/>
<input type="radio" name = "ques" value="${question.optb}"/>${question.optb}<br/>
<input type="radio" name = "ques" value="${question.optc}"/>${question.optc}<br/>
<div align="center">
<input type="submit" name = "btn"  value="next"/>
<input type="submit" name = "btn"  value="prev"/>
</div>
</form>
</div>
</section>
<%@include file="Footer.jsp" %>
</body>
</html>
