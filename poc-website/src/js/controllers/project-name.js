angular.module("codestyle").controller("ProjectNameCtrl",
	function($scope, $location) {
		recorder.is_started = true;

		$scope.projectName = "My project";

		$scope.$watch("projectName", function() {
			$scope.fileName = "TODO";
		});

		$scope.next = function() {
			recorder.project_name = $scope.projectName;
			recorder.project_file_name = $scope.fileName;
			$location.path("/indentation-character");
		};
	}
);
