angular.module("common.dictionary.data")
  .factory("ticketService", function ($http, converter) {

    return {
      item: function (id) {
        return $http.get("/ticket/" + id, {}).then(function (response) {
          return converter.in(response.data);
        });
      },

      list: function (params) {
        return $http({
          method: "GET",
          params: params,
          url: "/ticket"
        }).then(function (response) {
          return converter.in(response.data);
        });
      },

      update: function (record) {
        return $http.put("/ticket", converter.out(record)).then(function (response) {
          return response.data;
        });
      },

      new: function (record) {
        return $http.post("/ticket", converter.out(record)).then(function (response) {
          return response.data;
        });
      },

      delete: function (id) {
        return $http.delete("/ticket/" + id).then(function (response) {
          return response.data;
        });
      },

      doEscalation: function (ticket, q) {
        ticket.supportLevelId = parseInt(ticket.supportLevelId) + parseInt(q || 0);
      }
    }
  });