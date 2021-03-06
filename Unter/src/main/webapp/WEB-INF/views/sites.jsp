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
#div1, #div2 { 
     width: 350px; 
     height: 70px; 
     padding: 10px;
     color: green; 
/* /*     border: 1px solid #aaaaaa; */ */
} 
.dropzone{
	 width: 350px;
    height: 70px;
    padding: 10px;
/*     color: green; */
}

.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 80%;
}

/* The Close Button */
.close {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}
</style>
<script>
function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
    document.getElementById("div1").style.border = "dashed";
	document.getElementById("div2").style.border = "dashed";
}

function drop(ev) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
    ev.target.appendChild(document.getElementById(data));
    document.getElementById("div1").style.border = "";
	document.getElementById("div2").style.border = "";
}

function changeBorder()
{
	document.getElementById("div1").style.border = "";
	document.getElementById("div2").style.border = "";
	
}
</script>
<script src="webjars/angularjs/1.5.8/angular.js"></script>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script> -->
<script>
	var siteApp = angular.module('siteApp', []);
	siteApp.controller('siteCtrl', ['$scope', '$http', '$q', '$compile', function($scope, $http, $q, $compile){
		$scope.Records = [];
		$scope.editArray = [];
		$scope.bShow = [];
		$scope.counter = 0;
		$message = false;
		Records1 = '';
		tableHead = '';
		tableBody = '';
		$scope.focusItem = '';
			var init = function()
			{
				$scope.Record = {address: '', addressId: '', objid: '', phoneNo1: '', phoneNo2: '', siteId: ''};
				//$scope.Record1 = {siteId: '', addressId: '', phoneNo1: '', phoneNo2: '', objid: '', searchfield: ''};
				tableHead = "<table class='table table-hover'>"+
								"<thead>"+
								"<tr>"+
								"	<th width='80'>Site ID</th>"+
								"	<th width='120'>Address ID</th>"+
								"	<th width='120'>Phone no 1</th>"+
								"	<th width='120'>Phone no 2</th>"+
								"	<button type='button' class='btn btn-default' aria-label='Edit' ng-click = 'newRow()'>"+
								"		<span class='glyphicon glyphicon-plus' aria-hidden='true'></span>"+
								"	</button>"+
								"</tr>"+
								"</thead>"+
								"<tbody>";
				target.innerHTML = tableHead;
				$compile(target)($scope);
			}
			
			var initEditArray = function()
			{
				for (count = 0; count < $scope.Records.length; count++)
					{
						$scope.editArray[count] = 'false';
						$scope.bShow[count] = false;
					}
			}
			
			$scope.changeEditMode = function(index)
			{
				if ($scope.editArray[index] == 'false')
				{
					$scope.editArray[index] = 'true';
					$scope.bShow[index] = true;
				}
				tableBody = '';
				$scope.generateHtml();
			}
			
			$scope.generateHtml = function()
			{
				Records1 = tableHead;
				tableBody = '';
				for (i=0; i<$scope.Records.length; i++)
				{
					if ($scope.editArray[i] == 'false')
					{
						tableBody = tableBody +"<tr ng-dblclick = 'changeEditMode("+i+")'>" +
												"<td ondblclick = 'changeEditMode("+i+")'><span ng-bind = Records["+i+"].siteId></span></td>" +
												"<td><span ng-bind = Records["+i+"].addressId></span></td>" +
												"<td><span ng-bind = Records["+i+"].phoneNo1></span></td>" +
												"<td><span ng-bind = Records["+i+"].phoneNo2></span></td>"+
												"<td><span ng-bind = editArray["+i+"]></span></td>"+
												"<td>"+
													"<button type='button' class='btn btn-default' aria-label='Edit' ng-click = 'changeEditMode("+i+")'>"+
														"<span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>"+
													"</button>"+
												"</td>"+
											 "</tr>";	
						}
					else
					{
						tableBody = tableBody +"<tr>" +
													"<td><input type = 'text' ng-model = Records["+i+"].siteId></td>"+
													"<td><input type = 'text' ng-model = Records["+i+"].addressId></td>"+
													"<td><input type = 'text' ng-model = Records["+i+"].phoneNo1></td>"+
													"<td><input type = 'text' ng-model = Records["+i+"].phoneNo2></td>"+
												"</tr>";
					}
				}
				tableBody = tableBody + 
							"</tbody>"+
						"</table>";
				// setting table header
				Records1 = tableHead + tableBody;
				target.innerHTML = Records1;
				$compile(target)($scope);
				//$scope.$apply();
			}
			//init();
			$scope.newRow = function(){
				$scope.Records.push($scope.Record);
				tableBody ="<tr>" +
								"<td><input type = 'text' ng-bind = Records["+$scope.Records.length+"].siteId></td>"+
								"<td><input type = 'text' ng-bind = Records["+$scope.Records.length+"].addressId></td>"+
								"<td><input type = 'text' ng-bind = Records["+$scope.Records.length+"].phoneNo1></td>"+
								"<td><input type = 'text' ng-bind = Records["+$scope.Records.length+"].phoneNo2></td>"+
							"</tr>" + tableBody;
			 	Records1 = tableHead + tableBody;
				target.innerHTML = Records1;
				$compile(target)($scope);
			}
			
			$scope.submit = function()
				{
					//alert('submit');
					var deferred = $q.defer();
					$scope.Record.searchfield = 'FALSE';
					$http.post('/Unter/site/add', $scope.Record)
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
				    $http.get('/Unter/site/list')
				    .then(function(response){
				    	for (i=0; i< response.data.length; i++)
				    		{
						    	for (key in response.data[i]) {
						    	    if (response.data[i].hasOwnProperty(key)) {
						    	        console.log(key + " = " + response.data[i].key);
						    	    }
						    	}
				    		}
				    	$scope.Records = response.data;
				    	initEditArray();
				    	$scope.generateHtml();
				    },
		            function(errResponse){
		                console.error('Error while creating Record');
		               // deferred.reject(errResponse);
		            }
				    );
				}
				
				$scope.setFocus = function(id)
				{
					
				}
				
				init();
				var modal = document.getElementById('myModal');

				// Get the button that opens the modal
				var btn = document.getElementById("myBtn");

				// Get the <span> element that closes the modal
				var span = document.getElementsByClassName("close")[0];

				// When the user clicks the button, open the modal 
				btn.onclick = function() {
				    modal.style.display = "block";
				}

				// When the user clicks on <span> (x), close the modal
				span.onclick = function() {
				    modal.style.display = "none";
				}

				// When the user clicks anywhere outside of the modal, close it
				window.onclick = function(event) {
				    if (event.target == modal) {
				        modal.style.display = "none";
				    }
				}
			}]);
</script>
<link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
</head>
<body ng-app = "siteApp" ng-controller = "siteCtrl as ctrl" class = "ng-cloak">
	<div class = "generic-container">
		<div class = "panel panel-default">
			<div class = "container">
			<div class = "row">
				<div class = "panel-heading col-sm-1">
					<span class = "lead">Sites</span>
				</div>
				<div class= "col-sm-1 dropzone" id="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
			</div>
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
			<div class = "container">
			<div id="div1" ondrop="drop(event)" ondragover="allowDrop(event)" class = "dropzone">
			
				<table id="drag1" draggable="true" ondragstart="drag(event)" ondragend="changeBorder()">
					<tr>
						<td>
							<p><span style="cursor:move" class = "glyphicon glyphicon-menu-hamburger"   ></span></p>
						</td>
						<td>
							<button class = "btn btn-default btn-lg" ">
								<span class="glyphicon glyphicon-save-file"></span>
							</button>
						</td>
						<td>
							<button class = "btn btn-default btn-lg" >
								<span class="glyphicon glyphicon-plus"></span>
							</button>
						</td>
						<td>
							<button class = "btn btn-default btn-lg">
								<span class="glyphicon glyphicon-trash"></span>
							</button>
						</td>
						<td>
							<button class = "btn btn-default btn-lg">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</td>
						<td>
							<button id = "myBtn" class = "btn btn-default btn-lg">
								<span class="glyphicon glyphicon-list"></span>
							</button>
						</td>
					</tr>
				</table>
				</div>
			</div>
			<div class = "tablecontainer">

					<div id = "target"></div>
					

			</div>
		</div>
<!-- 		<button id="myBtn">Open Modal</button> -->
		
		<div id = "myModal" class = "modal">
			<div class = "modal-content">
			<span class="close">�</span>
   			 <p>Some text in the Modal..</p>
			</div>
		</div>
	</div>
	</body>
</html>