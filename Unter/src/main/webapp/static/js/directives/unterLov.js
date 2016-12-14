angular.module('generalModule').directive('unterLov', function(){
	return {
		template:   "<div id='myModal'>" +
					"<div class = 'modal-content'>" +
					" <span class='close'>&times;</span>" +
					"<table class='table table-hover'>" +
					"<thead>" +
					"<tr>" +
					"<th ng-repeat='k in ctrl.LovColumsHeads'>" +
					"<span ng-bind='k'></span>" +
					"</th>" +
					"</tr>" +
					"</thead>" +
					"<tbody>" +
					"<tr ng-repeat='u in ctrl.LovRecords'>" +
					"<td><span ng-bind='u.addressId'></span></td>" +
					"</tr>" +
                    "</tbody>" +
                   "</table>" +
                   "</div>" +
                   "</div>"
	};
});