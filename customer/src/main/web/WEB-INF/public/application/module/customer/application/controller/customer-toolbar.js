export default ($scope, logged) => {
  $scope.infoPopoverTplUrl = '/public/application/template/customer/application/popover/user-info.html';
  $scope.firstName = logged.logged.account.firstName;
  $scope.secondName = logged.logged.account.secondName;
  $scope.contractor = logged.logged.customer.contractor;
  $scope.position = logged.logged.customer.position;
}