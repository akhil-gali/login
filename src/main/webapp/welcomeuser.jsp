<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User Login</title>
</head>
<body bgcolor=#9370DB>
	<center>
		<form:form action="welcomeuser" method="post" modelAttribute="login">
			<h1>WELCOME TO YOUR USER LOGIN ACCOUNT</h1>
			<table>
				<tr>
					<th><h2>welcome to the Remedy Creation page</h2></th>
				</tr>
				<tr>
					<form:hidden path="username" value="${user}" />
				</tr>
				<tr>
					<form:hidden path="user_id" value="${user_id}" />
				</tr>

				<tr>
					<td>Remedy selection</td>
					<td><form:select path="remedyselect" items="${remedy2}"
							value="${remedy2}" /></td>
				</tr>
				<tr>
					<td>Problem Statement</td>
					<td><form:textarea path="statement" type="text" /></td>
				</tr>
				<tr>
					<td>Mobile Number</td>
					<td><form:input path="mobilenumber" type="text" /></td>
					<td><form:errors path="mobilenumber" /></td>
				</tr>
				<tr>
					<td>Seat Number</td>
					<td><form:input path="seat_no" type="text" /></td>
					<td><form:errors path="seat_no" /></td>
				</tr>
				<tr>
					<td>PC Number</td>
					<td><form:input path="pc_number" type="text" /></td>
					<td><form:errors path="pc_number" /></td>
				</tr>
				<tr>
					<td>IP Address</td>
					<td><form:input path="ip_address" type="text" /></td>
					<td><form:errors path="ip_address" /></td>
				</tr>
				<tr>
					<td>Remedy status</td>
					<td><form:select path="status" items="${remedy3}"
							value="${remedy3}" /></td>
				</tr>
				<tr>
					<td><input type="submit" /></td>
					<td><h2>${remedy1}</h2></td>
				</tr>
				<tr>
					<td><a href="${contextPath}/login"><input type="button"
							value="Logout" /></a></td>
				</tr>
				
			</table>
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
					<th>Open</th>
					
				</tr>
			</table>
			

		</form:form>
	</center>
</body>
</html>