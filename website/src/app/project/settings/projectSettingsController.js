'use strict';

angular.module("codingStyleApp").controller("ProjectSettingsController",
    function($scope, ProjectService) {
        $scope.isNameValid = function() {
            return $scope.project != null
                && $scope.project.name != null
                && $scope.project.name.length > 0
                && $scope.project.name.length < 129;
        };

        $scope.saveSettings = function() {
            ProjectService.editProject($scope.project).then(function(data) {
                $scope.defineProject(data);
            }, function(err) {
                // TODO handle error
                console.dir(err);
            });
        };
    }
);
