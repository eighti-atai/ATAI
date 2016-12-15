<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ATAI</title>
<style>
 .salesPartId.ng-valid {
          background-color: lightgreen;
      }
      .salesPartId.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .salesPartId.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }
 
      .description.ng-valid {
          background-color: lightgreen;
      }
      .description.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .description.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }
 .invPartNo.ng-valid {
          background-color: lightgreen;
      }
      .invPartNo.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .invPartNo.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }
 
      .invConversionFactor.ng-valid {
          background-color: lightgreen;
      }
      .invConversionFactor.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .invConversionFactor.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }
      .uom.ng-valid {
          background-color: lightgreen;
      }
      .uom.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .uom.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }
 
      .priceCategory.ng-valid {
          background-color: lightgreen;
      }
      .priceCategory.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .priceCategory.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }
      
       .generalCategory.ng-valid {
          background-color: lightgreen;
      }
      .generalCategory.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .generalCategory.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }
      
      /* .lov {
    display: none;
    } */

	.lov {
    display: none;/* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 50%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    /* background-color: rgb(0,0,0); */ /* Fallback color */
    /* background-color: rgba(0,0,0,0.4); */ /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 15% auto; /* 15% from the top and centered */
    padding: 20px;
    border: 1px solid #888;
    width: 80%; /* Could be more or less, depending on screen size */
}

/* The Close Button */
.close {
    color: #aaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: black;
    text-decoration: none;
    cursor: pointer;
}
    </style>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/angular-material/1.1.1/angular-material.min.css">
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    <script src="webjars/angularjs/1.5.8/angular.js"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/service/service.js' />"></script>
    <script src="<c:url value='/static/js/controller/controller.js' />"></script>
    <script src="<c:url value='/static/js/filter/filter.js' />"></script>
    <script src="<c:url value='/static/js/entity/Customer.js' />"></script>
    <script src="webjars/angularjs/1.5.8/angular.js"></script>
    <script src="webjars/angularjs/1.5.8/angular-animate.min.js"></script>
    <script src="webjars/angularjs/1.5.8/angular-aria.min.js"></script>
    <script src="webjars/angularjs/1.5.8/angular-messages.min.js"></script>
    <script src="webjars/angular-material/1.1.1/angular-material.min.js"></script>
    <script src="<c:url value='/static/js/directives/unterLov.js' />"></script>
</head>
<body>
	<body ng-app="generalModule" class="ng-cloak">
      <div class="generic-container" data-ng-controller="RecordController as ctrl" ng-init="ctrl.init()">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Customers</span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                  	 <div id="lov" unter-lov class = "lov"></div>
                      <input type="hidden" ng-model="ctrl.Record.objid" /> 

						<div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="customerId">Customer Id</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.Record.customerId" id="customerId" class="salesPartId form-control input-sm" placeholder="Enter Customer Id " required ng-minlength="1" ng-focus="ctrl.setFocusedElement()"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.customerId.$error.required">This is a required field</span>
                                      <span ng-show="myForm.customerId.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.customerId.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="customerName">Customer Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.Record.customerName" id="customerName" class="description form-control input-sm" placeholder="Enter Customer Name" required ng-focus="ctrl.setFocusedElement()"/>
                              	  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.customerName.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="nic">Nic</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.Record.nic" id="nic" class="description form-control input-sm" placeholder="Enter Nic"  ng-focus="ctrl.setFocusedElement()"/>
                              	  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.nic.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="addressId">Address ID</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.Record.addressId" id="addressId" class="description form-control input-sm" placeholder="Enter Address ID." required ng-focus="ctrl.setFocusedElement()"/>
                              	  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.addressId.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="phoneNo1">Phone No 1</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.Record.phoneNo1" id="phoneNo1" class="description form-control input-sm" placeholder="Enter Phone No 1." ng-focus="ctrl.setFocusedElement()"/>
                              	  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.phoneNo1.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="phoneNo2">Phone No 2</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.Record.phoneNo2" id="phoneNo2" class="description form-control input-sm" placeholder="Enter Phone No 2." ng-focus="ctrl.setFocusedElement()"/>
                              	  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.phoneNo2.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                           
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.Record.objid ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                               <button type="button" ng-click="ctrl.updateAll()" class="btn btn-warning btn-sm" >Save All</button>
                               <button type="button" ng-click="ctrl.searchRecords()" class="btn btn-warning btn-sm" >Search</button>
                               <button type="button" ng-click="ctrl.ListOfValues()" class = "btn btn-warning btn-sm">List...</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Customers </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>Customer Id</th>
                              <th>Customer Name</th>
                              <th>NIC</th>
                              <th>Address ID</th>
                              <th>Phone No 1</th>
                              <th>Phone No 2</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.Records | startFrom:ctrl.currentPage*ctrl.pageSize | limitTo:ctrl.pageSize " >
                              <td ng-if="!ctrl.change(u.objid)"><span ng-bind="u.customerId"></span></td>
                              <td ng-if="!ctrl.change(u.objid)"><span ng-bind="u.customerName"></span></td>
                              <td ng-if="!ctrl.change(u.objid)"><span ng-bind="u.nic"></span></td>
                              <td ng-if="!ctrl.change(u.objid)"><span ng-bind="u.addressId"></span></td>
                              <td ng-if="!ctrl.change(u.objid)"><span ng-bind="u.phoneNo1"></span></td>
                              <td ng-if="!ctrl.change(u.objid)"><span ng-bind="u.phoneNo2"></span></td>
                                                                                          
                              <td ng-if="ctrl.change(u.objid)"><input type="text" ng-model="u.customerId"style="width: 100%"/></td>
                              <td ng-if="ctrl.change(u.objid)"><input type="text" ng-model="u.customerName" style="width: 100%""/></td>
                              <td ng-if="ctrl.change(u.objid)"><input type="text" ng-model="u.nic"style="width: 100%""/></td>
                              <td ng-if="ctrl.change(u.objid)"><input type="text" ng-model="u.addressId"style="width: 100%""/></td>
                              <td ng-if="ctrl.change(u.objid)"><input type="text" ng-model="u.phoneNo1"style="width: 100%""/></td>
                              <td ng-if="ctrl.change(u.objid)"><input type="text" ng-model="u.phoneNo2"style="width: 100%""/></td>
                              <!-- <td ng-if="ctrl.change(u.objid)"><input type="hidden" ng-model="u.objid" style="width: 80px;"/></td> -->
                              <td>
                              <button type="button" ng-click="ctrl.editRow(u.objid)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.objid)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                      
                  </table>
                  <button ng-disabled="ctrl.currentPage == 0" ng-click="ctrl.currentPage=ctrl.currentPage-1">
        			Previous
    			  </button>
    						{{ctrl.currentPage+1}}/{{ctrl.numberOfPages()}}
    			  <button ng-disabled="ctrl.currentPage >= ctrl.Records.length/ctrl.pageSize - 1" ng-click="ctrl.currentPage=ctrl.currentPage+1">
       						 	Next
    					  </button>
                 <!--  <input type="text" ng-model="ctrl.Records[1].salesPartId"/>
                  ctrl.Record = ctrl.Records[1]
                              <input type="text" ng-model="u.description"/>
                              <input type="text" ng-model="u.invPartNo"/>
                              <input type="text" ng-model="u.invConversionFactor"/>
                             <input type="text" ng-model="u.uom"/>
                              <input type="text" ng-model="u.priceCategory"/>
                              <input type="text" ng-model="u.generalCategory"/>
                              <input type="text" ng-model="u.objid"/>
                              <td> {{$index}} </td> -->
              </div>
          </div>
      </div>
	</body>
</html>