<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Informaion</title>
</head>
<body>
	<!-- ----------------------------Add User------------------------------------ -->
	<h1>
		Add a User
	</h1>
	<div class="container">
		<h3>User List</h3>
		<c:if test="${!empty listUsers}">
			<table class="table table-inverse">
				<thead>
				<tr>
					<th width="80">User ID</th>
					<th width="120">User Name</th>
					<th width="120">Address id</th>
					<th width="120">Phone no 2</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach items="${listUsers}" var="user">
						<tr>
							<td>${user.userId}</td>
							<td>${user.userName}</td>
							<td>${user.addressId}</td>
							<td>${user.phoneNumber}</td>
							<td/>
							<td/>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>