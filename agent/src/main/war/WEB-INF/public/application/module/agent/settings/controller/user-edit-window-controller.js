angular.module("backend.settings")
  .controller("UserEditWindowController", function ($scope, $rootScope, uaComplex, UaCommonStub,
                                                    $uibModalInstance, UaComplexModel, uaService,
                                                    supportLevelService) {


    $scope.tplDir = '/public/application/template/agent/settings/form/';
    $scope.user = uaComplex || new UaComplexModel();
    $scope.user.uaContextFrontend = $scope.user.uaContextFrontend || new UaCommonStub();
    $scope.user.uaContextBackend = $scope.user.uaContextBackend || new UaCommonStub();
    $scope.user.uaGroupManager = $scope.user.uaGroupManager || new UaCommonStub();

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

    $scope.save = function(complexUa){
      $scope.covered = true;
      uaService.saveComplex(user).then(function(response){
        $rootScope.$broadcast('ua::change');
        $scope.cancel();
      });
    };

    $scope.update = function(complexUa){
      $scope.covered = true;
      uaService.updateComplex(user).then(function(response){
        $rootScope.$broadcast('ua::change');
        $scope.cancel();
      });
    };

    $scope.updateSupportLevelStore();
  });