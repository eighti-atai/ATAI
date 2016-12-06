<html lang="en" >
   <head>
     <link rel="stylesheet" href="webjars/angular-material/1.1.1/angular-material.min.css">
    <script src="webjars/angularjs/1.5.8/angular.js"></script>
      <script src="webjars/angularjs/1.5.8/angular-animate.min.js"></script>
      <script src="webjars/angularjs/1.5.8/angular-aria.min.js"></script>
      <script src="webjars/angularjs/1.5.8/angular-messages.min.js"></script>
      <script src="webjars/angular-material/1.1.1/angular-material.min.js"></script>
      
      <script language="javascript">
         angular
            .module('firstApplication', ['ngMaterial','ngMessages'])
            .controller('dateController', ['$scope', function($scope){

         //function dateController ($scope) {
            $scope.myDate = new Date();
            $scope.minDate = new Date(
               $scope.myDate.getFullYear(),
               $scope.myDate.getMonth() - 2,
               $scope.myDate.getDate());
            $scope.maxDate = new Date(
               $scope.myDate.getFullYear(),
               $scope.myDate.getMonth() + 2,
               $scope.myDate.getDate());
            $scope.onlyWeekendsPredicate = function(date) {
               var day = date.getDay();
               return day === 0 || day === 6;
            }
         }]);//}                 
      </script>      
   </head>
   <body ng-app="firstApplication"> 
      <div class="datepickerdemo" ng-controller="dateController as ctrl"  ng-cloak>
         <md-content>
            <h4>Standard Date Picker</h4>
            <md-datepicker 
               ng-model="myDate" 
               md-placeholder="Enter date"></md-datepicker>
            <h4>Disabled Date Picker</h4>
            <md-datepicker 
               ng-model="myDate" 
               md-placeholder="Enter date" 
               disabled></md-datepicker>
            <h4>Date-picker with min and max dates</h4>
            <md-datepicker 
               ng-model="myDate" 
               md-placeholder="Enter date"
               md-min-date="minDate" 
               md-max-date="maxDate"></md-datepicker>
            <h4>Date-picker with only selectable weekends</h4>
            <md-datepicker 
               ng-model="myDate" 
               md-placeholder="Enter date"
               md-date-filter="onlyWeekendsPredicate"></md-datepicker>
            <h4>Date-picker with only selectable weekends in a range</h4>
            <md-datepicker 
               ng-model="myDate" 
               md-placeholder="Enter date"
               md-min-date="minDate" 
               md-max-date="maxDate"
               md-date-filter="onlyWeekendsPredicate"></md-datepicker>
            <h4>Date-picker with validation mesages</h4>
            <form name="myForm">
               <md-datepicker 
                  name="dateField" 
                  ng-model="myDate" 
                  md-placeholder="Enter date"
                  required 
                  md-min-date="minDate" 
                  md-max-date="maxDate"
                  md-date-filter="onlyWeekendsPredicate"></md-datepicker>
               <div class="validation-messages" ng-messages="myForm.dateField.$error">
                  <div ng-message="valid">The entered value is not a date!</div>
                  <div ng-message="required">This date is required!</div>
                  <div ng-message="mindate">Date is too early!</div>
                  <div ng-message="maxdate">Date is too late!</div>
                  <div ng-message="filtered">Only weekends are allowed!</div>
               </div>
            </form>
         </md-content>
	   </div>
   </body>
</html>