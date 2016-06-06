angular.module("backend.knowledge")
  .controller("IndexKnowledgeController", function ($scope, serviceService, knowledgeDetail, Paginator) {
    $scope.paginator = new Paginator();
  });