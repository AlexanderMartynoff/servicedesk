angular.module('backend.application')
  .controller('ApplicationToolbar', function($scope, logged$user) {
    $scope.selModule = 'ticket';

    $scope.firstName = logged$user.data.account.firstName;
    $scope.secondName = logged$user.data.account.secondName;
    $scope.position = logged$user.data.agent.position;

    $scope.isAdmin = function(){
      return logged$user.isAdmin();
    }
  });