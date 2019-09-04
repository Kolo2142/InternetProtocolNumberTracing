var app = angular.module('traceApp', []);
app.controller('traceController', function($scope, $http, $location) {
	
	$scope.traceInternetProtocolNumber = function () {
		$scope.traceLoading = true;
		var number = $scope.ipNumber;
		if (number != undefined && number != "") {
			$http.get($location.protocol() + "://" + $location.host()+ ":" + $location.port() + '/process/' + $scope.ipNumber)
		    .then(function(response) {
		        $scope.information = response.data;
		        $scope.traceLoading = false;
		    })
		    .catch(function (data) {
		    	alert("The IP number may be wrong or not registered");
		    	$scope.traceLoading = false;
		    });
		} else {
			alert("The IP number can't be empty");
			$scope.traceLoading = false;
		}
	}
	
	$scope.getFurthestRequest = function () {
		$scope.furthestLoading = true;
		$http.get($location.protocol() + "://" + $location.host()+ ":" + $location.port() + '/furthest')
		.then(function(response) {
	        $scope.furthest = response.data;
	        $scope.furthestLoading = false;
	    });
	}
	
	$scope.getNearestRequest = function () {
		$scope.nearestLoading = true;
		$http.get($location.protocol() + "://" + $location.host()+ ":" + $location.port() + '/nearest')
		.then(function(response) {
	        $scope.nearest = response.data;
	        $scope.nearestLoading = false;
	    });
	}
	
	$scope.getAverageRequests = function () {
		$scope.averageLoading = true;
		$http.get($location.protocol() + "://" + $location.host()+ ":" + $location.port() + '/average')
		.then(function(response) {
	        $scope.average = response.data;
			$scope.averageLoading = false;
	    });
	}
});