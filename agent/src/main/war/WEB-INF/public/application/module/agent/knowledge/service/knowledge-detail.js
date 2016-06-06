angular.module("backend.knowledge")
  .factory('knowledgeDetail', function($uibModal){
    return {
      open: function (record, $scope) {
        return $uibModal.open({
          scope: $scope,
          controller: 'FormKnowledgeController',
          resolve: {record: record},
          size: 'lg',
          backdrop: 'static',
          templateUrl: '/public/application/template/agent/knowledge/form/knowledge.html'
        });
      }
    };
  });