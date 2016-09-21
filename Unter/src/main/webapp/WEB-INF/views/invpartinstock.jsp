<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ----------------------------Add Inventory Part In Stock------------------------------------ -->
	<h1>
		Add an Inventory Part In Stock
	</h1>
	<c:url var="addAction" value="/invpartinstock/add" ></c:url>
	<form:form action="${addAction}" commandName="invPartInStock">
		<table>
			<tr>
				<td>
					<form:label path="id.invPartNo">
						<spring:message text="Inventory Part NO"/>
					</form:label>
				</td>
				<td>
					<form:input path="id.invPartNo" />
				</td> 
			</tr>
			<tr>
				<td>
					<form:label path="id.invPartCostNo">
						<spring:message text="Inventory Part Cost NO"/>
					</form:label>
				</td>
				<td>
					<form:input path="id.invPartCostNo" />
				</td> 
			</tr>
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
					<form:label path="stockQuantity">
						<spring:message text="Stock Quantity"/>
					</form:label>
				</td>
				<td>
					<form:input path="stockQuantity" />
				</td>
			</tr>
			
			<tr>
				<td colspan="1">
					<!--<c:if test="${!empty site.siteId}">
						<input type="submit"
							value="<spring:message text="Edit Site"/>" />
					</c:if> -->
					<input type="submit"
							value="<spring:message text="Add Inv Part"/>" />
				</td>
			</tr>
		</table>	
	</form:form>
<br>
	<!-- ----------------------------List Inventory Part in Stock---------------------------------- -->
	<div class="container">
		<h3>Inventory Parts in Stock</h3>
		<c:if test="${!empty listInvPartInStock}">
			<table class="table table-inverse">
				<thead>
				<tr>
					<th width="80">Inventory Part NO</th>
					<th width="80">Inventor Part Cost NO</th>
					<th width="80">Site ID</th>
					<th width="80">Inventory Location ID</th>
					<th width="100">Stock Quantity</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach items="${listInvPartInStock}" var="invPartInStock">
						<tr>
							<td>${invPartInStock.id.invPartNo}</td>
							<td>${invPartInStock.id.invPartCostNo}</td>
							<td>${invPartInStock.id.siteId}</td>
							<td>${invPartInStock.id.invLocationId}</td>
							<td>${invPartInStock.stockQuantity}</td>
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