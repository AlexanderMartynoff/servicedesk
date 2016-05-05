angular.module('backend.application')
  .controller('ApplicationToolbar', function($scope, logged) {
    $scope.selModule = 'ticket';

    logged.account = logged.account || {};
    logged.agent = logged.agent || {};

    $scope.firstName = logged.account.firstName;
    $scope.secondName = logged.account.secondName;
    $scope.position = logged.agent.position;
  });