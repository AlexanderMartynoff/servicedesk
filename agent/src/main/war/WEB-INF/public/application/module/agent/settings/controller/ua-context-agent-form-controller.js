angular.module("backend.settings")
  .controller("UaContextAgentFormController", function ($scope, UaCommonStub) {
    $scope.user.uaContextBackend = $scope.user.uaContextBackend || new UaCommonStub();

    $scope.levels = [
      {name: '1'},
      {name: '2'},
      {name: '3'},
      {name: '4'},
      {name: '5'}
    ];

    $scope.user.uaContextBackend.levelSupport = $scope.levels[0];
  });