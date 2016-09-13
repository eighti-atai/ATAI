<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ----------------------------Add Inventory Part Cost------------------------------------ -->
	
	<!-- ----------------------------List Inventory Part Cost---------------------------------- -->
	<div class="container">
		<h3>Inventory Part Cost List</h3>
		<c:if test="${!empty listInventoryPartCosts}">
			<table class="table table-inverse">
				<thead>
				<tr>
					<th width="80">Inventory Part No</th>
					<th width="100">Inventory Part Cost No</th>
					<th width="40">Cost</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach items="${listInventoryPartCosts}" var="partCost">
						<tr>
							<td>${partCost.id.invPartNo}</td>
							<td>${partCost.id.invPartCostNo}</td>
							<td>${partCost.cost}</td>
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