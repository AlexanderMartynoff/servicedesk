angular.module("common.dictionary.model")
  .factory("ItServiceModel", function () {
    return function ItServiceModel(){
      this.id = null;
      this.title = null;
      this.description = null;
    }
  });