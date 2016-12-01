'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'InvPartInStock',
        record :{id:{invPartNo:'',invPartCostNo:'',siteId:'',invLocationId:''},stockQuantity:'',objid:null},
        emptyRecord :emptyRecord
    };
    return entityRec;
    
    function emptyRecord() {
        return {id:{invPartNo:'',invPartCostNo:'',siteId:'',invLocationId:''},stockQuantity:'',objid:null};
    }	
}]);