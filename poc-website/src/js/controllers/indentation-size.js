angular.module("codestyle").controller("IndentationSizeCtrl",
  function($scope, $location) {
    if (recorder.indentation.character === "TAB") {
      $scope.conditional = "a tab";
    } else {
      $scope.conditional = "an indentation";
    }

    $scope.next = function(size) {
      if (recorder.indentation.character === "TAB") {
        $location.path("/indentation-smart-tabs");
      } else {
        $location.path("/more");
      }
    };
  }
);
