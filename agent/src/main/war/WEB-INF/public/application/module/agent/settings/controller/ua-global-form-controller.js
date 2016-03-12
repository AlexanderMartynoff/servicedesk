angular.module("backend.settings")
  .controller("UaGlobalFormController", function ($scope) {
    $scope.complexUa.uaGlobal = $scope.complexUa.uaGlobal || {};
  });