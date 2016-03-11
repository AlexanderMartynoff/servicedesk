angular.module("backend.contractor")
  .controller("FormContractorController", function ($scope, $uibModalInstance, contractorService, record) {
    $scope.contractor = record;

    $scope.close = function(){
      $uibModalInstance.close();
    };

    $scope.new = function(record){
      contractorService.new(record).then(function(response){
        $scope.close();
      });
    };

    $scope.update = function(record){
      contractorService.update(record).then(function(){
        $scope.close();
      });
    };
  });