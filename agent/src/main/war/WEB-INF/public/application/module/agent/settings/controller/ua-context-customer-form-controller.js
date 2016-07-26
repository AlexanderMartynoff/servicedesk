export default ($scope, contractorService, UaCommonStub) => {

  $scope.user.uaContextFrontend = $scope.user.uaContextFrontend || new UaCommonStub();

  $scope.updateContractors = function(){
    contractorService.list().then(function(response){
      $scope.contractors = response;
    });
  };

  $scope.updateContractors();
}