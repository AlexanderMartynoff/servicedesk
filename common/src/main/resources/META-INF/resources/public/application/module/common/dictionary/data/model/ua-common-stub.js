angular.module("common.dictionary.data")

  .factory("UaCommonStub", function () {
    return function UaCommonStub(){
      this.enable = false;
      this.firstName = null;
      this.secondName = null;
    }
  });