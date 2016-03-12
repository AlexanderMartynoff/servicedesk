angular.module("backend.settings")
  .controller("UaContextAgentFormController", function ($scope) {
    $scope.complexUa.uaContextBackend = {};

    $scope.levels = [
      {name: "1"},
      {name: "2"},
      {name: "3"},
      {name: "4"},
      {name: "5"}
    ];

    $scope.complexUa.uaContextBackend.levelSupport = $scope.levels[0];
  });