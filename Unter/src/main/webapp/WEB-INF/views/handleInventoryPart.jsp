<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<link href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<form:form class="form-horizontal" method="POST" modelAttribute="addInventoryPart" Action="inventoryPart/add">
	<div class="form-group">
		<label class="col-sm-2 col-md-2 control-label">Name</label>
		<div class="col-sm-10 col-md-10">
			<form:input path="invPartNo" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 col-md-2 control-label">Description</label>
		<div class="col-sm-10 col-md-10">
			<form:input path="description" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 col-md-2 control-label">Reorder Level</label>
		<div class="col-sm-10 col-md-10">
			<form:input path="reorderLevel" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 col-md-2 control-label">Safety Stock Level</label>
		<div class="col-sm-10 col-md-10">
			<form:input path="safetyStockLevel" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10 col-md-offset-2 col-md-10">
			<button type="submit" class="btn-lg btn-primary pull-right">Add</button>
		</div>
	</div>
	</form:form>
</div>
</body>
</html>