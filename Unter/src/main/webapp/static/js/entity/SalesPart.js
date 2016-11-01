'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'SalesPart',
        record :{salesPartId:'',description:'',invPartNo:'',invConversionFactor:'',uom:'',priceCategory:'',generalCategory:'',objid:null},
        emptyRecord :emptyRecord
    };
    return entityRec;
    
    function emptyRecord() {
        return {salesPartId:'',description:'',invPartNo:'',invConversionFactor:'',uom:'',priceCategory:'',generalCategory:'',objid:null};
    }	
}]);