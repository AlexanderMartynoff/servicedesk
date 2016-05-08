angular.module("backend.service")
  .controller("IndexServiceController", function ($scope, serviceService, serviceDetail, Paginator) {
    $scope.paginator = new Paginator();

    $scope.updateServiceStore = function(){
      serviceService.list().then(function(response){
        $scope.paginator.load(response);
      });
    };

    $scope.open = function(record){
      serviceDetail.open(record);
    };

    $scope.$on('service::change', $scope.updateContractorStore);

    $scope.updateServiceStore();
  });