angular.module("common.dictionary.model")
  .factory("UaGlobalModel", function () {
    return function TicketDto(id, title){
      this.id = null;
      this.title = null;
    }
  });