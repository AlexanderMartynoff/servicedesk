export default function ($scope, knowledgeService, knowledgeDetail, Paginator) {
  $scope.knowledgeStore = [];
  $scope.paginator = new Paginator();
  $scope.filter = {};

  $scope.updateKnowledgeStore = function () {
    $scope.knowledgeStore = knowledgeService.list($scope.filter)
      .then(function (response) {
        $scope.paginator.load(response);
      });
  };

  $scope.open = function(record){
    knowledgeDetail.open(undefined, record)
  };

  $scope.$on('knowledge::change', function(e){
    $scope.updateKnowledgeStore();
  });

  $scope.updateKnowledgeStore();
}