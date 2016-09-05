<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
<h3>Address List</h3>
<c:if test="${!empty listaddresses}">
	<table class="table table-inverse">
		<thead>
		<tr>
			<th width="80">Address ID</th>
			<th width="120">Street</th>
			<th width="120">City</th>
			<th width="120">Country</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${listaddresses}" var="address">
				<tr>
					<td>${address.addressId}</td>
					<td>${address.street}</td>
					<td>${address.city}</td>
					<td>${address.country}</td>
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