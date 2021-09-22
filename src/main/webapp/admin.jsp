<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<script src="validate.js"></script>
</head>
<body>

	<div>
		<h2>Add User</h2>
		<form action="AddUser" onsubmit="return validate()" method="post">
			<table>
				<tr>
					<td>User name :</td>
					<td><input type="text" name="username" id="username" required></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password" id="password"
						required></td>
				</tr>
				<tr>
					<td>First name :</td>
					<td><input type="text" name="firstname" id="firstname"
						required></td>
				</tr>
				<tr>
					<td>Last name :</td>
					<td><input type="text" name="lastname" id="lastname" required></td>
				</tr>
				<tr>
					<td>Age :</td>
					<td><input type="number" name="age" id="age" required min=0></td>
				</tr>
				<tr>
					<td>Address :</td>
					<td><input type="text" name="address" id="address"></td>
				</tr>
				<tr>
					<td>Contact :</td>
					<td><input type="text" name="contact" id="contact" required></td>
				</tr>
				<tr>
					<td>User Type :</td>
					<td> <select name="usertype" id="usertype">
						    <option value="user">User</option>
						    <option value="technician">Technician</option>
						  </select>
					</td>
				</tr>
				<tr>
					<td>
					<td><input type="submit" value="Add User"></td>
				</tr>
				
			</table>
		</form>

		<div id="demo"></div>
		<div id="error text">${errorText}</div>
		
		<form action="ListUser" method="post">
			<input type="submit" value="List User">
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