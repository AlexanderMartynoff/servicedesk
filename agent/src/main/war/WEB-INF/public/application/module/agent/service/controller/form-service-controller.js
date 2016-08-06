export default ($scope, $rootScope, serviceService, record, $uibModalInstance) => {
  $scope.service = record;
  $scope.covered = false;

  $scope.close = $uibModalInstance.close.bind($uibModalInstance);

  $scope.create = record => {
    $scope.covered = true;
    serviceService.create(record).then(response => {
      $scope.covered = false;
      $rootScope.$broadcast('service::change');
      $scope.close();
    });
  };

  $scope.update = record => {
    $scope.covered = true;
    serviceService.update(record).then(response => {
      $scope.covered = false;
      $rootScope.$broadcast('service::change');
      $scope.close();
    });
  };
}