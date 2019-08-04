/**
 * 
 */
var RidgeApp = angular.module('RidgeApp',['ngRoute','ngFileUpload']);

RidgeApp.config(function($routeProvider){
	$routeProvider
	.when('/home', {
		templateUrl : 'about.html'
	})
	.when('/newItems', {
		templateUrl : 'newItems.html'
	})
	.when('/inventory', {
		templateUrl : 'inventory.html'
	})
	.when('/storeMap', {
		templateUrl : 'storemap.html'
	})
	.when('/customerRequestPage', {
		templateUrl : 'customerRequestPage.html'
	})
	.when('/upload', {
		templateUrl : 'upload.html',
		controller: 'RidgeControllerUpload'
	})
	.when('/admin', {
		templateUrl : 'admin.html'
	})
	.when('/stack', {
		templateUrl : 'stack.html'
	})
	.when('/myResume', {
		templateUrl : 'MyResume.html'
	})
	.otherwise({
		templateUrl : 'about.html'
	});
});

RidgeApp.controller('RidgeController', function($scope, $http) {
	$scope.request = {
			requestNumber : '',
			requestDateTime : '',
			requestProductName : '',
			requestProductDescription : '',
			requestProductImage : '',
			requestCustomerName : '',
			requestPhoneNumber : '',
			requestEmail : ''			
	};
	$scope.showEditDelete = false;
	$scope.showRequestBoard = true;
	$scope.textPreferred = true;
	$scope.callPreferred = false;
	$scope.emailPreferred = true;
	$scope.sentSuccess = false;
	$scope.sendingError = false;
	$scope.showRequestPage = true;	
	$scope.showRequestForm = false;
	
	$scope.buttonClick = function() {
		console.log('button clicked!');
	};
	
	$scope.sendToRequestForm = function() {
		console.log('send to request form');
		$scope.showRequestForm = true;
		$scope.showRequestPage = false;
	};
	
	$scope.sendToRequestPage = function() {
		console.log('send to request page!');
		$scope.showRequestPage = true;
		$scope.showRequestForm = false;
		$scope.textPreferred = true;
		$scope.callPreferred = false;
		$scope.emailPreferred = true;
		$scope.sendingError = false;
		$scope.request = {
				requestNumber : '',
				requestDateTime : '',
				requestProductName : '',
				requestProductDescription : '',
				requestProductImage : '',
				requestCustomerName : '',
				requestPhoneNumber : '',
				requestEmail : ''					
		};
	};
	
	$scope.getAllRequests = function(){
		$scope.requests = [{"title" : "retrieving all movies..."}];
		
		$http.get("/TheRidge/webapi/controller/getAllRequests")
		.then(function(response) {
			$scope.requests = response.data;
			console.log('number of current requests: ' + $scope.requests.length);
		}, function(response) {
			console.log('error HTTP GET requests: ' + response.status);
		});
	}
	
	$scope.logRequest = function(request){
		$scope.jsonObject = angular.toJson(request, false);
		console.log('log: ' + $scope.jsonObject);
	};
	
	$scope.deleteRequest = function(requestToUpdate) {
		console.log('delete movie: ' + $scope.requestToUpdate.requestNumber + ", " + $scope.requestToUpdate.requestProductName);
		$http.delete("/TheRidge/webapi/controller/" + $scope.requestToUpdate.requestNumber)
		.then(function(response) {	
			$scope.updateStatus = 'delete successful';
			console.log('number of movies deleted: ' + response.data.length);
			console.log("request deleted: " + $scope.requestToUpdate.requestProductName + "!!");
			$scope.getAllRequests();
			$scope.sendToRequestBoard();
		}, function(response) {
			console.log('error HTTP DELETE movies: ' + response.status);
			$scope.updateStatus = 'delete error, ' + response.data.message;
		});
	}
	
	$scope.sendRequest = function(request){
		$scope.jsonEmailObject = angular.toJson(request, false);
		console.log('email customers: ' + $scope.jsonEmailObject);
		$http.post("/TheRidge/webapi/controller/emailRequest", $scope.jsonEmailObject)
		.then(
				function success(response) {
					$scope.emailStatus = "success. press 'Clear' to enter new email";	
					$scope.sentSuccess = true;
					$scope.sendToRequestPage();
					
				},
				function error(response) {
					console.log('error sending email, status: ' + response.status);
					$scope.emailStatus = "error. press 'Clear' to try again";
					$scope.sendingError = true;
				}				
		);			
	};
	
	$scope.savePic = function(picFile) {
		console.log('savePic function called');
	};
	$scope.sendToRequestBoard = function(){
		$scope.showEditDelete = false;
		$scope.showRequestBoard = true;
		
	}
	
	$scope.sendToUpdateRequest = function(requestToUpdate){
		console.log('requestToUpdate' + requestToUpdate.requestProductName);
		$scope.requestToUpdate = angular.copy(requestToUpdate);
		$scope.showEditDelete = true;
		$scope.showRequestBoard = false;		
//		$scope.showEditDelete = true;
//		$scope.showSearch = false;
//		$scope.isUpdateButtonDisabled = false;
//		$scope.isDeleteButtonDisabled = false;
//		$scope.updateStatus = '';
	};
		
	$scope.putRequest = function(requestToUpdate){
		$scope.jsonObject = angular.toJson(requestToUpdate, false);
		console.log('update request: ' + $scope.jsonObject);
		
		$http.put("/TheRidge/webapi/controller/updateRequest", $scope.jsonObject)
		.then(
				function success(response) {
					$scope.isUpdateButtonDisabled = true;
					console.log('status: ' + response.status);
					$scope.updateStatus = "update successful" ;
					$scope.getAllRequests();
				},
				function error(response){
					console.log('error, return status: ' + response.status);
					$scope.updateStatus = 'update error, ' + response.data.message;
				}
		);
		
		$scope.sendToRequestBoard();
	};
});
