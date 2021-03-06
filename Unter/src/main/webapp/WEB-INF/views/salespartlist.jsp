<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
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
    <script src="webjars/angularjs/1.5.8/angular.js"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/service/service.js' />"></script>
    <script src="<c:url value='/static/js/controller/controller.js' />"></script>
    <script src="<c:url value='/static/js/filter/filter.js' />"></script>
    <script src="<c:url value='/static/js/entity/SalesPart.js' />"></script>
    <script src="webjars/angularjs/1.5.8/angular.js"></script>
    <script src="webjars/angularjs/1.5.8/angular-animate.min.js"></script>
    <script src="webjars/angularjs/1.5.8/angular-aria.min.js"></script>
    <script src="webjars/angularjs/1.5.8/angular-messages.min.js"></script>
    <script src="webjars/angular-material/1.1.1/angular-material.min.js"></script>
  </head>
  <body ng-app="generalModule" class="ng-cloak">
      <div class="generic-container" data-ng-controller="RecordController as ctrl" ng-init="ctrl.init()">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Sales Parts</span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.Record.objid" /> 
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="salesPartId">Sales Part Id</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.Record.salesPartId" id="salesPartId" class="salesPartId form-control input-sm" placeholder="Enter Sales Part Id " required ng-minlength="1"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.salesPartId.$error.required">This is a required field</span>
                                      <span ng-show="myForm.salesPartId.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.salesPartId.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                         
                       
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="description">Description</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.Record.description" id="description" class="description form-control input-sm" placeholder="Enter Description." required/>
                              	  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.salesPartId.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                        <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="invPartNo">Inventory Part No</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.Record.invPartNo" id="invPartNo" class="invPartNo form-control input-sm" placeholder="Enter Inventory Part No" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.salesPartId.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
 
   					  <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="invConversionFactor">Inventory Conversion Factor</label>
                              <div class="col-md-7">
                                  <input type="number" ng-model="ctrl.Record.invConversionFactor" id="invConversionFactor" class="invConversionFactor form-control input-sm" placeholder="Enter Inventory Conversion Factor" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.salesPartId.$error.required">This is a required field</span>
                                      <span ng-show="myForm.salesPartId.$error.number">should be a number</span>
                                      <span ng-show="myForm.salesPartId.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
 
   					  <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="uom">Unit of Measure</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.Record.uom" id="uom" class="uom form-control input-sm" placeholder="Enter Unit of Measure" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.salesPartId.$error.required">This is a required field</span>
                                      <span ng-show="myForm.salesPartId.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
 
   				  	  <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="priceCategory">Price Category</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.Record.priceCategory" id="priceCategory" class="priceCategory form-control input-sm" placeholder="Enter Price Category" required/>
                              	  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.salesPartId.$error.required">This is a required field</span>
                                      <span ng-show="myForm.salesPartId.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
 
 
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="generalCategory">General Category</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.Record.generalCategory" id="generalCategory" class="generalCategory form-control input-sm" placeholder="Enter General Category" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.generalCategory.$error.required">This is a required field</span>
                                      <span ng-show="myForm.generalCategory.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
 
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.Record.objid ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                               <button type="button" ng-click="ctrl.updateAll()" class="btn btn-warning btn-sm" >Save All</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of SalesParts </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>Sales Part Id</th>
                              <th>Description</th>
                              <th>Inventory Part No</th>
                              <th>Inventory Conversion Factor</th>
                              <th>Unit of Measure</th>
                              <th>Price Category</th>
                              <th>General Category</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.Records | startFrom:ctrl.currentPage*ctrl.pageSize | limitTo:ctrl.pageSize " >
                              <td ng-if="!ctrl.change(u.objid)"><span ng-bind="u.salesPartId"></span></td>
                              <td ng-if="!ctrl.change(u.objid)"><span ng-bind="u.description"></span></td>
                              <td ng-if="!ctrl.change(u.objid)"><span ng-bind="u.invPartNo"></span></td>
                              <td ng-if="!ctrl.change(u.objid)"><span ng-bind="u.invConversionFactor"></span></td>
                              <td ng-if="!ctrl.change(u.objid)"><span ng-bind="u.uom"></span></td>
                              <td ng-if="!ctrl.change(u.objid)"><span ng-bind="u.priceCategory"></span></td>
                              <td ng-if="!ctrl.change(u.objid)"><span ng-bind="u.generalCategory"></span></td>
                              
                              <td ng-if="ctrl.change(u.objid)"><input type="text" ng-model="u.salesPartId"style="width: 100%"/></td>
                              <td ng-if="ctrl.change(u.objid)"><input type="text" ng-model="u.description" style="width: 100%""/></td>
                              <td ng-if="ctrl.change(u.objid)"><input type="text" ng-model="u.invPartNo"style="width: 100%""/></td>
                              <td ng-if="ctrl.change(u.objid)"><input type="text" ng-model="u.invConversionFactor" style="width: 100%"/></td>
                              <td ng-if="ctrl.change(u.objid)"><input type="text" ng-model="u.uom" style="width: 100%"/></td>
                              <td ng-if="ctrl.change(u.objid)"><input type="text" ng-model="u.priceCategory" style="width: 100%"/></td>
                              <td ng-if="ctrl.change(u.objid)"><input type="text" ng-model="u.generalCategory" style="width: 100%"/></td>
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