var appsControllers = angular.module('appsControllers', []);
appsControllers.factory('MockAgent', function ($resource) {
    var MockAgent = $resource('http://127.0.0.1:20308/status/', null, { //192.168.43.146
    	query: {method: 'GET', isArray: false }
    });
    return MockAgent;
  });
appsControllers.controller('agentsCtrl', ['$scope', '$http', '$interval', 'MockAgent', function($scope, $http, $interval, MockAgent) {
	console.log("Agents call..");
	$scope.mockAgent = MockAgent.query(function(data){ 
      $scope.agent = {
    		  name: data.name, 
    		  url: data.url,
    	      path: data.path,
    	      cpu: data.cpu,
    	      disk: data.disk
      };
      
      $scope.minions = data.apps;
    });
	
	
   
}]);