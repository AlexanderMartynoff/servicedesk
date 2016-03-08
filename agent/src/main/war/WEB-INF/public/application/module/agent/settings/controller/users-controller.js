angular.module("backend.settings")
  .controller("UsersController", function ($scope, userEditWindow, uaService) {
    uaService.listComplex().then(function (response) {
      $scope.users = response;
    });

    $scope.openUser = function (record) {
      userEditWindow.open(record);
    };
  });