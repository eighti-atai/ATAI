'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'InventoryPartCost',
        record :{id:{invPartNo:'',invPartCostNo:''},cost:'',objid:null},
        emptyRecord :emptyRecord
    };
    return entityRec;
    
    function emptyRecord() {
        return {id:{invPartNo:'',invPartCostNo:''},cost:'',objid:null};
    }	
}]);