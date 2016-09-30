<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>


<html>
<head>
	<!--<link href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">
	<spring:url value="/resources/core/css/bootstrap.min.css"
		var="bootstrapCss" /> -->
	<spring:url value="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" var="bootstrapCss"></spring:url>
	<link href="${bootstrapCss}" rel="stylesheet" />
</head>
<body>
<div class="container">
	<h1>Sales Part Price</h1>
	<spring:url value="/salespartprices/add" var="AddUrl1"></spring:url>
	
	<form:form class="form-horizontal" method="POST" action="${AddUrl1}" commandName="addSalesPartPrice">
	
	<spring:bind path="id.salesPartId">
		<div class="form-group">
			<label class="col-sm-2 col-md-2 control-label">Sales Part ID</label>
			<div class="col-sm-10 col-md-10">
				<form:input path="id.salesPartId" class="form-control"/>
				<form:errors path="id.salesPartId" class="control-label"/>
			</div>
		</div>
	</spring:bind>
	<spring:bind path="id.salesPartPriceNo">
		<div class="form-group">
			<label class="col-sm-2 col-md-2 control-label">Sales Part Price No</label>
			<div class="col-sm-10 col-md-10">
				<form:input path="id.salesPartPriceNo" class="form-control"/>
				<form:errors path="id.salesPartPriceNo" class="error"/>
			</div>
		</div>
	</spring:bind>
	<spring:bind path="invPartId">
		<div class="form-group">
			<label class="col-sm-2 col-md-2 control-label">Inventory Part ID</label>
			<div class="col-sm-10 col-md-10">
				<form:input path="invPartId" class="form-control"/>
				<form:errors path="invPartId" class="error"/>
			</div>
		</div>
	</spring:bind>
	<spring:bind path="invPartCostNo">
		<div class="form-group">
			<label class="col-sm-2 col-md-2 control-label">Inventory Part Cost No</label>
			<div class="col-sm-10 col-md-10">
				<form:input path="invPartCostNo" class="form-control"/>
				<form:errors path="invPartCostNo" class="error"/>
			</div>
		</div>
	</spring:bind>
	<spring:bind path="objid">
		<div class="form-group">
			<label class="col-sm-2 col-md-2 control-label">objid</label>
			<div class="col-sm-10 col-md-10">
				<form:input path="objid" class="form-control"/>
				<form:errors path="objid" class="error"/>
			</div>
		</div>
		<td>
					<input type="hidden" name="searchfield" id = "searchfield">
				</td>
	</spring:bind>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10 col-md-offset-2 col-md-10">
			<button type="submit" class="btn-lg btn-primary pull-right">Add</button>
		</div>
	</div>
	</form:form>
</div>
<div class="container">
<h3>Sales Part Price List</h3>
<c:if test="${!empty listSalesPartPrice}">
	<table class="table table-striped">
	<thead>
	<tr>
		<th width="80">salesPartId</th>
		<th width="120">salesPartPriceNo</th>
		<th width="120">invPartId</th>
		<th width="120">invPartCostNo</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${listSalesPartPrice}" var="salesPartPrice">
		<tr>
			<td>${salesPartPrice.id.salesPartId}</td>
			<td>${salesPartPrice.id.salesPartPriceNo}</td>
			<td>${salesPartPrice.invPartId}</td>
			<td>${salesPartPrice.invPartCostNo}</td>
			<td/>
			<td/>
			<td>
				<spring:url value="/salespartprices/edit/${salesPartPrice.id.salesPartId}" var="editUrl"></spring:url>
				<button class="btn btn-primary" 
						onclick="location.href='${editUrl}'">Edit</button></td>
			<td>
				<spring:url value="/salespartprices/delete/${salesPartPrice.id.salesPartId}" var="deleteUrl"></spring:url>
				<button class="btn btn-danger"
						onclick="loaction.href='${deleteUrl}'"> Delete </button>
			<!--  <a href="<c:url value='/remove/${person.id}' />" >Delete</a></td> -->
		</tr>
		</tbody>
	</c:forEach>
	</table>
</c:if>
</div>
</body>
</html>