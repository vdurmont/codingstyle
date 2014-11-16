'use strict';

angular.module("codingStyleApp").controller("ProjectController",
    function($routeParams, $scope, ProjectService) {
        var id = $routeParams.projectId;

        ProjectService.get(id).then(function(data) {
            $scope.project = data;
        }, function(err) {
            // TODO handle error
            console.dir(err);
        });
    }
);
