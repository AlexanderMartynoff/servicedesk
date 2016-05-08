angular.module("backend.service")
  .factory('serviceDetail', function($uibModal){
    return {
      open: function (record, $scope) {
        $uibModal.open({
          scope: $scope,
          controller: 'FormServiceController',
          resolve: {record: record},
          size: 'lg',
          backdrop: 'static',
          templateUrl: '/public/application/template/agent/service/form/service.html'
        });
      }
    };
  });