var appsControllers = angular.module('appsControllers', []);
appsControllers.factory('AgentList', function ($resource) {
    var AgentList = $resource('http://192.168.43.104:20308/minions/', null, { 
    	query: {method: 'GET', isArray: false }
    });
    return AgentList;
  });
appsControllers.controller('agentsCtrl', ['$scope', '$http', '$interval', 'AgentList', function($scope, $http, $interval, AgentList) {
	console.log("Agents call..");
	
	var getAgentList = function() {
		$scope.agentList = [];
		$scope.appsList = [];
		
		AgentList.query(function(data){ 
			angular.forEach(data, function(value, key) {
				if(value.name != null) {
					this.push(value);
				}
			}, $scope.agentList);
		});
	};
	
	getAgentList();
	
	var refresh = $interval(function() {
		getAgentList();
	}, 5000);
	
	$scope.$on('$destroy', function() {
		$interval.cancel(refresh);
    });
	
	$scope.start = function(agentName, appName) {
		var startUrl = 'http://192.168.43.104:20308/control/' + agentName + '/' + appName + "/start"; 
		$http.post(startUrl).
		  success(function(data, status, headers, config) {
		  }).
		  error(function(data, status, headers, config) {
		  });
	};
	$scope.restart = function(agentName, appName) {
		var restartUrl = 'http://192.168.43.104:20308/control/' + agentName + '/' + appName + "/restart"; 
		$http.post(restartUrl).
		  success(function(data, status, headers, config) {
		  }).
		  error(function(data, status, headers, config) {
		  });
	};
	$scope.stop = function(agentName, appName) {
		var stopUrl = 'http://192.168.43.104:20308/control/' + agentName + '/' + appName + "/stop"; 
		$http.post(stopUrl).
		  success(function(data, status, headers, config) {
		  }).
		  error(function(data, status, headers, config) {
		  });
	};
   
}]);