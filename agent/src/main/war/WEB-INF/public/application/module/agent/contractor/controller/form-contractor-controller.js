export default ($scope, $rootScope, $uibModalInstance,
                contractorService, serviceService, record) => {

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
  $scope.move = (el, dir) => {
    var indexFrom, indexTo, from, to;

    if(dir > 0){
      to = $scope.contractor.services;
      from = $scope.services;
    }else if(dir < 0){
      from = $scope.contractor.services;
      to = $scope.services;
    }else{ return }

    indexFrom = from.map(e => e.id).indexOf(el.id);
    indexTo = to.map(e => e.id ).indexOf(el.id);

    if(indexFrom !== -1){
      from.splice(indexFrom, 1);
    }

    if(indexTo === -1){
      to.push(el);
    }
  };

  $scope.updateServiceStore = () => {
    $scope.covered = true;
    serviceService.list().then(response => {
      $scope.services = response;
      $scope.covered = false;
      $scope.contractor.services.forEach(e => $scope.move(e, 1));
    });
  };

  $scope.create = record => {
    $scope.covered = true;
    contractorService.new(record).then(response => {
      $rootScope.$broadcast('contractor::change');
      $scope.covered = false;
      $scope.close();
    });
  };

  $scope.update = record => {
    $scope.covered = true;
    contractorService.update(record).then(() => {
      $rootScope.$broadcast('contractor::change');
      $scope.covered = false;
      $scope.close();
    });
  };

  $scope.close = () => $uibModalInstance.close();
  $scope.updateServiceStore();
}