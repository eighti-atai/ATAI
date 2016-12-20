'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'CustomerOrder',
        record :{customerOrderId:'',orderDate:(new Date()),status:'',note:'',paymentNo:'',customerId:'', userId:'',objid:null},
        emptyRecord :emptyRecord,
        lov :{customerId: 'Customer'},
        lovTitles :{customerId: 'Customer'} 
    };
    return entityRec;
    
    function emptyRecord() {
        return {customerOrderId:'',orderDate:(new Date()),status:'',note:'',paymentNo:'',customerId:'', userId:'',objid:null};
    }	
}]);/**
 * 
 */