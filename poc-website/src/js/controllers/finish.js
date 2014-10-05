angular.module("codestyle").controller("FinishCtrl",
	function($scope, $location) {
		$scope.download = function() {
			alert("Not available ;)");
		};

		$scope.next = function() {
			$location.path("/feedback");
		};
	}
);
