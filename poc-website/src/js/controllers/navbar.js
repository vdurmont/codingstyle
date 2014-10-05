angular.module("codestyle").controller("NavbarCtrl",
  function($scope) {
    // TODO arggggggg
    var checkStarted = function() {
      $scope.isStarted = false;
      if (isDefined(recorder.is_started)) {
        $scope.isStarted = true;
      }
    };

    $scope.$on('$locationChangeStart', function(event) {
      checkStarted();
    });
    checkStarted();
  }
);
