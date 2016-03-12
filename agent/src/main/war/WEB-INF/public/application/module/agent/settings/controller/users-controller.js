angular.module("backend.settings")
  .controller("UsersController", function ($scope, userEditWindow, uaService) {

    function updateListComplex(){
      uaService.listComplex().then(function (response) {
        $scope.users = response;
      });
    }

    $scope.openUser = function (record) {
      userEditWindow.open(record);
    };

    $scope.$on('onEditComplexUa', updateListComplex);

    updateListComplex();
  });