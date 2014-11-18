'use strict';

angular.module("codingStyleApp").controller("ProjectDownloadsController",
    function($scope) {
        $scope.clicked = function() {
            console.log("Clicked in downloads controller");
        };
    }
);
