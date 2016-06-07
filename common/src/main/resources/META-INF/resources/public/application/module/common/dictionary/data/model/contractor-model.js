angular.module("common.dictionary.data")
  .factory("ContractorModel", function () {
    return function ContractorModel(){
      this.id = null;
      this.title = null;
      this.description = null;
      this.fullName = null;
    }
  });