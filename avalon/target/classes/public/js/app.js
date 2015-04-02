var avalon = angular
	.module('avalon', [
            	    'ngRoute', 
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
			    when('/apps', {
			    	templateUrl: '/partials/apps.html',
			    	controller: 'appsCtrl'
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
