<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="https://www.thymeleaf.org">
<body bgcolor="navyblue">
	<h1>${Remedysend}</h1>
	<center>
		<form:form action="/Assign-remedy" method="get" modelAttribute="analyst">
			<table border="1">
				<caption>Your SupportAnalysts are</caption>
				<tr>
					<th>SupportAnalyst_id</th>
					<th>username</th>
					<th>Supportlevel</th>
				</tr>

				<tr>
					<td><c:forEach items="${analyst}" var="analyst1">
							<tr>
								<td><input type="text" value="${analyst1.supportAnalyst_id}" /></td>
								<td><input type="text" value="${analyst1.username}" /></td>
								<td><input type="text" value="${analyst1.supportlevel}" /></td>
								<td><a href="/assign-analyst?SupportAnalyst_id=${analyst1.supportAnalyst_id}&status=${status}&remedy_id=${id}"><input
										type="button" value="Assign" name="Assign" /></a></td>
								<td><a href="/delete-analyst?id=${analyst1.supportAnalyst_id}"><input
										type="button" value="Delete" name="Delete" /></a></td>

							</tr>
						</c:forEach></td>
				</tr>
			</table>
			<a href="${contextPath}/adminlogin"><input type="button"
				value="Logout" /></a>
		</form:form>
	</center>
</body>
</html>
