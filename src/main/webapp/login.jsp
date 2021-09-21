<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h2>Login</h2>
	<form action="Login" method="post">
		<table>
			<tr>
				<td>User Name :</td>
				<td><input type="text" name="username" id="username" required></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password" id="password"
					required></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login">
			</tr>
		</table>
	</form>
	<div>${errorText}</div>
</body>
</html>