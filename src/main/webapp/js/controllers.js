'use strict';
var cncApp = angular.module('cncApp', ['ngRoute']);

// configure our routes
cncApp.config(function($routeProvider) {
	$routeProvider

	// route for the home page
		.when('/', {
			templateUrl : 'view/home.html',
			controller  : 'mainController'
		})

       .when('/rawdata', {
        	templateUrl: 'view/viewRawData.html',
        	controller: 'rawDataController'
      });
});

cncApp.controller('mainController', function($scope) {
        // create a message on application startup
        $scope.message = 'CNC is up and running!';
    });

cncApp.controller('rawDataController', function($scope, $http) {
  $scope.message = 'Viewing InvestAI balance daw data!';
  $http.get('api/rawData/investAI/balance').success(function(data) {
    $scope.rawData = data;
  });
});
