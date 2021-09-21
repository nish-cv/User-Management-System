<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
<script src="validateEdit.js"></script>
</head>
<body>
	<h2>Edit User</h2>
	<form action="EditUserSetDetails" onsubmit="return validateEdit() " method="post">
		<input type="hidden" name="id" id="id" value="${user.id}">
		<table>
			<tr>
				<td>First name :</td>
				<td><input type="text" name="firstname" id="firstname" value="${user.first_name}" required></td>
			</tr>
			<tr>
				<td>Last name :</td>
				<td><input type="text" name="lastname" id="lastname" value="${user.last_name}" required></td>
			</tr>
			<tr>
				<td>Age :</td>
				<td><input type="number" name="age" id="age" value="${user.age}" required min=0></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><input type="text" name="address" id="address" value="${user.address}"></td>
			</tr>
			<tr>
				<td>Contact :</td>
				<td><input type="text" name="contact" id="contact" value="${user.contact}" required></td>
			</tr>
			<tr>
				<td>
				<td><input type="submit" value="Update"></td>
			</tr>
		</table>
	</form>
	
	<div id="demo"></div>
</body>
</html>