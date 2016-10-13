'use strict';
 
angular.module('myApp').controller('RecordController', ['$scope', 'RecordService', function($scope, RecordService) {
    var self = this;
    
    self.Records=[];
    self.Record;
    self.submit = submit;
    self.edit   = edit;
    self.remove = remove;
    self.reset  = reset;
    self.init   = init;
 
 
    //fetchAllRecords();
 
    function init(url,arr){
    	self.Record= arr;
    	RecordService.setRestServiceUri(url);
    	fetchAllRecords();
    }
    
    function fetchAllRecords(){
        RecordService.fetchAllRecords()
            .then(
            function(d) {
                self.Records = d;
            },
            function(errResponse){
                console.error('Error while fetching Records');
            }
        );
    }
 
    function createRecord(Record){
        RecordService.createRecord(Record)
            .then(
            fetchAllRecords,
            function(errResponse){
                console.error('Error while creating Record');
            }
        );
    }
 
    function updateRecord(Record, recordId){
        RecordService.updateRecord(Record, recordId)
            .then(
            fetchAllRecords,
            function(errResponse){
                console.error('Error while updating Record');
            }
        );
    }
 
    function deleteRecord(recordId){
        RecordService.deleteRecord(recordId)
            .then(
            fetchAllRecords,
            function(errResponse){
                console.error('Error while deleting Record');
            }
        );
    }
 
    function submit() {
        if(self.Record.objid===null){
            console.log('Saving New Record', self.Record);
            createRecord(self.Record);
        }else{
            updateRecord(self.Record, self.Record.recordId);
            console.log('Record updated with id ', self.Record.recordId);
        }
        reset();
    }
 
    function edit(recordId){
        console.log('id to be edited', recordId);
        for(var i = 0; i < self.Records.length; i++){
            if(self.Records[i].recordId === recordId) {
                self.Record = angular.copy(self.Records[i]);
                break;
            }
        }
    }
 
    function remove(recordId){
        console.log('id to be deleted', recordId);
        if(self.Record.id === recordId) {//clean form if the Record to be deleted is shown there.
            reset();
        }
        deleteRecord(recordId);
    }
 
 
    function reset(){
    	self.Record=Record;
        $scope.myForm.$setPristine(); //reset Form
    }
 
}]);