<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of users</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<div>
		<h2>User List</h2>
		<table>
			<tr>
				<th>User Name</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Address</th>
				<th>Age</th>
				<th>Contact</th>
				<th>Action</th>
			</tr>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>${user.username}</td>
					<td>${user.first_name}</td>
					<td>${user.last_name}</td>
					<td>${user.address}</td>
					<td>${user.age}</td>
					<td>${user.contact}</td>
					<td>
						<form action="EditUserIn" method="post">
							<input type="hidden" name="id" id="id" value="${user.id}">
							<input type="hidden" name="dispatcher" id="dispatcher"
								value="fromTechList"> <input type="submit" value="Edit">
						</form>

						<form action="ChangePasswordIn" method="post">
							<input type="hidden" name="id" id="id" value="${user.id}">
							<input type="hidden" name="dispatcherPass" id="dispatcherPass"
								value="fromTechList"> <input type="submit"
								value="Change Pasword">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div>${errorText}</div>
	<div>
		<form action="logout.jsp">
			<input type="submit" value="Logout">
		</form>
	</div>
</body>
</html>