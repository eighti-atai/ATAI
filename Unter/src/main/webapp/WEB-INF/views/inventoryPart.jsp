<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href=”webjars/bootstrap/3.3.7-1/css/bootstrap.min.css” rel=”stylesheet” type=”text/css” />
</head>
<body>

<div class="container">
<h3>Persons List</h3>
<c:if test="${!empty listInvParts}">
	<table class="table table-inverse">
	<thead>
	<tr>
		<th width="80">Inventory Part No</th>
		<th width="120">Description</th>
		<th width="120">uom</th>
		<th width="120">Reorder Level</th>
		<th width="120">Safety Stock Level</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${listInvParts}" var="invPart">
		<tr>
			<td>${invPart.invPartNo}</td>
			<td>${invPart.description}</td>
			<td>${invPart.uom}</td>
			<td>${invPart.reorderLevel}</td>
			<td>${invPart.safetyStockLevel}</td>
			<td/>
			<td/>
			<td><a href="<c:url value='/edit/${person.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${person.id}' />" >Delete</a></td>
		</tr>
		</tbody>
	</c:forEach>
	</table>
</c:if>
</div>
<script src=”webjars/bootstrap/3.3.7-1/js/bootstrap.min.js”></script>
<script src=”webjars/jquery/3.1.0/js/bootstrap.min.js”></script>
</body>
</html>