
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
	<spring:url value="/salespart/add" var="AddUrl1"></spring:url>
	
	<form:form class="form-horizontal" method="POST" action="${AddUrl1}" commandName="addSalesPart">
	
	<spring:bind path="salesPartId">
		<div class="form-group">
			<label class="col-sm-2 col-md-2 control-label">Sales Part ID</label>
			<div class="col-sm-10 col-md-10">
				<form:input path="salesPartId" class="form-control"/>
				<form:errors path="salesPartId" class="control-label"/>
			</div>
		</div>
	</spring:bind>
	<spring:bind path="description">
		<div class="form-group">
			<label class="col-sm-2 col-md-2 control-label">Description</label>
			<div class="col-sm-10 col-md-10">
				<form:input path="description" class="form-control"/>
				<form:errors path="description" class="error"/>
			</div>
		</div>
	</spring:bind>
	<spring:bind path="invPartNo">
		<div class="form-group">
			<label class="col-sm-2 col-md-2 control-label">Inventory Part ID</label>
			<div class="col-sm-10 col-md-10">
				<form:input path="invPartNo" class="form-control"/>
				<form:errors path="invPartNo" class="error"/>
			</div>
		</div>
	</spring:bind>
	<spring:bind path="invConversionFactor">
		<div class="form-group">
			<label class="col-sm-2 col-md-2 control-label">Inventory Conversion Factor</label>
			<div class="col-sm-10 col-md-10">
				<form:input path="invConversionFactor" class="form-control"/>
				<form:errors path="invConversionFactor" class="error"/>
			</div>
		</div>
	</spring:bind>
	<spring:bind path="uom">
		<div class="form-group">
			<label class="col-sm-2 col-md-2 control-label">Unit of Measure</label>
			<div class="col-sm-10 col-md-10">
				<form:input path="uom" class="form-control"/>
				<form:errors path="uom" class="error"/>
			</div>
		</div>
	</spring:bind>
	<spring:bind path="priceCategory">
		<div class="form-group">
			<label class="col-sm-2 col-md-2 control-label">Price Category</label>
			<div class="col-sm-10 col-md-10">
				<form:input path="priceCategory" class="form-control"/>
				<form:errors path="priceCategory" class="error"/>
			</div>
		</div>
	</spring:bind>
	<spring:bind path="generalCategory">
		<div class="form-group">
			<label class="col-sm-2 col-md-2 control-label">General Category</label>
			<div class="col-sm-10 col-md-10">
				<form:input path="generalCategory" class="form-control"/>
				<form:errors path="generalCategory" class="error"/>
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