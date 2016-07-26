export default ($scope, logged) => {
  $scope.selModule = 'ticket';
  $scope.firstName = logged.getAccount().firstName;
  $scope.secondName = logged.getAccount().secondName;
  $scope.position = logged.logged.agent.position;

  $scope.isAdmin = function(){
    return logged.isAdmin();
  }
}