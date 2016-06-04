angular.module('customer.application')
  .controller('CustomerToolbar', function ($scope, logged$user) {
    $scope.infoPopoverTplUrl = '/public/application/template/customer/application/popover/user-info.html';
    $scope.firstName = logged$user.data.account.firstName;
    $scope.secondName = logged$user.data.account.secondName;
    $scope.contractor = logged$user.data.customer.contractor;
    $scope.position = logged$user.data.customer.position;
  });