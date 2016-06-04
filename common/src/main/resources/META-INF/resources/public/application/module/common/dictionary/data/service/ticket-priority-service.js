angular.module("common.dictionary.data")
  .factory("ticketPriorityService", function ($http) {
    return {
      list: function (params) {
        return $http({
          method: "GET",
          params: params,
          url: "/ticket/priority"
        }).then(function (response) {
          return response.data;
        });
      }
    }
  });