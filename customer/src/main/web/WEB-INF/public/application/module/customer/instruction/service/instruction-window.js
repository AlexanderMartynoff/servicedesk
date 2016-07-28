export default $uibModal => {
  return {
    open: () => {
      $uibModal.open({
        size: 'lg',
        templateUrl: '/public/application/template/customer/instruction/index.html',
        controller: ($scope, $uibModalInstance) => {
          $scope.close = () => $uibModalInstance.close();
        }
      });
    }
  };
}