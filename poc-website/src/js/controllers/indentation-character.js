angular.module("codestyle").controller("IndentationCharacterCtrl",
  function($scope, $location) {
    $scope.next = function(character) {
      recorder.indentation = {
        character: character
      };
      if (character === "SPACE") {
        recorder.indentation.smart_tabs = false;
      }
      $location.path("/indentation-size");
    };
  }
);
