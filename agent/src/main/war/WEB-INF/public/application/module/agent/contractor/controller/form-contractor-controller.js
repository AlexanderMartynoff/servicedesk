/**
 * @fires: contractor::change
 */
angular.module("backend.contractor")
  .controller("FormContractorController", function ($scope, $rootScope, $uibModalInstance,
                                                    contractorService, serviceService, record) {

    $scope.covered = false;
    $scope.contractor = record;
    $scope.contractor.services = $scope.contractor.services || [];

    /**
     * @param el - element
     * @param dir - direction
     *
     * if direction > 0 then for own,
     * if direction < 0 then from own
     */
    $scope.move = function(el, dir){
      var indexFrom, indexTo, from, to;

      if(dir > 0){
        to = $scope.contractor.services;
        from = $scope.services;
      }else if(dir < 0){
        from = $scope.contractor.services;
        to = $scope.services;
      }else{ return }

      indexFrom = from.map(function(e){ return e.id }).indexOf(el.id);
      indexTo = to.map(function(e){ return e.id }).indexOf(el.id);

      if(indexFrom !== -1){
        from.splice(indexFrom, 1);
      }

      if(indexTo === -1){
        to.push(el);
      }
    };

    $scope.updateServiceStore = function(){
      $scope.covered = true;
      serviceService.list().then(function(response){
        $scope.services = response;
        $scope.covered = false;
        $scope.contractor.services.forEach(function(e){ $scope.move(e, 1) });
      });
    };

    $scope.create = function(record){
      $scope.covered = true;
      contractorService.new(record).then(function(response){
        $rootScope.$broadcast('contractor::change');
        $scope.covered = false;
        $scope.close();
      });
    };

    $scope.update = function(record){
      $scope.covered = true;
      contractorService.update(record).then(function(){
        $rootScope.$broadcast('contractor::change');
        $scope.covered = false;
        $scope.close();
      });
    };

    $scope.close = function(){
      $uibModalInstance.close();
    };

    $scope.updateServiceStore();
  });