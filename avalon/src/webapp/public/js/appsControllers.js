var appsControllers = angular.module('appsControllers', []);
appsControllers.factory('Agents', function ($resource) {
    var Agents = $resource('http://192.168.43.146:20308/status', null, {
    	query: {method: 'GET', isArray: false }
    });
    return Agents;
  });
appsControllers.controller('agentsCtrl', ['$scope', '$http', '$interval', 'Agents', function($scope, $http, $interval, Agents) {
	console.log("Agents call..");
	$scope.agentInfo = Agents.query(function(agent){ // 호출시 추가할 파라미터는 없고 {}, 성공 시 콜백 추가 
      console.log(agents.name + ", " + agents.url + "");
    });
    
//    $scope.agents = [
//                     {
//                    	 name: "Agent1",
//                    	 url: "192.168.43.146:20308",
//                    	 path: "path",
//                    	 cpu: "cpu",
//                    	 disk: "disk"
//                     },
//                     {
//                    	 name: "Agent2",
//                    	 url: "192.168.43.146:20308",
//                    	 path: "path",
//                    	 cpu: "cpu",
//                    	 disk: "disk"
//                     },
//                     {
//                    	 name: "Agent3",
//                    	 url: "192.168.43.146:20308",
//                    	 path: "path",
//                    	 cpu: "cpu",
//                    	 disk: "disk"
//                     }
//                     ];
}]);