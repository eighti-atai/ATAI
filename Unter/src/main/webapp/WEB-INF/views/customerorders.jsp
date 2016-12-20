<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
      
    </style>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/angular-material/1.1.1/angular-material.min.css">
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/lov.css' />" rel="stylesheet"></link>
    <script src="webjars/angularjs/1.5.8/angular.js"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/service/service.js' />"></script>
    <script src="<c:url value='/static/js/controller/controller.js' />"></script>
    <script src="<c:url value='/static/js/filter/filter.js' />"></script>
    <script src="<c:url value='/static/js/entity/CustomerOrderHead.js' />"></script>
    <script src="webjars/angularjs/1.5.8/angular.js"></script>
    <script src="webjars/angularjs/1.5.8/angular-animate.min.js"></script>
    <script src="webjars/angularjs/1.5.8/angular-aria.min.js"></script>
    <script src="webjars/angularjs/1.5.8/angular-messages.min.js"></script>
    <script src="webjars/angular-material/1.1.1/angular-material.min.js"></script>
    <script src="<c:url value='/static/js/directives/unterLov.js' />"></script>
</head>
<body ng-app="generalModule" class="ng-cloak">
      <div class="generic-container" data-ng-controller="RecordController as ctrl" ng-init="ctrl.init()">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Customer Order Head</span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                  	 <div id="lov" unter-lov class = "lov"></div>
                      <input type="hidden" ng-model="ctrl.Record.objid" /> 

						<div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="customerOrderId">Customer Order Id</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.Record.customerOrderId" id="customerOrderId" class="salesPartId form-control input-sm" placeholder="Enter Customer Order Id " required ng-minlength="1" ng-focus="ctrl.setFocusedElement()"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.customerOrderId.$error.required">This is a required field</span>
                                      <span ng-show="myForm.customerOrderId.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.customerOrderId.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="orderDate">Order Date</label>
                              <div class="col-md-7">
                                  <md-datepicker ng-model="ctrl.Record.orderDate" md-placeholder="Enter date"></md-datepicker>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="status">Status</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.Record.status" id="status" class="description form-control input-sm" placeholder="Enter Status"  ng-focus="ctrl.setFocusedElement()"/>
                              	  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.status.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="note">Note</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.Record.note" id="note" class="description form-control input-sm" placeholder="Enter Note"  ng-focus="ctrl.setFocusedElement()"/>
                              	  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.note.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      

					<div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="customerId">Customer ID</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.Record.customerId" id="customerId" class="description form-control input-sm" placeholder="Enter Customer ID"  ng-focus="ctrl.setFocusedElement()"/>
                              	  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.customerId.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="userId">User ID</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.Record.userId" id="userId" class="description form-control input-sm" placeholder="Enter User ID"  ng-focus="ctrl.setFocusedElement()"/>
                              	  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.userId.$error.required">This is a required field</span>
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
              <div class="panel-heading"><span class="lead">List of Customer Orders </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>Customer Order ID</th>
                              <th>Order Date</th>
                              <th>Status</th>
                              <th>Note</th>
                              <th>PaymentNo</th>
                              <th>Customer ID</th>
                              <th>User ID</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.Records | startFrom:ctrl.currentPage*ctrl.pageSize | limitTo:ctrl.pageSize " >
                              <td ng-if="!ctrl.change(u.objid)"><span ng-bind="u.customerOrderId"></span></td>
                              <td ng-if="!ctrl.change(u.objid)"><span ng-bind="ctrl.setDate(u.objid, 'orderDate', u.orderDate)|date:yyyy/MM/dd"></span></td>
                              <td ng-if="!ctrl.change(u.objid)"><span ng-bind="u.status"></span></td>
                              <td ng-if="!ctrl.change(u.objid)"><span ng-bind="u.note"></span></td>
                              <td ng-if="!ctrl.change(u.objid)"><span ng-bind="u.paymentNo"></span></td>
                              <td ng-if="!ctrl.change(u.objid)"><span ng-bind="u.customerId"></span></td>
                              <td ng-if="!ctrl.change(u.objid)"><span ng-bind="u.userId"></span></td>
                                                                                          
                              <td ng-if="ctrl.change(u.objid)"><input type="text" ng-model="u.customerOrderId"style="width: 100%"/></td>
                              <td ng-if="ctrl.change(u.objid)"><md-datepicker ng-model="u.orderDate"></md-datepicker></td>
                              <td ng-if="ctrl.change(u.objid)"><input type="text" ng-model="u.status" style="width: 100%""/></td>
                              <td ng-if="ctrl.change(u.objid)"><input type="text" ng-model="u.note" style="width: 100%""/></td>
                              <td ng-if="ctrl.change(u.objid)"><input type="text" ng-model="u.paymentNo"style="width: 100%""/></td>
                              <td ng-if="ctrl.change(u.objid)"><input type="text" ng-model="u.customerId"style="width: 100%""/></td>
                              <td ng-if="ctrl.change(u.objid)"><input type="text" ng-model="u.userId"style="width: 100%""/></td>
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
</body>
</html>