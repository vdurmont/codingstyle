'use strict';

angular.module("codingStyleApp").controller("DownloadsController",
    function($scope) {
        $scope.clicked = function() {
            console.log("Clicked in downloads controller");
        };
    }
);
