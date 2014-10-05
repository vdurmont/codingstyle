var app = angular.module("codestyle", ["ngRoute"]);

// TODO this is horrible
var recorder = {};
var isDefined = function(obj) {
	return obj !== undefined && obj !== null;
};

app.config(
	function($routeProvider, $locationProvider) {
		// Location provider config :
		$locationProvider.html5Mode(true);
		// Route provider config :
		$routeProvider
			.when("/", {
				templateUrl: "/partials/home.html",
				controller: "HomeCtrl"
			}).when("/project-name", {
				templateUrl: "/partials/project-name.html",
				controller: "ProjectNameCtrl"
			}).when("/indentation-character", {
				templateUrl: "/partials/indentation-character.html",
				controller: "IndentationCharacterCtrl"
			}).when("/indentation-size", {
				templateUrl: "/partials/indentation-size.html",
				controller: "IndentationSizeCtrl"
			}).when("/indentation-smart-tabs", {
				templateUrl: "/partials/indentation-smart-tabs.html",
				controller: "IndentationSmartTabsCtrl"
			}).when("/more", {
				templateUrl: "/partials/more.html"
			}).when("/finish", {
				templateUrl: "/partials/finish.html",
				controller: "FinishCtrl"
			}).when("/feedback", {
				templateUrl: "/partials/feedback.html"
			}).otherwise({
				templateUrl: "/partials/404.html"
			});
	}
);
