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
        return $http.put("/contractor", record).then(function (response) {
          return response.data;
        });
      },

      new: function (record) {
        return $http.post("/contractor", record).then(function (response) {
          return response.data;
        });
      },

      delete: function (id) {
      }
    }
  });