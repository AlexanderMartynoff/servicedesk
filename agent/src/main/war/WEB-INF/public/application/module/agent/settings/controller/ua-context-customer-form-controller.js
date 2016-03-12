angular.module("backend.settings")
  .controller("UaContextCustomerFormController", function ($scope, contractorService) {

    $scope.complexUa.uaContextFrontend = $scope.complexUa.uaContextFrontend || {};

    $scope.updateContractors = function(){
      contractorService.list().then(function(response){
        $scope.contractors = response;
        $scope.complexUa.uaContextFrontend.contractor = $scope.contractors[0];
      });
    };

    $scope.updateContractors();
  });