angular.module("backend.knowledge")
  .controller("FormKnowledgeController", function ($scope, $rootScope, $uibModalInstance,
                                                   ticket, knowledge, knowledgeService) {

    // if edit mode
    if(knowledge){
      $scope.record = knowledge;
    }
    // if create by ticket mode
    else if(ticket){
      $scope.record = {};
      $scope.record.description = ticket.description;
      $scope.record.title = ticket.title;
    }
    // if simple create
    else{
      $scope.record = {};
    }

    $scope.close = function(){
      $uibModalInstance.close();
    };

    $scope.update = function(record){
      $scope.covered = true;
      knowledgeService.update(record).then(function(response){
        $scope.covered = false;
        $scope.close();
        $rootScope.$broadcast('knowledge::change');
      });
    };

    $scope.create = function(record){
      $scope.covered = true;
      knowledgeService.create(record).then(function(response){
        $scope.covered = false;
        $scope.close();
        $rootScope.$broadcast('knowledge::change');
      });
    };
  });