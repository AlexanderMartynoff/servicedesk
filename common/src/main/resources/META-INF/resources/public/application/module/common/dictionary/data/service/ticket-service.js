export default function ($http, converter, TicketSupportLevelModel) {

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

    doEscalation: function (ticket, offset, supportLevelStore) {
      var number;

      if(!ticket.supportLevel){
        ticket.supportLevel = new TicketSupportLevelModel();
      }

      number = ticket.supportLevel.number + offset;

      supportLevelStore.forEach(function(supportLevel){
        if(supportLevel.number === number){
          ticket.supportLevel = supportLevel;
        }
      });
    }
  }
}