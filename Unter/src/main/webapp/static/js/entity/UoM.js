'use strict';
var entityModule = angular.module('entityModule',[]);
entityModule.factory('EntityService', ['$http', '$q', function($http, $q){

    var entityRec = {
        name   :'UoM',
        record :{uoMId:'', description:'', objid:null},
        emptyRecord :emptyRecord
    };
    return entityRec;
    
    function emptyRecord() {
        return {uoMId:'', description:'', objid:null};
    }	
}]);/**
 * 
 */