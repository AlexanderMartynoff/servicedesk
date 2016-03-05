angular.module("common.dictionary.model")
  .factory("TicketTypeModel", function (id, title, description) {
    return function TicketTypeModel(){
      this.id = null;
      this.title = null;
      this.description = null;
    }
  });