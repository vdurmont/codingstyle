'use strict';

angular.module("codingStyleApp").controller("ProjectController",
    function($location, $rootScope, $routeParams, $scope, ProjectService) {
        var id = $routeParams.projectId;
        var section = $routeParams.section;

        $scope.sections = [
            { url: "settings", title: "General Settings", templateUrl: "project/settings/settings.html" },
            { url: "downloads", title: "Downloads", templateUrl: "project/downloads/downloads.html" }
        ];

        $scope.defineProject = function(data) {
            $scope.project = data;
            // TODO get that from the API
            $scope.project.progress = { percentage: 60 };
            $scope.initalProject = JSON.stringify($scope.project);
        };

        ProjectService.get(id).then(function(data) {
            $scope.defineProject(data);
        }, function(err) {
            // TODO handle error
            console.dir(err);
        });

        var resolveCurrentSection = function(sectionUrl) {
            var selected = $scope.sections[0];
            if (sectionUrl != null) {
                var lowerSectionUrl = section.toLowerCase();
                $scope.sections.forEach(function(section) {
                    if (section.url == lowerSectionUrl) {
                        selected = section;
                    }
                });
            }
            return selected;
        };

        $scope.currentSection = resolveCurrentSection(section);

        $scope.isDirty = function() {
            return $scope.initalProject != JSON.stringify($scope.project);
        };

        $scope.$on('$locationChangeStart', function(event, next, current) {
            if ($scope.isDirty()) {
                if (!confirm("You have unsaved changes. Are you sure you want to leave this page?")) {
                    event.preventDefault();
                }
            }
        });
    });
