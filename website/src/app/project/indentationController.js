'use strict';

angular.module("codingStyleApp").controller("IndentationController",
    function($scope, ProjectService) {
        $scope.isNameValid = function() {
            return $scope.project != null
                && $scope.project.name != null
                && $scope.project.name.length > 0
                && $scope.project.name.length < 129;
        };

        $scope.saveIndentation = function() {
            ProjectService.editIndentation($scope.project.id, $scope.project.indentation).then(function(data) {
                $scope.project.indentation = data;
            }, function(err) {
                // TODO handle error
                console.dir(err);
            });
        };
    }
);
