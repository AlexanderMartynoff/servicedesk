export default ($scope, userEditWindow, uaService, Paginator) => {

  $scope.paginator = new Paginator();

  function updateListComplex(){
    uaService.listComplex().then(function (response) {
      $scope.paginator.load(response);
    });
  }

  $scope.openUser = function (record) {
    userEditWindow.open(record);
  };

  $scope.$on('ua::change', updateListComplex);

  updateListComplex();
}