'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'CustomerOrderLine',
        record :{id:{customerOrderId:'',coLineNo:''},salesQty:'',discount:'',amount:'',salesPartId:'',salesPartPriceNo:'',customerOrder:{customerOrderId:'2',orderDate:(new Date()),status:'open',note:'kan',paymentNo:'1',customerId:'1', userId:'',objid:null},objid:null},
        emptyRecord :emptyRecord,
        lov :{customerOrderId: 'CustomerOrder', salesPartId: 'SalesPart', salesPartPriceNo: 'SalesPartPrice'},
        lovTitles :{customerOrderId:'Customer Order', salesPartId: 'Sales Part', salesPartPriceNo: 'Sales Part Price'}
    };
    return entityRec;
    
    function emptyRecord() {
        return {id:{customerOrderId:'',coLineNo:''},salesQty:'',discount:'',amount:'',salesPartId:'',salesPartPriceNo:'',customerOrder:{customerOrderId:'',orderDate:(new Date()),status:'',note:'',paymentNo:'',customerId:'', userId:'',objid:null},objid:null};
    }	
}]);