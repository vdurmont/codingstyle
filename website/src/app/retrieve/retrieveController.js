'use strict';

angular.module("codingStyleApp").controller("RetrieveController",
    function($scope, $location) {
        $scope.projectId = null;

        $scope.retrieveProject = function() {
            console.log("Retrieving " + $scope.projectId);
            $location.path("/projects/" + $scope.projectId);
        };
    }
);
