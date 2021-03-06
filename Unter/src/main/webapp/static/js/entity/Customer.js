'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'Customer',
        record :{customerId:'',customerName:'',nic:'',addressId:'',phoneNo1:'',phoneNo2:'',objid:null},
        emptyRecord :emptyRecord,
        lov :{addressId: 'Address'},
        lovTitles :{addressId: 'Address'} 
    };
    return entityRec;
    
    function emptyRecord() {
        return {customerId:'',customerName:'',nic:'',addressId:'',phoneNo1:'',phoneNo2:'',objid:null};
    }	
}]);/**
 * 
 */