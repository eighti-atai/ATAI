'use strict';




var App2 = angular.module('myApp2',[]);
angular.module('myApp2').factory('Rec', ['$http', '$q', function($http, $q){

    var rec = {
        entity :'SalesPart',
        record :{salesPartId:'',description:'',invPartNo:'',invConversionFactor:'',uom:'',priceCategory:'',generalCategory:'',objid:null}
    };
 
    return rec;
}]);
	
var App = angular.module('myApp',['myApp2']);
//var wbSis = angular.module("wbsis",["wbsislogin"]);

