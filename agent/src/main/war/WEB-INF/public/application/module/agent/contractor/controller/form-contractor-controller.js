/**
 * @fires: contractor::change
 */
angular.module("backend.contractor")
  .controller("FormContractorController", function ($scope, $rootScope, $uibModalInstance,
                                                    contractorService, record) {
    $scope.contractor = record;

    $scope.close = function(){
      $uibModalInstance.close();
    };

    $scope.new = function(record){
      contractorService.new(record).then(function(response){
        $rootScope.$broadcast('contractor::change');
        $scope.close();
      });
    };

    $scope.update = function(record){
      contractorService.update(record).then(function(){
        $rootScope.$broadcast('contractor::change');
        $scope.close();
      });
    };
  });