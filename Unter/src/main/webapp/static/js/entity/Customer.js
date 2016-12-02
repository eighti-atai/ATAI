'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'Customer',
        record :{customerId:'',customerName:'',nic:'',addressId:'',phoneNo1:'',phoneNo2:'',objid:null},
        emptyRecord :emptyRecord
    };
    return entityRec;
    
    function emptyRecord() {
        return {customerId:'',customerName:'',nic:'',addressId:'',phoneNo1:'',phoneNo2:'',objid:null};
    }	
}]);/**
 * 
 */