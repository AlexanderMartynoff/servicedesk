angular.module("common.dictionary.data")
  .factory("TicketTypeModel", function () {
    return function TicketTypeModel(id, title, description){
      this.id = id;
      this.title = title;
      this.description = description;
    }
  });