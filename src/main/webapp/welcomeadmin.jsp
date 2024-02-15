<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="https://www.thymeleaf.org">
<body bgcolor=#9370DB>
	<h1>${Remedysend}</h1>
	<center>
		<form:form action="/adminlogin" method="post" modelAttribute="admin">
			<h1>WELCOME TO YOUR ACCOUNT</h1>
			<table border="1">
				<caption>Your Remedies are</caption>
				<tr>
					<th>remedy_id</th>
					<th>remedy_number</th>
					<th>remedyselect</th>
					<th>user_id</th>
					<th>mobilenumber</th>
					<th>seat_no</th>
					<th>pc_number</th>
					<th>ip_address</th>
					<th>Remedy Status</th>
				</tr>

				<tr>
					<td><c:forEach items="${adminremedy}" var="remedy">
							<tr>
								<td><input type="text" value="${remedy.remedy_id}" /></td>
								<td><input type="text" value="${remedy.remedy_number}" /></td>
								<td><input type="text" value="${remedy.remedyselect}" /></td>
								<td><input type="text" value="${remedy.user_id}" /></td>
								<td><input type="text" value="${remedy.mobilenumber}" /></td>
								<td><input type="text" value="${remedy.seat_no}" /></td>
								<td><input type="text" value="${remedy.pc_number}" /></td>
								<td><input type="text" value="${remedy.ip_address}" /></td>
								<td><select type="text" value="${remedy.status}"
									items="${remedy3}" /></td>
								<td><a href="/Assign-remedy?id=${remedy.remedy_id}&status="${remedy.status}"><input
										type="button" value="Assign" name="Assign" /></a></td>
								<td><a href="/delete-remedy?id=${remedy.remedy_id}&status="${remedy.status}"><input
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
