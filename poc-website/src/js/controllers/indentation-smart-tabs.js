angular.module("codestyle").controller("IndentationSmartTabsCtrl",
  function($scope, $location) {
    $scope.next = function(use) {
      $location.path("/more");
    };
  }
);
