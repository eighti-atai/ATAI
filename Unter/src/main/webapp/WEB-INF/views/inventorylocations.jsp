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
	<h1>
		Add an Inventory Location
	</h1>
	<c:url var="addAction" value="/invlocations/add" ></c:url>
	<form:form action="${addAction}" commandName="inventorylocation">
		<table>
			<tr>
				<td>
					<form:label path="id.siteId">
						<spring:message text="Site ID"/>
					</form:label>
				</td>
				<td>
					<form:input path="id.siteId" />
				</td> 
			</tr>
			<tr>
				<td>
					<form:label path="id.invLocationId">
						<spring:message text="Inventory Location ID"/>
					</form:label>
				</td>
				<td>
					<form:input path="id.invLocationId" />
				</td> 
			</tr>
			<tr>
				<td>
					<form:label path="invLocationType">
						<spring:message text="Inventory Location Type"/>
					</form:label>
				</td>
				<td>
					<form:input path="invLocationType" />
				</td>
			</tr>
			
			<tr>
				<td colspan="1">
					<!--<c:if test="${!empty site.siteId}">
						<input type="submit"
							value="<spring:message text="Edit Site"/>" />
					</c:if> -->
					<input type="submit"
							value="<spring:message text="Add Location"/>" />
				</td>
			</tr>
		</table>	
	</form:form>
<br>
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