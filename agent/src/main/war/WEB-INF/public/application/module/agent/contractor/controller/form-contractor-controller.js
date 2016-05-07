/**
 * @fires: contractor::change
 */
angular.module("backend.contractor")
  .controller("FormContractorController", function ($scope, $rootScope, $uibModalInstance,
                                                    contractorService, record) {

    $scope.allService = [
      {title: '1C'},
      {title: 'Microsoft office'},
      {title: 'MS Windows'},
      {title: 'Apple Mac PC'},
      {title: 'Debian Linux'}
    ];
    $scope.ownService = [];

    $scope.contractor = record;

    $scope.move = function(e){
      var index;

      if($scope.allService.indexOf(e) === -1){
        index = $scope.ownService.indexOf(e);
        $scope.allService.push(e);
        $scope.ownService.splice(index, 1);
      }else if($scope.ownService.indexOf(e) === -1){
        index = $scope.allService.indexOf(e);
        $scope.ownService.push(e);
        $scope.allService.splice(index, 1);
      }
    };

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