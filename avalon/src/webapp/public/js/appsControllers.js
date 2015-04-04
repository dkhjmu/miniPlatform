var appsControllers = angular.module('appsControllers', []);
appsControllers.factory('AgentList', function ($resource) {
    var AgentList = $resource('http://192.168.43.104:20308/minions/', null, { 
    	query: {method: 'GET', isArray: false }
    });
    return AgentList;
  });
appsControllers.controller('agentsCtrl', ['$scope', '$http', '$interval', 'AgentList', function($scope, $http, $interval, AgentList) {
	console.log("Agents call..");
	

	
	$scope.indicatorPercentage = {
		radius : 30,
		percentage :true,
		barColor : "#87CEEB",
	};
	$scope.indicatorCount = {
			radius : 30,
			percentage :false,
			barColor : "#87CEEB",
		};
	$scope.indicatorValue = 70;
			
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
	
//	$scope.remove = function(agentName) {
//		$http.post('http://192.168.43.104:20308/checkOut/' + agentName).
//		  success(function(data, status, headers, config) {
//		    console.log("성공 ");
//		    $scope.agentList.remove(agentName);
//		  }).
//		  error(function(data, status, headers, config) {
//			  console.log("실패 ");
//		  });
//	};
	
	$scope.start = function(agentName, appName) {
		console.log("시작합니다. " + agentName + ", " +  appName);
		var startUrl = 'http://192.168.43.104:20308/control/' + agentName + '/' + appName + "/start"; 
		$http.post(startUrl).
		  success(function(data, status, headers, config) {
		    console.log("성공 ");
		  }).
		  error(function(data, status, headers, config) {
			  console.log("실패 ");
		  });
	};
	$scope.restart = function(agentName, appName) {
		console.log("재시작합니다. ");
		var restartUrl = 'http://192.168.43.104:20308/control/' + agentName + '/' + appName + "/restart"; 
		$http.post(restartUrl).
		  success(function(data, status, headers, config) {
		    console.log("성공 ");
		  }).
		  error(function(data, status, headers, config) {
			  console.log("실패 ");
		  });
	};
	$scope.stop = function(agentName, appName) {
		console.log("정지합니다. ");
		var stopUrl = 'http://192.168.43.104:20308/control/' + agentName + '/' + appName + "/stop"; 
		$http.post(stopUrl).
		  success(function(data, status, headers, config) {
		    console.log("성공 ");
		  }).
		  error(function(data, status, headers, config) {
			  console.log("실패 ");
		  });
	};
   
}]);