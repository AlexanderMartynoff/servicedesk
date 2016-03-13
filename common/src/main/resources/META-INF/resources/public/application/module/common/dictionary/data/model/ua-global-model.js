angular.module("common.dictionary.data")
  .factory("UaGlobalModel", function () {
    return function UaGlobalModel(id, title){
      this.id = id;
      this.title = title;
    }
  });