angular.module("common.dictionary.service")
    .factory("userGroupService", function ($http, converter) {
        return {
            // get single
            item: function (id) {
                return $http.get("/backend/ticket/" + id, {})
                    .then(function (response) {
                        return converter.in(response.data);
                    }.bind(this));
            },

            // get list
            list: function (start, limit) {
                return $http.get('/backend/user-group/list', {})
                    .then(function (response) {
                        return response.data;
                    }.bind(this));
            },

            // update existing
            update: function (record) {
                return $http.put('/backend/user-group/update', record)
                    .then(function (response) {
                        return response.data;
                    }.bind(this));
            },

            // create new
            new: function (record) {
                return $http.post("/backend/user-group/new", record)
                    .then(function (response) {
                        return response.data;
                    }.bind(this));
            }
        }
    });