<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<html>
<head>
<title>Insert title here</title>   
<link href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"
    rel="stylesheet">
</head> 
<body>

<div class="container">
<h3>Persons List</h3>
<c:if test="${!empty listInvParts}">
	<table class="table table-striped">
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
			<td>
				<spring:url value="/inventoryPart/update/${invPart.invPartNo}" var="updateUrl"></spring:url>
				<button class="btn btn-primary" 
						onclick="location.href='${updateUrl}'">Update</button></td>
			<td>
				<spring:url value="/inventoryPart/delete/${invPart.invPartNo}" var="deleteUrl"></spring:url>
				<button class="btn btn-danger"
						onclick="loaction.href='${deleteUrl}'"> Delete </button>
			<!--  <a href="<c:url value='/remove/${person.id}' />" >Delete</a></td> -->
		</tr>
		</tbody>
	</c:forEach>
	</table>
</c:if>
</div>
<script src="webjars/jquery/3.1.0/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</body>
</html>