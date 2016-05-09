angular.module('customer.application')
  .controller('CustomerToolbar', function ($scope, logged) {
    $scope.infoPopoverTplUrl = '/public/application/template/customer/application/popover/user-info.html';
    $scope.firstName = logged.account.firstName;
    $scope.secondName = logged.account.secondName;
    $scope.contractor = logged.customer.contractor;
    $scope.position = logged.customer.position;
  });