'use strict';

angular.module("codingStyleApp").controller("DownloadsController",
    function($scope, RequestService) {
        var downloadUrl = RequestService.API_URL + "projects/" + $scope.project.id + "/downloads/";

        $scope.getDownloadUrl = function(type) {
            return downloadUrl + type;
        };
    }
);
