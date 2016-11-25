'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'InventoryLocation',
        record :{id:{siteId:'',invLocationId:''},invLocationType:'',objid:null},
        emptyRecord :emptyRecord
    };
    return entityRec;
    
    function emptyRecord() {
        return {id:{siteId:'',invLocationId:''},invLocationType:'',objid:null};
    }	
}]);