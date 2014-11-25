'use strict';

angular.module("codingStyleApp").controller("DownloadsController",
    function($scope, RequestService) {
        $scope.getDownloadUrl = function(type) {
            if ($scope.project != null) {
                return RequestService.API_URL + "projects/" + $scope.project.id + "/downloads/" + type;
            }
        };
    }
);
