<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ----------------------------Add Inventory Location------------------------------------ -->
	
	<!-- ----------------------------List Inventory Locations---------------------------------- -->
	<div class="container">
		<h3>Site List</h3>
		<c:if test="${!empty listInventoryLocations}">
			<table class="table table-inverse">
				<thead>
				<tr>
					<th width="80">Site ID</th>
					<th width="80">Inventory Location ID</th>
					<th width="100">Inventory Location Type</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach items="${listInventoryLocations}" var="location">
						<tr>
							<td>${location.id.siteId}</td>
							<td>${location.id.invLocationId}</td>
							<td>${location.invLocationType}</td>
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