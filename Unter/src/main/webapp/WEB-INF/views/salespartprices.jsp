
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
	<h1>Inventory Part</h1>
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
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10 col-md-offset-2 col-md-10">
			<button type="submit" class="btn-lg btn-primary pull-right">Add</button>
		</div>
	</div>
	</form:form>
</div>
</body>
</html>