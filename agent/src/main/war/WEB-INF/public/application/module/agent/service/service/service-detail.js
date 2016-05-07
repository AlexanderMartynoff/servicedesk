angular.module("backend.service")
  .factory('serviceDetail', function($uibModal){
    return {
      open: function (record, $scope) {
        $uibModal.open({
          scope: $scope || undefined,
          controller: 'FormServiceController',
          resolve: {record: record},
          size: 'lg',
          backdrop: 'static',
          templateUrl: '/public/application/template/agent/contractor/form/service.html'
        });
      }
    };
  });