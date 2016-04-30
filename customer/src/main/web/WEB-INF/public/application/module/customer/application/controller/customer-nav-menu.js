angular.module('customer.application')
  .controller('CustomerToolbar', function ($scope, logged) {
    $scope.infoPopoverTplUrl = '/public/application/template/customer/application/popover/user-info.html';
    $scope.firstName = logged.uaGlobal.firstName;
    $scope.secondName = logged.uaGlobal.secondName;
    $scope.contractor = logged.uaContextFrontend.contractor;
    $scope.position = logged.uaContextFrontend.position;
  });