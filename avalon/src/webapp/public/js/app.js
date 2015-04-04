var avalon = angular
	.module('avalon', [
            	    'ngRoute', 
            	    'ngResource',
            	    'angularFileUpload', 
            	    'ui.bootstrap',
            	    'mainControllers',
            	    'appsControllers',
            	    'monitorControllers',
            	    'settingsControllers'
            	])
	.config(
		function($routeProvider, $locationProvider) {
		    $locationProvider.html5Mode(true);

		    $routeProvider.
			    when('/Avalon', {
				templateUrl: '/partials/main.html',
				controller: 'mainCtrl'
			    }).
			    when('/Merlins', {
			    	templateUrl: '/partials/agents.html',
			    	controller: 'agentsCtrl'
			    }).
			    when('/Minions', {
			    	templateUrl: '/partials/monitor.html',
			    	controller: 'monitorCtrl'
			    }).
			    
			    when('/settings', {
				templateUrl: '/partials/settings.html',
				controller: 'settingsCtrl'
			    }).
			    otherwise({
				redirectTo: '/Avalon'
			    });
		}
	)
	.run(function($rootScope) {
	    console.log("Start!!");
	});    
