angular.module("backend.settings")
  .controller("UaGlobalFormController", function ($scope, UaCommonStub) {
    $scope.complexUa.uaGlobal = $scope.complexUa.uaGlobal || new UaCommonStub();
    $scope.complexUa.uaGlobal.enable = true;
  });