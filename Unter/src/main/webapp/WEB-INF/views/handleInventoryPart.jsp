<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<link href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<form:form class="form-horizontal" method="POST" modelAttribute="addInventoryPart" Action="inventoryPart/add">
	<table class="table table-striped">
		<tbody>
			<tr>
				<td><form:label path="invPartNo">Part No</form:label></td>
				<td><form:input path="invPartNo"/></td>
			</tr>
			<tr>
				<td><form:label path="description">Description</form:label></td>
				<td><form:input path="description"/></td>
			</tr>
			<tr>
				<td><form:label path="reorderLevel">Reorder Level</form:label></td>
				<td><form:input path="reorderLevel"/></td>
			</tr>
			<tr>
				<td><form:label path="safetyStockLevel">Safety Stock Level</form:label></td>
				<td><form:input path="safetyStockLevel"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</tbody>
	</table>
	</form:form>
</div>
</body>
</html>