'use strict';
 
angular.module('myApp').controller('SalesPartController', ['$scope', 'SalesPartService', function($scope, SalesPartService) {
    var self = this;
    
    self.SalesParts=[];
 
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
    self.init = init;
 
 
    //fetchAllSalesParts();
 
    function init(url,arr){
    	self.SalesPart= arr;
    	SalesPartService.setRestServiceUri(url);
    	fetchAllSalesParts();
    }
    
    function fetchAllSalesParts(){
        SalesPartService.fetchAllSalesParts()
            .then(
            function(d) {
                self.SalesParts = d;
            },
            function(errResponse){
                console.error('Error while fetching SalesParts');
            }
        );
    }
 
    function createSalesPart(SalesPart){
        SalesPartService.createSalesPart(SalesPart)
            .then(
            fetchAllSalesParts,
            function(errResponse){
                console.error('Error while creating SalesPart');
            }
        );
    }
 
    function updateSalesPart(SalesPart, salesPartId){
        SalesPartService.updateSalesPart(SalesPart, salesPartId)
            .then(
            fetchAllSalesParts,
            function(errResponse){
                console.error('Error while updating SalesPart');
            }
        );
    }
 
    function deleteSalesPart(salesPartId){
        SalesPartService.deleteSalesPart(salesPartId)
            .then(
            fetchAllSalesParts,
            function(errResponse){
                console.error('Error while deleting SalesPart');
            }
        );
    }
 
    function submit() {
        if(self.SalesPart.objid===null){
            console.log('Saving New SalesPart', self.SalesPart);
            createSalesPart(self.SalesPart);
        }else{
            updateSalesPart(self.SalesPart, self.SalesPart.salesPartId);
            console.log('SalesPart updated with id ', self.SalesPart.salesPartId);
        }
        reset();
    }
 
    function edit(salesPartId){
        console.log('id to be edited', salesPartId);
        for(var i = 0; i < self.SalesParts.length; i++){
            if(self.SalesParts[i].salesPartId === salesPartId) {
                self.SalesPart = angular.copy(self.SalesParts[i]);
                break;
            }
        }
    }
 
    function remove(salesPartId){
        console.log('id to be deleted', salesPartId);
        if(self.SalesPart.id === salesPartId) {//clean form if the SalesPart to be deleted is shown there.
            reset();
        }
        deleteSalesPart(salesPartId);
    }
 
 
    function reset(){
    	self.SalesPart={salesPartId:'',description:'',invPartNo:'',invConversionFactor:'',uom:'',priceCategory:'',generalCategory:'',objid:null};
        $scope.myForm.$setPristine(); //reset Form
    }
 
}]);