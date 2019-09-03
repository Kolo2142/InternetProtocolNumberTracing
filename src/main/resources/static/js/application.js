var app = angular.module('traceApp', []);
app.controller('traceController', function($scope, $http, $location) {
	
	$scope.traceInternetProtocolNumber = function () {
		$http.get($location.protocol() + "://" + $location.host()+ ":" + $location.port() + '/process/' + $scope.ipNumber)
	    .then(function(response) {
	        $scope.information = response.data;
	    })
	    .catch(function (data) {
	    	alert("The IP number may be wrong, empty or not registered");
	    });
	}
	
	$scope.getFurthestRequest = function () {
		$http.get($location.protocol() + "://" + $location.host()+ ":" + $location.port() + '/furthest')
		.then(function(response) {
	        $scope.furthest = response.data;
	    });
	}
	
	$scope.getNearestRequest = function () {
		$http.get($location.protocol() + "://" + $location.host()+ ":" + $location.port() + '/nearest')
		.then(function(response) {
	        $scope.nearest = response.data;
	    });
	}
	
	$scope.getAverageRequests = function () {
		$http.get($location.protocol() + "://" + $location.host()+ ":" + $location.port() + '/average')
		.then(function(response) {
	        $scope.average = response.data;
	    });
	}
});