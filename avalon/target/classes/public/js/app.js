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
			    when('/main', {
				templateUrl: '/partials/main.html',
				controller: 'mainCtrl'
			    }).
			    when('/monitor', {
			    	templateUrl: '/partials/monitor.html',
			    	controller: 'monitorCtrl'
			    }).
			    when('/agents', {
			    	templateUrl: '/partials/agents.html',
			    	controller: 'agentsCtrl'
			    }).
			    when('/settings', {
				templateUrl: '/partials/settings.html',
				controller: 'settingsCtrl'
			    }).
			    otherwise({
				redirectTo: '/main'
			    });
		}
	)
	.run(function($rootScope) {
	    console.log("Start!!");
	});    
