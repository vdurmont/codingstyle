angular.module("codingStyleApp").factory("RequestService",
    function($q, $http) {
        var apiUrl = "/api/";
        var buildParams = function(params) {
            if (params == null) {
                return {};
            }
            return params;
        };

        return {
            get: function(url, params) {
                var p = buildParams(params);
                var deferred = $q.defer();
                $http.get(apiUrl + url, p).success(function(data, status, headers) {
                    deferred.resolve(data);
                }).error(function(err, status) {
                    deferred.reject(err);
                });
                return deferred.promise;
            },
            post: function(url, params) {
                var p = buildParams(params);
                var deferred = $q.defer();
                $http.post(apiUrl + url, null, p).success(function(data, status, headers) {
                    deferred.resolve(data);
                }).error(function(err, status) {
                    deferred.reject(err);
                });
                return deferred.promise;
            },
            put: function(url, params) {
                var p = buildParams(params);
                var deferred = $q.defer();
                $http.put(apiUrl + url, null, p).success(function(data, status, headers) {
                    deferred.resolve(data);
                }).error(function(err, status) {
                    deferred.reject(err);
                });
                return deferred.promise;
            }
        };
    }
);
