export default function($uibModal){
  return {
    open: function (ticket, knowledge, $scope) {
      return $uibModal.open({
        scope: $scope,
        controller: 'FormKnowledgeController',
        resolve: {ticket: ticket, knowledge: knowledge},
        size: 'lg',
        backdrop: 'static',
        templateUrl: '/public/application/template/agent/knowledge/form/knowledge.html'
      });
    }
  };
}