angular.module("common.dictionary.data")
  .factory("UaComplexModel", function () {
    return function (){
      this.uaGlobal = null;
      this.uaContextBackend = null;
      this.uaContextFrontend = null;
      this.uaGroupAdmin = null;
      this.uaGroupManager = null;
      this.uaGroupOperator = null;
      this.uaGroupPerformer = null;
    }
  });