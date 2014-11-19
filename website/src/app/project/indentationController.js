'use strict';

angular.module("codingStyleApp").controller("IndentationController",
    function($scope, ProjectService) {
        var cleanTabSize = function() {
            if ($scope.project.indentation.indent_character == null
                || $scope.project.indentation.indent_character == "SPACE") {
                delete $scope.project.indentation.tab_size;
            }
        };

        $scope.saveIndentation = function() {
            cleanTabSize();
            console.log("Updating: " + JSON.stringify($scope.project.indentation));
            ProjectService.editIndentation($scope.project.id, $scope.project.indentation).then(function(data) {
                $scope.defineProject(data, "indentation");
            }, function(err) {
                // TODO handle error
                console.dir(err);
            });
        };
    }
);
