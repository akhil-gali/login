<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="https://www.thymeleaf.org">
<body bgcolor=#9370DB>

	<center>
		<form:form action="/adminlogin" method="post" modelAttribute="admin">
			<h1>WELCOME TO YOUR ANALYST ACCOUNT</h1>
			<table class="table table-striped">
				<caption>Your Remedies are</caption>
			<table border="1">
				<tr>
				
					<th>remedy_id</th>
					<th>remedy_number</th>
					<th>remedyselect</th>
					<th>user_id</th>
					<th>mobilenumber</th>
					<th>seat_no</th>
					<th>pc_number</th>
					<th>ip_address</th>
					<th>Status</th>
					
				</tr>
				<tr>
					<th>29</th>
					<th>0</th>
					<th>Desktop</th>
					<th>28</th>
					<th></th>
					<th>1</th>
					<th>1</th>
					<th>192.168.0.1</th>
					<th><select path="remedyselect" items="${remedy2}"
							value="${remedy2}" /></th>
					<th><a href="/delete-remedy?id=${remedy.remedy_id}">
										<input type="button" value="RemedyDelete"
											name="RemedyDelete" />
								</a></th>
				</tr>
				
			</table>
				<tr>
					<td><c:forEach items="${Remedyassigned}" var="remedy">
							<tr>
								<td>${remedy.remedy_id}</td>
								<td>${remedy.remedy_number}</td>
								<td>${remedy.remedyselect}</td>
								<td>${remedy.user_id}</td>
								<td>${remedy.mobilenumber}</td>
								<td>${remedy.seat_no}</td>
								<td>${remedy.pc_number}</td>
								<td>${remedy.ip_address}</td>
								<td><input type="text" value="${remedy.status}" items="${remedy3}" /></td>
								<td><a href="/Assign-remedy?id=${remedy.remedy_id}">Remedy
										Solved<input type="button" value="Remedy_Solved"
											name="Remedy_Solved" />
								</a></td>
								<td><a href="/delete-remedy?id=${remedy.remedy_id}">Remedy
										Delete<input type="button" value="RemedyDelete"
											name="RemedyDelete" />
								</a></td>

							</tr>
						</c:forEach></td>
				</tr>
				<tfoot>
					<a href="${contextPath}/login"><input type="button"
						value="Logout" /></a>
				</tfoot>
			</table>
		</form:form>
	</center>
</body>
</html>
