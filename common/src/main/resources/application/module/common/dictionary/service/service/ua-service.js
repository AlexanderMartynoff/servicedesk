angular.module("common.dictionary.service")
    .factory("uaService", function ($http) {
        return {
            listComplex: function (start, limit) {
                return $http.get('/ua/global', {})
                    .then(function (response) {
                        return response.data;
                    });
            }
        }
    });