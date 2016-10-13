'use strict';
 
angular.module('myApp').factory('SalesPartService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_URI;
 
    var factory = {
    	setRestServiceUri:setRestServiceUri,
    	fetchAllSalesParts: fetchAllSalesParts,
        createSalesPart: createSalesPart,
        updateSalesPart:updateSalesPart,
        deleteSalesPart:deleteSalesPart
    };
 
    return factory;
 
    function setRestServiceUri(url) {
    	var deferred = $q.defer();
    	REST_SERVICE_URI = 'http://localhost:8080/Unter/'+ url +'/';   
        return deferred.promise;
    }	
    
    function fetchAllSalesParts() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching SalesParts');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function createSalesPart(SalesPart) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, SalesPart)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating SalesPart');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateSalesPart(SalesPart, salesPartId) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+salesPartId, SalesPart)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating SalesPart');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteSalesPart(salesPartId) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+salesPartId)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting SalesPart');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
}]);