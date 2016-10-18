<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> -->
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<title>Site</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
.formcontainer{
	background-color: #DAE8E8;
	padding: 20px;
}
.generic-container {
  width:80%;
  margin-left: 20px;
  margin-top: 20px;
  margin-bottom: 20px;
  padding: 20px;
  background-color: #EAE7E7;
  border: 1px solid #ddd;
  border-radius: 4px;
  box-shadow: 0 0 30px black;
}
body, #mainWrapper {
	height: 70%;
	background-color:rgb(245, 245, 245);
}

body, .form-control{
	font-size:12px!important;
}
.floatRight{
	float:right;
	margin-right: 18px;
}
.tablecontainer{
	padding-left: 20px;
}
</style>

<script src="webjars/angularjs/1.5.8/angular.js"></script>
<script>
	var siteApp = angular.module('siteApp', []);
	siteApp.controller('siteCtrl', ['$scope', '$http', '$q', function($scope, $http, $q){
		$scope.Records = [];
		$scope.editArray = [];
		$scope.counter = 0;
			var init = function()
			{
				$scope.Record = {siteId: '', addressId: '', phoneNo1: '', phoneNo2: '', objid: '', searchfield: ''};
				
			}
			
			var initEditArray = function()
			{
				for (count = 0; count < $scope.Records.length; count++)
					{
						editArray[count] = 'FALSE';
					}
			}
			//init();
			$scope.submit = function()
				{
					//alert('submit');
					var deferred = $q.defer();
					$scope.Record.searchfield = 'FALSE';
					$http.post('http://localhost:8080/Unter/site/add', $scope.Record)
					  .then(function(response) {
						  alert('Record is successfully created');
						  deferred.resolve(response.data);
						  $scope.search();
					  },
			            function(errResponse){
			                console.error('Error while creating Record');
			                deferred.reject(errResponse);
			            });
					return deferred.promise;
				}
				$scope.search = function(){
					var deferred = $q.defer();
					$scope.Record.searchfield = 'TRUE';
				    $http.get('http://localhost:8080/Unter/site/list')
				    .then(function(response){
				    	$scope.Records = response.data;
				    	//initEditArray();
				    },
		            function(errResponse){
		                console.error('Error while creating Record');
		               // deferred.reject(errResponse);
		            }
				    );
				}
				init();
			}]);
</script>
<link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
</head>
<body ng-app = "siteApp" ng-controller = "siteCtrl as ctrl" class = "ng-cloak">
	<div class = "generic-container">
		<div class = "panel panel-default">
			<div class = "panel-heading">
				<span class = "lead">Sites</span>
			</div>
			<div class = "formcontainer">
	<!-- ----------------------------Add Site------------------------------------ -->
	<form ng-submit="submit()">
			<div class = "row">
				<div class = "col-md-12 form-group">
					<label class = "col-md-2" for="siteId">Site ID</label>
					<div class = "col-md-7" >
						<input type = "text" ng-model = "Record.siteId" id = "siteId" class="form-control input-sm">
					</div>
				</div>
			</div>
			
			
			<div class = "row">
				<div class = "col-md-12 form-group">
					<label class = "col-md-2" for = "addressId">Address ID</label>
					<div class = "col-md-7">
						<input type = "text" ng-model = "Record.addressId" id="addressId" class = "form-control input-sm">
					</div>
				</div>
			</div>
			<div class = "row">
				<div class="col-md-12 form-group">
					<label class = "col-md-2" for ="phoneNo1">Phone No 1</label>
					<div class = "col-md-7">
						<input type="number" ng-model = "Record.phoneNo1" id = "phoneNo1" class = "form-control input-sm">
					</div>
				</div>
			</div>
			<div class = "row">
				<div class = "col-md-12 form-group">
					<label class = "col-md-2" for = "phoneNo2">Phone No 2</label>
					<div class = "col-md-7">
						<input type = "number" ng-model = "Record.phoneNo2" id = "phoneNo2" class = "form-control input-sm">
					</div>
				</div>
			</div>
			<input type ="hidden" ng-model = "Record.objid" name = "objid" id="objid"/>
			<input type ="hidden" ng-model = "Record.searchfield" name ="searchfield" id = "searchfield">
			<div class="row">
				<div class="floatRight">
					<input type="submit" value="Save" class = "btn btn-sm btn-primary"/>
					<button class = "btn btn-sm btn-warning" type="reset" value="Reset">Reset</button>
					 <input type="button" value="Search" ng-click="search()" class = "btn btn-sm btn-success"/> 
				</div>
			</div>
	</form>
	</div>
	</div>
<br>
		<!-- ----------------------------List Sites---------------------------------- -->
		<div class="panel panel-default">
			<div class = "panel-heading lead">Site List</div>
				<div class = "tablecontainer">
				<table class="table table-hover">
					<thead>
					<tr>
						<th width="80">Site ID</th>
						<th width="120">Address ID</th>
						<th width="120">Phone no 1</th>
						<th width="120">Phone no 2</th>
					</tr>
					</thead>
					<tbody>
						<tr ng-repeat = "rec in Records track by $index">
							<td><span ng-bind = Records[$index].siteId></span></td>
							<td><span ng-bind = "rec.addressId"></span></td>
							<td><span ng-bind = "rec.phoneNo1"></span></td>
							<td><span ng-bind = "rec.phoneNo2"></span></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	</body>
</html>