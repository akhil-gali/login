<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Todo's for ${name}</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body bgcolor="lightgreen">



<h1>Please Register</h1>
	<form>
		<label for="firstName">First name:</label>
		 <input type="text" id="firstName" name="firstName" ><br> 
			<label for="lastName">Last name:</label> 
			<input type="text" id="lastName" name="lastName" ><br> 
			<label for="DOB">Date Of Birth:</label> 
			<input type="date" id="DOB" name="DOB"><br>
			 
			<label for="gender">Gender:</label> 
			<select id="gender" name="gender">
			<option value="male">Male</option>
			<option value="female">Female</option>
			<option value="Other">Other</option>
		</select><br>
		
		 <label for="contactNo">Contact Number</label>
		  <input type="tel" id="contactNo" name="contactNo" placeholder="1234-567-890" 
		                            pattern="[0-9]{4}-[0-9]{3}-[0-9]{3}" maxlength="10"><br>
			<label for="id">Patient Id:</label>
			<input type="number" id="id" name="patientId"><br>
			<label for="password">Password:</label>
			<input type="password" id="password" name="password" value="password" maxlength="10"><br>
			
			<p>Address
			<textarea id="address" name="address" rows="10" cols="30">Fill the address</textarea><br>
			</p>
			<input type="submit" value="submit">
			
	</form>





	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script
		src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>

	<script>
		$('#targetDate').datepicker({
			format : 'dd/mm/yyyy'
		});
	</script>
</body>
</html>