angular.module("common.dictionary.data")
  .factory("contractorService", function ($http) {
    return {
      item: function (id) {
      },

      list: function (start, limit) {
        return $http.get("/contractor/list", {}).then(function (response) {
          return response.data;
        });
      },

      update: function (record) {
      },

      new: function (record) {
      },

      delete: function (id) {
      }
    }
  });