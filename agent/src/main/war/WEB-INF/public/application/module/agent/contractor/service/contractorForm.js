angular.module("backend.contractor")
  .factory('contractorForm', function($uibModal){
    return {
      open: function (record, $scope) {
        $uibModal.open({
          scope: $scope || undefined,
          controller: 'FormContractorController',
          resolve: {record: record},
          size: 'lg',
          backdrop: 'static',
          templateUrl: '/public/application/template/agent/contractor/form/contractor.html'
        });
      }
    };
  });