var appsControllers = angular.module('appsControllers', []);
appsControllers.factory('AgentList', function ($resource) {
    var AgentList = $resource('http://127.0.0.1:20308/minions/', null, { //192.168.43.146
    	query: {method: 'GET', isArray: false }
    });
    return AgentList;
  });
appsControllers.controller('agentsCtrl', ['$scope', '$http', '$interval', 'AgentList', function($scope, $http, $interval, AgentList) {
	console.log("Agents call..");
//	$scope.agentList = AgentList.query(function(data){ 
//		angular.forEach(data, function(value, name) {
//			  console.log(name + ': ' + value);
//			  console.log(value.name);
//			});
	$scope.agentList = [];
	$scope.appsList = [];
	//$interval(function() {
        
      
	AgentList.query(function(data){ 
		var values = data;
		angular.forEach(values, function(value, key) {
			  this.push(value);
			}, $scope.agentList);
	});
	//}, 10000);
	$scope.start = function(agentName, appName) {
		console.log("시작합니다. " + agentName + ", " +  appName);
		var startUrl = 'http://192.168.43.146:20308/control/' + agentName + '/' + appName + "/start"; 
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
		var restartUrl = 'http://192.168.43.146:20308/control/' + agentName + '/' + appName + "/restart"; 
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
		var stopUrl = 'http://192.168.43.146:20308/control/' + agentName + '/' + appName + "/stop"; 
		$http.post(stopUrl).
		  success(function(data, status, headers, config) {
		    console.log("성공 ");
		  }).
		  error(function(data, status, headers, config) {
			  console.log("실패 ");
		  });
	};
		
		
//      $scope.agent = {
//    		  name: data.name, 
//    		  url: data.url,
//    	      path: data.path,
//    	      cpu: data.cpu,
//    	      disk: data.disk
//      };
//      
//      $scope.minions = data.apps;
//      $scope.test = data;

	
   
}]);