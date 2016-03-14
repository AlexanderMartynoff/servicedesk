angular.module("backend.settings")
  .controller("UaGlobalFormController", function ($scope, UaCommonStub) {
    $scope.complexUa.uaGlobal = $scope.complexUa.uaGlobal || new UaCommonStub();
    $scope.ua = $scope.complexUa.uaGlobal;
  });