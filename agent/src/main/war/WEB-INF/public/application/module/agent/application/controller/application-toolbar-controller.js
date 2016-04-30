angular.module('backend.application')
  .controller('ApplicationToolbar', function($scope, logged){
    $scope.selModule = 'ticket';

    $scope.firstName = logged.uaGlobal.firstName;
    $scope.secondName = logged.uaGlobal.secondName;
    $scope.position = logged.uaContextBackend.position;
  });