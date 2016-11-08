'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'Site',
        record :{siteId:'',addressId:'',phoneNo1:'',phoneNo2:'',objid:null},
        emptyRecord :emptyRecord
    };
    return entityRec;
    
    function emptyRecord() {
        return {siteId:'',addressId:'',phoneNo1:'',phoneNo2:'',objid:null};
    }	
}]);