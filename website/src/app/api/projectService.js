angular.module("codingStyleApp").factory("ProjectService",
    function(RequestService) {
        return {
            get: function(id) {
                return RequestService.get("projects/" + id);
            }
        };
    }
);
