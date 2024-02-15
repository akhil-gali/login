<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<title>Registration page</title>
<meta charset="utf-8">
<title>Create an account</title>
<style>
.login-page {
  width: 360px;
  padding: 8% 0 0;
  margin: auto;
}
.farm {
  position: relative;
  z-index: 1;
  background: #ffffff;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 35px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}
.farm input {
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}
.farm button {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: #4caf50;
  width: 100%;
  border: 0;
  padding: 15px;
  color: #ffffff;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.farm button:hover,
.farm button:active,
.farm button:focus {
  background: #43a047;
}
.farm .message {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}
.farm .message a {
  color: #4caf50;
  text-decoration: none;
}
.farm .register-form {
  display: none;
}
.container {
  position: relative;
  z-index: 1;
  max-width: 300px;
  margin: 0 auto;
}
.container:before,
.container:after {
  content: "";
  display: block;
  clear: both;
}
.container .info {
  margin: 50px auto;
  text-align: center;
}
.container .info h1 {
  margin: 0 0 15px;
  padding: 0;
  font-size: 36px;
  font-weight: 300;
  color: #1a1a1a;
}
.container .info span {
  color: #4d4d4d;
  font-size: 12px;
}
.container .info span a {
  color: #000000;
  text-decoration: none;
}
.container .info span .fa {
  color: #ef3b3a;
}
body {
  background: #76b852; /* fallback for old browsers */
  background: -webkit-linear-gradient(right, #76b852, #8dc26f);
  background: -moz-linear-gradient(right, #76b852, #8dc26f);
  background: -o-linear-gradient(right, #76b852, #8dc26f);
  background: linear-gradient(to left, #76b852, #8dc26f);
  font-family: "Roboto", sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
</style>
</head>

<body>
	<script type="text/javascript">
		function disable(role) {
			if (role == "SupportAnalyst") {
				document.getElementById("level").disabled=false;
			}
		}
	</script>
	<div class="login-page">
	  <div class="farm">
		<div class="container">
		<center>
			<form:form action="registration" method="post" modelAttribute="login"
				class="form-signin">
				<h1 class="form-signin-heading">welcome to the Registration
					page</h1>
				<h2 class="form-signin-heading">Create your account</h2>
				<table>
					<tr>
						<td>UserName(*)</td>
						<td><form:input path="username" type="text"
								class="form-control" placeholder="Username" /></td>
						<td><form:errors path="username" class="has-error" /></td>
					</tr>
					<tr>
						<td>Password(*)</td>
						<td><form:input path="password" type="password"
								class="form-control" placeholder="Password" /></td>
						<td><form:errors path="password" class="has-error" /></td>
					</tr>
					<tr>
						<td>Firstname(*)</td>
						<td><form:input path="Firstname" type="text"
								class="form-control" placeholder="Firstname" /></td>
						<td><form:errors path="Firstname" class="has-error" /></td>
					<tr>
						<td>Lastname(*)</td>
						<td><form:input path="Lastname" type="text"
								class="form-control" placeholder="Lastname" /></td>
						<td><form:errors path="Lastname" class="has-error" /></td>
					</tr>
					<tr>
						<td>Designation</td>
						<td><form:input path="Designation" type="text"
								class="form-control" placeholder="Designation" /></td>
					</tr>
					<tr>
						<td>Contactnumber(*)</td>
						<td><form:input path="Contactnumber" type="text"
								class="form-control" placeholder="Contactnumber" /></td>
						<td><form:errors path="Contactnumber" class="has-error" /></td>
					</tr>
					<tr>
						<td>EmailId(*)</td>
						<td><form:input path="EmailId" type="text"
								class="form-control" placeholder="EmailId@mail.com" /></td>
						<td><form:errors path="EmailId" class="has-error" /></td>
					</tr>

					<tr>
						<td>Dob(*)</td>
						<td><form:input type="date" path="Dob" class="form-control" /></td>
					</tr>
					<tr>
						<td>Gender(*)</td>
						<td><form:select path="Gender" class="form-control"
								items="${gender}" /></td>
					</tr>
					<tr>
						<td>role(*)</td>
						<td><form:select path="role" class="form-control"
								items="${role}" id="role" onchange="disable(this.value)" /></td>
					</tr>
					<tr>
						<td>Supportlevel(*)</td>
						<td><form:select path="Supportlevel" class="form-control"
								items="${Supportlevel}" id="level" disabled="true"/></td>
					</tr>


					<tr>
						<td><input type="submit" value="Register"
							class="btn btn-lg btn-primary btn-block" /></a></td>
					</tr>
					<tr>
						<td><a href="${contextPath}/login"><input type="button"
								value="Log in" class="btn btn-lg btn-primary btn-block" /></a></td>
					</tr>

				</table>
			</form:form>

		</center>
	</div>
	</div>
	</div>
</body>
</html>