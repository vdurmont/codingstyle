'use strict';

angular.module("codingStyleApp").directive("navbar",
    function() {
        return {
            restrict: "E",
            replace: true,
            templateUrl: "/navbar/navbar.html",
            scope: {},
            link: function($scope, element, attrs) {
            }
        };
    }
);
