angular.module("backend.settings")
  .controller("UsersController", function ($scope, userEditWindow, uaService, Paginator) {

    function updateListComplex(){
      uaService.listComplex().then(function (response) {
        $scope.paginator.load(response);
      });
    }

    $scope.paginator = new Paginator();

    $scope.openUser = function (record) {
      userEditWindow.open(record);
    };

    $scope.$on('ua::change', updateListComplex);

    updateListComplex();
  });