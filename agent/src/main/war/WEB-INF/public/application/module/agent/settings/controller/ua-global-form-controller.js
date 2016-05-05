angular.module("backend.settings")
  .controller("UaGlobalFormController", function ($scope, UaCommonStub) {
    $scope.user.uaGlobal = $scope.user.uaGlobal || new UaCommonStub();
    $scope.user.uaGlobal.enable = true;
  });