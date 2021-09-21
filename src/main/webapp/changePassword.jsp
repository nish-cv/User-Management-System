<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<script src="validatePass.js"> </script>
<title>Change Password</title>
</head>
<body>
	<h2>Add User</h2>
	<form action="ChangePassword" onsubmit = "return validatePass()" method="post">
		<input type="hidden" name="id" id="id" value="${id}">
		<table>
			<tr>
				<td>Enter new password :</td>
				<td><input type="password" name="newpassword" id="newpassword" required></td>
			</tr>
			<tr>
				<td>Enter again :</td>
				<td><input type="password" name="repassword" id="repassword"required></td>
			</tr>
			<tr>
				<td><input type="submit" value="Change Password">
			</tr>
		</table>
	</form>
	<div id="msg"></div>
</body>
</html>