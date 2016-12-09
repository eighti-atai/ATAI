'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'Payment',
        record :{paymentNo:'',paymentType:'',paymentMethod:'',chequeNo:'',chequeExpDate:(new Date()),chequeBank:'',objid:null},
        emptyRecord :emptyRecord
    };
    return entityRec;
    
    function emptyRecord() {
        return {paymentNo:'',paymentType:'',paymentMethod:'',chequeNo:'',chequeExpDate:(new Date()),chequeBank:'',objid:null};
    }	
}]);/**
 * 
 */