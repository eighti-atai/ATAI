
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
	
	<spring:bind path="salesPartNo">
		<div class="form-group">
			<label class="col-sm-2 col-md-2 control-label">Name</label>
			<div class="col-sm-10 col-md-10">
				<form:input path="salesPartNo" class="form-control"/>
				<form:errors path="salesPartNo" class="control-label"/>
			</div>
		</div>
	</spring:bind>
	<spring:bind path="discription">
		<div class="form-group">
			<label class="col-sm-2 col-md-2 control-label">Description</label>
			<div class="col-sm-10 col-md-10">
				<form:input path="discription" class="form-control"/>
				<form:errors path="discription" class="error"/>
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