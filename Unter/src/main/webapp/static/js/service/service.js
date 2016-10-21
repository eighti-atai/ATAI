'use strict';
 
angular.module('myApp').factory('RecordService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_URI;
 
    var factory = {
    	setRestServiceUri:setRestServiceUri,
    	fetchAllRecords: fetchAllRecords,
        createRecord: createRecord,
        updateRecord:updateRecord,
        deleteRecord:deleteRecord
    };
 
    return factory;
 
    function setRestServiceUri(url) {
    	var deferred = $q.defer();
    	REST_SERVICE_URI = 'http://localhost:8080/Unter/'+ url +'/';   
        return deferred.promise;
    }	
    
    function fetchAllRecords() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Records');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function createRecord(Record) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, Record)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Record');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateRecord(Record, objid) {
    	 console.error('XXXXXXXXXXXXXXXXXXXXXX '+objid);
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+objid, Record)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Record');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteRecord(objid) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+objid)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Record');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
}]);