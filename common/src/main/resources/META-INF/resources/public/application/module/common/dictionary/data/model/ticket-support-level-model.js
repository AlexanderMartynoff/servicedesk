angular.module("common.dictionary.data")

  .factory("TicketSupportLevelModel", function () {
    return function (){
      this.id = null;
      this.description = null;
      this.number = 0;
      this.title = null;
    }
  });