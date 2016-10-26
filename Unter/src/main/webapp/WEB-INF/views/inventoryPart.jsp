<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<html>
<head>
<title>Insert title here</title>   
<link href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"
    rel="stylesheet">
    <script src="webjars/angularjs/1.5.8/angular.js"></script>
    <script>
    	var invApp = angular.module('invApp', []);
    	invApp.controller('invCtrl', ['$scope', '$http', '$q', function($scope, $http, $q){
    		$scope.Record = '';
    		$scope.Records = [];
    		
    		var init = function()
    		{
    			$scope.Record = {invPartNo:'', description:'', uom:'', reorderLevel:'', safetyStockLevel:''};
    			getRecords();
    		}
    		
    		var getRecords = function()
    		{
    			var deffered = $q.defer();
    			$http.get('/Unter/inventoryParts')
    				.then(function(response){
    					alert('Records fetched successfully');
    					$scope.Records = response.data;
    				},
    				function(errResponse){
    					console.error('Error while fetching records.');
    				}
    				);
    		}
    		init();
    	}])
    </script>
</head> 
<body>

<div class="container">
<h3>Persons List</h3>
<!-- c:if test="${!empty listInvParts}"-->
<div ng-app="invApp" ng-controller="invCtrl as ctrl" class="ng-clock">
	<table class="table table-striped">
	<thead>
	<tr>
		<th width="80">Inventory Part No</th>
		<th width="120">Description</th>
		<th width="120">uom</th>
		<th width="120">Reorder Level</th>
		<th width="120">Safety Stock Level</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	</thead>
	<tbody>
	<!-- c:forEach items="${listInvParts}" var="invPart">
		<tr>
			<td>${invPart.invPartNo}</td>
			<td>${invPart.description}</td>
			<td>${invPart.uom}</td>
			<td>${invPart.reorderLevel}</td>
			<td>${invPart.safetyStockLevel}</td>
			<td/>
			<td/>
			<td>
				<spring:url value="/inventoryPart/update/${invPart.invPartNo}" var="updateUrl"></spring:url>
				<button class="btn btn-primary" 
						onclick="location.href='${updateUrl}'">Update</button></td>
			<td>
				<spring:url value="/inventoryPart/delete/${invPart.invPartNo}" var="deleteUrl"></spring:url>
				<button class="btn btn-danger"
						onclick="loaction.href='${deleteUrl}'"> Delete </button>
			<!--  <a href="<c:url value='/remove/${person.id}' />" >Delete</a></td>>
		</tr-->
		</tbody>
	<!-- /c:forEach-->
	<tr ng-repeat="i in ctrl.Records">
		<td><span ng-bind="i.invPartNo"></span></td>
		<td><span ng-bind="i.description"></span></td>
		<td><span ng-bind="i.uom"></span></td>
		<td><span ng-bind="i.reorderLevel"></span></td>
		<td><span ng-bind="i.safetyStockLevel"></span></td>
	</tr>
	</table>
	</div>
<!-- /c:if-->
</div>
<script src="webjars/jquery/3.1.0/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</body>
</html>