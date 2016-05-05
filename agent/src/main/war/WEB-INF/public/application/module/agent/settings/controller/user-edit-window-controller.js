angular.module("backend.settings")
  .controller("UserEditWindowController", function ($scope, $rootScope, uaComplex, UaCommonStub,
                                                    $uibModalInstance, UaComplexModel, uaService,
                                                    supportLevelService) {


    $scope.tplDir = '/public/application/template/agent/settings/form/';
    $scope.user = uaComplex || new UaComplexModel();
    $scope.user.customer = $scope.user.customer || new UaCommonStub();
    $scope.user.agent = $scope.user.agent || new UaCommonStub();
    $scope.user.agentManager = $scope.user.agentManager || new UaCommonStub();

    $scope.covered = false;

    $scope.cancel = function () {
      $scope.covered = false;
      $uibModalInstance.close();
    };

    $scope.updateSupportLevelStore = function(){
      supportLevelService.list().then(function(response){
        $scope.supportLevelStore = response;
      });
    };

    $scope.save = function(user){
      $scope.covered = true;
      uaService.saveComplex(user).then(function(response){
        $rootScope.$broadcast('ua::change');
        $scope.cancel();
      });
    };

    $scope.update = function(user){
      $scope.covered = true;
      uaService.updateComplex(user).then(function(response){
        $rootScope.$broadcast('ua::change');
        $scope.cancel();
      });
    };

    $scope.updateSupportLevelStore();
  });