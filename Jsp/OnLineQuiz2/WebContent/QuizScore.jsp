<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Score</title>
<link href="quiz.css" rel="stylesheet">

</head>
<body>
	<%@include file="Header.jsp"%>

	<section>
	<h2>Score Sheet</h2>
	<div>
		<h2>You have scored ${score} out of ${applicationScope.size}</h2>
		<h2>Percentage is ${score/applicationScope.size *100} %</h2>
	</div>
	<table>
		<tr>
			<th>Q.No</th>
			<th>Question</th>
			<th>Right Answer</th>
			<th>Your Answer</th>
		</tr>
		<tbody>
			<c:forEach items="${requestScope.queslist}" var="q" varStatus="i">
				<tr>
					<td>${i.count}</td>
					<td>${q.qdesc}</td>
					<td>${q.answer}</td>
					<td>
					<td>
					<c:if	test="${requestScope.ansmap[q.qid].answer eq q.answer}">
							<span style="color: blue">${requestScope.ansmap[q.qid].answer}</span>
						</c:if> 
						<c:if test="${requestScope.ansmap[q.qid].answer ne q.answer}">
							<span style="color: red">
								${requestScope.ansmap[q.qid].answer}</span>
						</c:if></td>
					</td>


				</tr>

			</c:forEach>

		</tbody>

	</table>
	</section>

	<%@include file="Footer.jsp"%>

</body>
</html>