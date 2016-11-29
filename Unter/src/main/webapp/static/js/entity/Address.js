'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'Address',
        record :{addressId:'',street:'',city:'',country:'',objid:null},
        emptyRecord :emptyRecord
    };
    return entityRec;
    
    function emptyRecord() {
        return {addressId:'',street:'',city:'',country:'',objid:null};
    }	
}]);