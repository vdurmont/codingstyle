angular.module("codingStyleApp").factory("ProjectService",
    function(RequestService) {
        return {
            get: function(id) {
                return RequestService.get("projects/" + id);
            },
            editProject: function(project) {
                return RequestService.put("projects/" + project.id, null, project);
            },
            editIndentation: function(projectId, indentation) {
                return RequestService.put("projects/" + projectId + "/indentation", null, indentation);
            }
        };
    }
);
