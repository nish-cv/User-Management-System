<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${user.first_name} Details</title>
</head>
<body>
	<div>
		<h2>User Details</h2>
		<table>
			<tr>
				<th>First Name</th>
				<td>${user.first_name}</td>
			</tr>
			<tr>
				<th>Last Name</th>
				<td>${user.last_name}</td>
			</tr>
			<tr>
				<th>Address</th>
				<td>${user.address}</td>
			</tr>
			<tr>
				<th>Age</th>
				<td>${user.age}</td>
			</tr>
			<tr>
				<th>Contact</th>
				<td>${user.contact}</td>
			</tr>
		</table>
	</div>
	
	<div>
	<form action="EditUserDetails" method="post">
		<input type="hidden" name="id" id="id" value="${user.id}"> <input
			type="submit" value="Edit">
	</form>
	<br>
	
	</div>
	<div>
		<form action="Change" method="post">
			<input type="hidden" name="id" id="id" value="${user.id}"> <input type="submit"
				value="Change Password">
		</form>
	</div>
	<br>
	
	<div>
		<form action="logout.jsp">
			<input type="submit" value="Logout">
		</form>
	</div>
</body>
</html>