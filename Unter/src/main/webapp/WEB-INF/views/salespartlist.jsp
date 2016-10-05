<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>AngularJS $http Example</title>  
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
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" data-ng-controller="SalesPartController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">SalesPart Registration Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.SalesPart.objid" /> 
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="uname">Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.SalesPart.salesPartId" id="salesPartId" class="salesPartId form-control input-sm" placeholder="Enter1 " required ng-minlength="3"/>
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
                              <label class="col-md-2 control-lable" for="description">description</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.SalesPart.description" id="description" class="form-control input-sm" placeholder="Enter description. [This field is validation free]"/>
                              </div>
                          </div>
                      </div>
                      
                        <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="invPartNo">Address</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.SalesPart.invPartNo" id="invPartNo" class="form-control input-sm" placeholder="Enter invPartNo"/>
                              </div>
                          </div>
                      </div>
 
   <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="invConversionFactor">Address</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.SalesPart.invConversionFactor" id="invConversionFactor" class="form-control input-sm" placeholder="Enter invConversionFactor. [This field is validation free]"/>
                              </div>
                          </div>
                      </div>
 
   <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="uom">Address</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.SalesPart.uom" id="uom" class="form-control input-sm" placeholder="Enter uom. [This field is validation free]"/>
                              </div>
                          </div>
                      </div>
 
   <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="priceCategory">Address</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.SalesPart.priceCategory" id="priceCategory" class="form-control input-sm" placeholder="Enter priceCategory [This field is validation free]"/>
                              </div>
                          </div>
                      </div>
 
 
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="generalCategory">Email</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.SalesPart.generalCategory" id="generalCategory" class="generalCategory form-control input-sm" placeholder="Enter generalCategory" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.generalCategory.$error.required">This is a required field</span>
                                      <span ng-show="myForm.generalCategory.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
 
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.SalesPart.salesPartId ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
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
                              <th>salesPartId.</th>
                              <th>description</th>
                              <th>invPartNo</th>
                              <th>invConversionFactor</th>
                              <th>uom</th>
                              <th>priceCategory</th>
                              <th>generalCategory</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.SalesParts">
                              <td><span ng-bind="u.salesPartId"></span></td>
                              <td><span ng-bind="u.description"></span></td>
                              <td><span ng-bind="u.invPartNo"></span></td>
                              <td><span ng-bind="u.invConversionFactor"></span></td>
                              <td><span ng-bind="u.uom"></span></td>
                              <td><span ng-bind="u.priceCategory"></span></td>
                              <td><span ng-bind="u.generalCategory"></span></td>
                              
                              <td>
                              <button type="button" ng-click="ctrl.edit(u.salesPartId)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.salesPartId)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
       
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/sales_part_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/sales_part_controller.js' />"></script>
  </body>
</html>