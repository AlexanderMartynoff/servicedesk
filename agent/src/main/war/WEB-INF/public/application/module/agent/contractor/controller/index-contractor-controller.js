/**
 * @listener: contractor::change
 */
angular.module("backend.contractor")
  .controller("IndexContractorController", function ($scope, contractorForm, contractorService, Paginator) {

    $scope.knowledgeStore = [];
    $scope.paginator = new Paginator();

    $scope.updateContractorStore = function () {
      $scope.knowledgeStore = contractorService.list()
        .then(function (response) {
          $scope.paginator.load(response);
        });
    };

    $scope.open = function(record){
      contractorForm.open(record)
    };

    $scope.$on('contractor::change', function(e){
      $scope.updateContractorStore();
    });

    $scope.updateContractorStore();
  });