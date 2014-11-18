'use strict';

angular.module("codingStyleApp").directive("loader",
    function() {
        return {
            restrict: "E",
            replace: true,
            templateUrl: "/loader/loader.html",
            scope: {
                isActive: "="
            },
            link: function($scope, element, attrs) {
            }
        };
    }
);
