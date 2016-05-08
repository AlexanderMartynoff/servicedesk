angular.module("backend.service")
  .controller("FormServiceController", function ($scope, $rootScope, serviceService, record, $uibModalInstance) {
    $scope.service = record;
    $scope.covered = false;

    $scope.close = $uibModalInstance.close.bind($uibModalInstance);

    $scope.create = function(record){
      $scope.covered = true;
      serviceService.create(record).then(function(response){
        $scope.covered = false;
        $rootScope.$broadcast('service::change');
        $scope.close();
      });
    };

    $scope.update = function(record){
      $scope.covered = true;
      serviceService.update(record).then(function(response){
        $scope.covered = false;
        $rootScope.$broadcast('service::change');
        $scope.close();
      });
    };
  });