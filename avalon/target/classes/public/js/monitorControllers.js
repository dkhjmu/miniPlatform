var monitorControllers = angular.module('monitorControllers', []);

monitorControllers.controller('monitorCtrl', ['$scope', '$http', '$resource', '$interval',  function($scope, $http, $resource, $interval) {
    console.log("loading monitorControllers!!!");
    console.log("test");
    var monitor = $resource(
    	    "./monitor", null, {
    	      update: {
    	        method: 'PUT'
    	      }
    	    });
    	    
    monitor.query(function(data){
    	console.log(data);
    });
    
}]);