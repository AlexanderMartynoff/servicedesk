angular.module("common.dictionary.data")

  .factory("TicketModel", function () {
    return function TicketModel(){
      this.id = null;
      this.title = null;
      this.dateOpen =  new Date();
      this.dateClose = new Date();
      this.description = null;
      this.consumer = null;
      this.author = null;
      this.performer = null;
      this.ticketType = null;
      this.itService = null;
      this.urgency = null;
      this.priority = null;
      this.supportLevel = null;
      this.progress = null;
    }
  });