'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'CustomerOrderLine',
        record :{id:{customerOrderId:'',coLineNo:''},salesQty:'',discount:'',amount:'',salesPartId:'',salesPartPriceNo:'',objid:null},
        emptyRecord :emptyRecord,
        lov :{salesPartId: 'SalesPart', salesPartPriceNo: 'SalesPartPrice'},
        lovTitles :{salesPartId: 'SalesPart', salesPartPriceNo: 'SalesPartPrice'}
    };
    return entityRec;
    
    function emptyRecord() {
        return {id:{customerOrderId:'',coLineNo:''},salesQty:'',discount:'',amount:'',salesPartId:'',salesPartPriceNo:'',objid:null};
    }	
}]);