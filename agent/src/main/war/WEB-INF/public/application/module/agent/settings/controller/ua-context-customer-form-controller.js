angular.module("backend.settings")
  .controller("UaContextCustomerFormController", function ($scope, contractorService, UaCommonStub) {

    $scope.complexUa.uaContextFrontend = $scope.complexUa.uaContextFrontend || new UaCommonStub();

    $scope.updateContractors = function(){
      contractorService.list().then(function(response){
        $scope.contractors = response;
      });
    };

    $scope.updateContractors();
  });