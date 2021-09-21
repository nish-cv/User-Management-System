<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of users</title>
</head>
<body>
	<div>
		<h2>User List</h2>
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Address</th>
				<th>Age</th>
				<th>Contact</th>
				<th>Action</th>
			</tr>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>${user.first_name}</td>
					<td>${user.last_name}</td>
					<td>${user.address}</td>
					<td>${user.age}</td>
					<td>${user.contact}</td>
					<td>
						<form action="EditUser" method="post">
							<input type="hidden" name="id" id="id" value="${user.id}">
							<input type="submit" value="Edit">
						</form>
						<form action="DeleteUser" method="post">
							<input type="hidden" name="id" id="id" value="${user.id}">
							<input type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div><a href="admin.jsp">Go Back</a></div>
</body>
</html>