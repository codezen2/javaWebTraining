<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>
	<span>Employee Management</span>
	<c:if test="${sessionScope.semp!=null}">
		<div align="right">${sessionScope.semp.empName}
			<a href="logout">logout</a>
		</div>
	</c:if>
	<c:if test="${sessionScope.semp==null}">
		<div align="right">
			<a href="LoginFrm.jsp">login</a>
		</div>
	</c:if>
	<hr />
</header>