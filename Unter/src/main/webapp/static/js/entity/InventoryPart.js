'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'InventoryPart',
        record :{id:{siteId:'', invPartNo:''}, description:'', uomId:'', reorderLevel:'', safetyStockLevel:'', objid:null},
        emptyRecord :emptyRecord
    };
    return entityRec;
    
    function emptyRecord() {
        return {id:{siteId:'', invPartNo:''}, description:'', uomId:'', reorderLevel:'', safetyStockLevel:'', objid:null};
    }	
}]);