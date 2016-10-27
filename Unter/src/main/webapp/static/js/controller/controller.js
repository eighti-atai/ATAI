'use strict';
 
angular.module('generalModule').controller('RecordController', ['$scope', 'RecordService','EntityService', function($scope, RecordService,EntityService) {
    var self = this;
    
    self.Records=[];
    self.Record ;
    self.EmptyRecord;
    self.submit = submit;
    self.edit   = edit;
    self.remove = remove;
    self.reset  = reset;
    self.init   = init;
    self.entity = '';
 
 
    //fetchAllRecords();
 
    function init(){
    	self.Record= EntityService.record;
    	//self.EmptyRecord = angular.copy(EntityService.record);
    	RecordService.setRestServiceUri(EntityService.name);
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
 
    function updateRecord(Record, objid){
        RecordService.updateRecord(Record, objid)
            .then(
            fetchAllRecords,
            function(errResponse){
                console.error('Error while updating Record');
            }
        );
    }
 
    function deleteRecord(objid){
        RecordService.deleteRecord(objid)
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
            updateRecord(self.Record, self.Record.objid);
            console.log('Record updated with id ', self.Record.objid);
        }
        reset();
    }
 
    function edit(objid){
        console.log('id to be edited', objid);
        for(var i = 0; i < self.Records.length; i++){
            if(self.Records[i].objid === objid) {
                self.Record = angular.copy(self.Records[i]);
                break;
            }
        }
    }
 
    function remove(objid){
        console.log('id to be deleted', objid);
        if(self.Record.objid === objid) {//clean form if the Record to be deleted is shown there.
            reset();
        }
        deleteRecord(objid);
    }
 
 
    function reset(){
    	self.Record = EntityService.emptyRecord();
        $scope.myForm.$setPristine(); //reset Form
    }
 
}]);