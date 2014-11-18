app.config(
    function($routeProvider, $locationProvider, $sceDelegateProvider) {
        // Location provider config :
        $locationProvider.html5Mode(true);

        // Route provider config :
        $routeProvider
            .when("/", {
                templateUrl: "/home/home.html",
                controller: "HomeController"
            }).when("/projects/get", {
                templateUrl: "/retrieve/retrieve.html",
                controller: "RetrieveController"
            }).when("/projects/:projectId", {
                templateUrl: "/project/project.html",
                controller: "ProjectController"
            }).when("/projects/:projectId/:section", {
                templateUrl: "/project/project.html",
                controller: "ProjectController"
            }).otherwise({ templateUrl: "/404/404.html" });
    }
);
